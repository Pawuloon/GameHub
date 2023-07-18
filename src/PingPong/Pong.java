package PingPong;

import javax.swing.*;
import java.awt.*;

public class Pong extends JFrame
{
    public Pong()
    {
        setName("Pong");
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


    }


    @Override
    public void paintComponents(Graphics g)
    {
        super.paintComponents(g);
    }
}
