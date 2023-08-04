package Login;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame
{
    public LoginFrame()
    {
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        pack();
        setLocationRelativeTo(null);
        setFocusable(true);

        var field1 = new JTextField("Username");
        var field2 = new JTextField("Password");

        var button = new JButton("Login");
        // Change into Db stuff
        button.setEnabled(field1.getText().equals("Username") && field2.getText().equals("Password"));
        button.addActionListener(e -> {

        });
    }
}
