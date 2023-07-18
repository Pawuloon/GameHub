package Hub;

import PingPong.Pong;

import javax.swing.*;
import java.awt.*;

public class Hub extends JFrame
{
    public Hub()
    {
        setName("Game Hub");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());


        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(Color.RED);
        add(panel, BorderLayout.NORTH);


        var buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(100, 100));

        var button = new JButton("Ping Pong");
        button.setPreferredSize(new Dimension(100, 60));
        button.addActionListener(e ->
        {
            var pong = new Pong();
            pong.setVisible(true);
            dispose();
        });

        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
