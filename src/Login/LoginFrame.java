package Login;

import javax.swing.*;
import java.awt.*;
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

        var field1 = new JTextField("Username");
        var field2 = new JTextField("Password");

        var button = new JButton("Login");
        // Change into Db stuff
        button.setEnabled(field1.getText().equals("Username") && field2.getText().equals("Password"));
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
}
