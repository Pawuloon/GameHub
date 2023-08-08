package Login;

import DataCoder.Coder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.DriverManager;
import java.sql.SQLException;


public class RegisterFrame extends JFrame
{
    // Think about adding an email verification code to verify the use
    public RegisterFrame()
    {
        setTitle("Register");
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        pack();
        setLocationRelativeTo(null);
        setFocusable(true);


        // Text fields for username and password
        var field1 = new JTextField("Username:");
        field1.setToolTipText("Username");
        field1.setBackground(Color.BLACK);
        field1.setForeground(Color.WHITE);
        field1.setFont(new Font("Arial", Font.PLAIN, 20));
        field1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                field1.setText("");
            }
        });

        var field2 = new JTextField("Password:");
        field2.setToolTipText("Password");
        field2.setBackground(Color.BLACK);
        field2.setForeground(Color.WHITE);
        field2.setFont(new Font("Arial", Font.PLAIN, 20));
        field2.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                field2.setText("");
            }
        });
        // Fields panel

        var panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(field1);
        panel.add(field2);

        // Button for registering
        var button = new JButton("Register");

        // Change into Db stuff
        button.addActionListener(e ->
        {
            registerUser(field1.getText(), field2.getText());
            JOptionPane.showMessageDialog(null, "User registered");
            var frame = new LoginFrame();
            frame.setVisible(true);
            dispose();
        });

        // Add buttons to frame
        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }



    // Inserting user into database and file
    private void registerUser(String username, String password)
    {
        LoginFrame.tableCreator();
        if (username.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter a username and password");
        }
        else if (LoginFrame.userCheck(username, password))
        {
            JOptionPane.showMessageDialog(null, "User already exists");
        }
        else
        {
            var url = "jdbc:h2:D:/java/GameHub/src/DB/db";
            var sqlCommand = "INSERT INTO PUBLIC.PLATFORM VALUES(DEFAULT,?,?)";
            try(var connection = DriverManager.getConnection(url))
            {
                try(var prep = connection.prepareStatement(sqlCommand))
                {
                    prep.setString(1, username);
                    prep.setString(2, password);
                    prep.executeUpdate();
                }
                catch (SQLException e)
                {
                    System.err.println("Error: " + e.getMessage());
                }
            }
            catch (SQLException e)
            {
                System.err.println("Error: " + e.getMessage());
            }
            // File backup
            var path = "src\\TxtFIles\\UsersData.txt";
            try(var writer = new BufferedWriter(new FileWriter(path)))
            {
                var data = Coder.encrypt(username,password);
                assert data != null;
                writer.write(data + '\n');
            }
            catch (Exception e)
            {
                System.err.println("Error with writing to the file: " + e.getMessage());
            }
        }

    }
}
