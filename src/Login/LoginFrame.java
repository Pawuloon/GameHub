package Login;

import javax.swing.*;
import java.awt.*;
import java.sql.DriverManager;

import Hub.Hub;

public class LoginFrame extends JFrame
{
    // TODO Finnish login frame
    public LoginFrame()
    {
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        pack();

        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setFocusable(true);

        var field1 = new JTextField("");
        var field2 = new JTextField("");

        var button = buttonAction(field1, field2);

        add(field1, BorderLayout.NORTH);
        add(field2, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

    }

    private JButton buttonAction(JTextField field1, JTextField field2)
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
    private void adminInsert()
    {
        var url = "jdbc:h2:D:/java/GameHub/src/DB/db";
        tableCreator();
        try(var conn = DriverManager.getConnection(url))
        {
            var sql = "INSERT INTO PUBLIC.PLATFORM(USERNAME, PASSWORD) VALUES(?, ?)";
            try (var stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, "ad");
                stmt.setString(2, "ad");
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
    private void tableCreator()
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
    // TODO fix it to work with database
    private boolean userCheck(String username, String password)
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
        return false;
    }
}
