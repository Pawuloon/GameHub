package Flappy;

import javax.swing.*;
import java.awt.*;

public class Flap extends JFrame
{
    public Flap()
    {
        setTitle("FlappyBird");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pack();
    }
}
