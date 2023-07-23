package Hub;

import PingPong.Pong;

import javax.swing.*;
import java.awt.*;


public class Hub extends JFrame
{
    // TODO Add login method
    public Hub()
    {
        setTitle("Game Hub");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // TODO Change it later into a proper login, from db
        // Login window
        var username = JOptionPane.showInputDialog(getParent(),"Enter username");
        var password = JOptionPane.showInputDialog(getParent(),"Enter password");
        if (username == null || password == null)
        {
            System.exit(0);
        }
        else if (username.equals("admin") && password.equals("admin"))
        {
            JOptionPane.showMessageDialog(null, "Welcome " + username);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
            System.exit(0);
        }

        // Main panel
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));

        // Background
        var backgroundPanel = new BackgroundPane();

        // Buttons
        var buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(100, 100));

        // Pong game button
        var button = new JButton("Ping Pong");
        button.setPreferredSize(new Dimension(100, 90));
        button.addActionListener(e ->
        {
            var pong = new Pong();
            pong.setVisible(true);
            dispose();
        });



        // Tic Tac Toe game button
        var button2 = new JButton("Tic Tac Toe");
        button2.setPreferredSize(new Dimension(100, 90));
        button2.addActionListener(e ->
        {
            // TODO Add Tic Tac Toe
        });

        buttonPanel.add(button);
        buttonPanel.add(button2);

        add(backgroundPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);

    }
}
