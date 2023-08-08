package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Objects;

import DataCoder.Coder;
import Hub.Hub;

public class LoginFrame extends JFrame
{
    // TODO improve graphical representation
    public LoginFrame()
    {
        setTitle("Login");
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        pack();

        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setFocusable(true);

        // Text fields for username and password
        var field1 = new JTextField("Username:");
        field1.setToolTipText("Username or maybe something else ?");
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
        field2.setToolTipText("That's not a password :D");
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

        // Buttons for login and register
        var button = buttonLogin(field1, field2);

        var button2 = new JButton("Register");
        button2.addActionListener(e->
        {
            var frame = new RegisterFrame();
            frame.setVisible(true);
            dispose();
        });

        // Combine labels and text fields
        var labelFieldPanel = new JPanel();
        labelFieldPanel.setBackground(Color.BLACK);
        labelFieldPanel.setLayout(new GridLayout(2, 1));
        labelFieldPanel.add(field1);
        labelFieldPanel.add(field2);

        // Buttons for the panel
        var buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(button);
        buttonPanel.add(button2);

        // Add contents to frame
        add(labelFieldPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);


    }

    private JButton buttonLogin(JTextField field1, JTextField field2)
    {
        var button = new JButton("Login");

        button.addActionListener(e ->
        {
            if (userCheck(field1.getText(), field2.getText()))
            {
                JOptionPane.showMessageDialog(null, "Login successful !!!!");
                var hub = new Hub();
                hub.setVisible(true);
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong username or password");
            }

        });
        return button;
    }



    // Insert admin into database
    private static void adminInsert()
    {
        var url = "jdbc:h2:D:/java/GameHub/src/DB/db";
        tableCreator();
        try(var conn = DriverManager.getConnection(url))
        {
            var sql = "INSERT INTO PUBLIC.PLATFORM(USERNAME, PASSWORD) VALUES(?, ?)";
            try (var stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, System.getenv("adminName"));
                stmt.setString(2, System.getenv("adminPassword"));
                stmt.execute();
                System.out.println("Admin inserted");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Creates table if it doesn't exist
    protected static void tableCreator()
    {
        var url = "jdbc:h2:D:/java/GameHub/src/DB/db";

        try(var conn = DriverManager.getConnection(url))
        {
            var sql = "CREATE TABLE IF NOT EXISTS PUBLIC.PLATFORM" +
                    "(ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "USERNAME VARCHAR(255) NOT NULL," +
                    "PASSWORD VARCHAR(255) NOT NULL" +
                    ")";
            try (var stmt = conn.prepareStatement(sql))
            {
                stmt.execute();
                System.out.println("Table created");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Checks if user exists in database
    protected static boolean userCheck(String username, String password)
    {
        tableCreator();
        adminInsert();

        var url = "jdbc:h2:D:/java/GameHub/src/DB/db";

        try(var conn = DriverManager.getConnection(url))
        {

            var sql = "SELECT * FROM PUBLIC.PLATFORM WHERE USERNAME = ? AND PASSWORD = ?";
            try (var stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, username);
                stmt.setString(2, password);
                try (var rs = stmt.executeQuery())
                {
                    if (rs.next()) {
                        var user = rs.getString("USERNAME");
                        var pass = rs.getString("PASSWORD");
                        return user.equals(username) && pass.equals(password);
                    }
                }
            }
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }

        // Check by file backup
        var path = "src\\TxtFIles\\UsersData.txt";
        try(var reader = new BufferedReader(new FileReader(path)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                var data = line.split(" ");

                var fin = Objects.requireNonNull(Coder.decrypt(data[0], data[1])).split(" ");
                if (fin[0].equals(username) && fin[1].equals(password))
                {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            System.err.println("Error with reading from the file: " + e.getMessage());
        }
        return false;
    }
}
