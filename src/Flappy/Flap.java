package Flappy;

import javax.swing.*;
import java.awt.*;


public class Flap extends JFrame
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

}
