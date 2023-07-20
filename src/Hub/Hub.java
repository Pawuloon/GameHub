package Hub;

import PingPong.Pong;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Hub extends JFrame
{
    // TODO Add login method
    public Hub()
    {
        setTitle("Game Hub");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);


        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));

        var images = new ArrayList<Image>();
        images.add(new ImageIcon("src\\Graphics\\Screenshot 2023-04-01 235113.png").getImage());
        images.add(new ImageIcon("src\\Graphics\\Screenshot 2023-04-01 235143.png").getImage());
        images.add(new ImageIcon("src\\Graphics\\Screenshot 2023-04-01 235232.png").getImage());
        images.add(new ImageIcon("src\\Graphics\\Screenshot 2023-04-01 235310.png").getImage());

        var backgroundPanel = new BackgroundPane(images);
        backgroundPanel.setPreferredSize(new Dimension(800, 600));

        getContentPane().add(backgroundPanel, BorderLayout.CENTER);

        var timer = new Timer(1000, e -> backgroundPanel.nextImage());
        timer.start();
        // Placeholder for now, change into switching pictures later



        var buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(100, 100));

        // Pong game button
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


        var button2 = new JButton("Tic Tac Toe");
        button2.setPreferredSize(new Dimension(100, 100));
        button2.addActionListener(e ->
        {
            // TODO Add Tic Tac Toe
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);

    }
}
