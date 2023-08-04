package Login;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame
{
    public Login()
    {
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        pack();
        setLocationRelativeTo(null);
        setFocusable(true);

        var button = new JButton("Login");
        var button2 = new JButton("Register");


        add(button);
        add(button2);
    }

}
