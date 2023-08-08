package Login;



import javax.swing.*;
import java.awt.*;

public class Login extends JFrame
{
    public Login()
    {
        setTitle("Login");
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setBackground(Color.BLACK);
        pack();

        setLocationRelativeTo(null);
        setFocusable(true);

        var button = new JButton("Login");
        button.setSize(100, 100);
        var button2 = new JButton("Register");
        button2.setSize(100, 100);

        // Login Frame
        button.addActionListener(e ->
        {
            var frame = new LoginFrame();
            frame.setVisible(true);
            dispose();
        });

        // Register Frame
        button2.addActionListener(e ->
        {
            var frame = new RegisterFrame();
            frame.setVisible(true);
            dispose();
        });

        // Add buttons to frame
        add(button, BorderLayout.NORTH);

        // TODO Change it into something else


        add(new LoginBackground(), BorderLayout.CENTER);

        add(button2, BorderLayout.SOUTH);
    }



}
