package Login;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame
{
    // TODO Finnish login and implement database
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

        button.addActionListener(e -> {
            var frame = new LoginFrame();
            frame.setVisible(true);
            dispose();
        });

        add(button);
        add(button2);
    }

}
