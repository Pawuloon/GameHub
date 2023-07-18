package PingPong;

import javax.swing.*;
import java.awt.*;



public class Paddle extends JPanel
{
    private int speed;

    public Paddle(int x, int y, int width, int height, int speed)
    {
        setBounds(x, y, width, height);
        setBackground(Color.BLACK);
        this.speed = speed;
    }

    public int getSpeed()
    {
        return speed;
    }
}
