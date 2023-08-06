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

        var button = new JButton("Login");

        // Change into Db stuff
        button.setEnabled(userCheck(field1.getText(), field2.getText()));
        button.addActionListener(e ->
        {
            JOptionPane.showMessageDialog(null, "Login successful !!!!");
            var hub = new Hub();
            hub.setVisible(true);
            dispose();
        });

        add(field1, BorderLayout.NORTH);
        add(field2, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

    }



    private boolean userCheck(String username, String password)
    {
        var url = "jdbc:h2:D:/java/GameHub/src/DB/db";

        try(var conn = DriverManager.getConnection(url))
        {

            var sql = "SELECT * FROM PLATFORM WHERE USERNAME = ? AND PASSWORD = ?";
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
