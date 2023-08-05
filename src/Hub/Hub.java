package Hub;

import FallingBlockGame.GameFrame;
import FlappyReversed.FlapFrame;

import PingPong.Pong;
import Snake.Snak;
import TicTac.Tic;

import javax.swing.*;
import java.awt.*;


public class Hub extends JFrame
{
    public Hub()
    {
        setTitle("Game Hub");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Main panel
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));

        // Background
        var backgroundPanel = new BackgroundPane();

        // Buttons
        var buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(100, 100));
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(Color.BLACK);

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
            var tic = new Tic();
            tic.setVisible(true);
            dispose();
        });

        // Snake game button
        var button3 = new JButton("Snake");
        button3.setPreferredSize(new Dimension(100, 90));
        button3.addActionListener(e ->
        {
            var snake = new Snak();
            snake.setVisible(true);
            dispose();
        });

        // Flappy Bird game button
        var button4 = new JButton("Flappy Bird");
        button4.setPreferredSize(new Dimension(100, 90));
        button4.addActionListener(e ->
        {
            var flappy = new FlapFrame();
            flappy.setVisible(true);
            dispose();
        });


        var button5 = new JButton("Block Game");
        button5.setPreferredSize(new Dimension(100, 90));
        button5.addActionListener(e ->
        {
            var block = new GameFrame();
            block.setVisible(true);
            dispose();
        });

        var button6 = new JButton("Instructions");
        button6.setPreferredSize(new Dimension(100, 90));
        button6.addActionListener(e ->
        {
            var instructions = new Instruction();
            instructions.setVisible(true);
            dispose();
        });


        buttonPanel.add(button);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);

        add(backgroundPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);

    }

    // For test purposes only
    private void primitiveLogin()
    {
        var username = JOptionPane.showInputDialog(getParent(), "Enter username");
        var password = JOptionPane.showInputDialog(getParent(), "Enter password");
        if (username == null || password == null) {
            System.exit(0);
        } else if (username.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Welcome " + username);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
            System.exit(0);
        }
    }


}
