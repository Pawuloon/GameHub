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
            if (field1.getText().equals("ad") || field2.getText().equals("ad"))
            {
                JOptionPane.showMessageDialog(null, "Login successful !!!!");
                var hub = new Hub();
                hub.setVisible(true);
                dispose();
            }
            else if (!userCheck(field1.getText(), field2.getText()))
            {
                JOptionPane.showMessageDialog(null, "Wrong username or password");
            }

        });
        return button;
    }


    private boolean userCheck(String username, String password)
    {
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
