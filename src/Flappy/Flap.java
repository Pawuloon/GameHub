package Flappy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Flap extends JFrame implements ActionListener
{
    // TODO Finish this
    public Flap()
    {
        setTitle("Flappy Bird");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);

        pack();
        setLocationRelativeTo(null);
        setFocusable(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
