package Login;

import javax.swing.*;
import java.awt.*;


public class RegisterFrame extends JFrame
{
    // Think about adding an email verification code to verify the use
    public RegisterFrame()
    {
        setPreferredSize(new java.awt.Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        pack();
        setLocationRelativeTo(null);
        setFocusable(true);

        var field1 = new JTextField("Username");
        var field2 = new JTextField("Password");


        var button = new JButton("Register");

        // Change into Db stuff
        button.addActionListener(e ->
        {
            // TODO Finnish db register
        });

        // Add buttons to frame
        add(field1, BorderLayout.NORTH);
        add(field2, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }
}
