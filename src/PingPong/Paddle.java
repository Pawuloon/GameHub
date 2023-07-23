package PingPong;

import javax.swing.*;
import java.awt.*;



public class Paddle extends JPanel
{
    private final int speed;

    public Paddle(int x, int y, int width, int height, int speed)
    {
        setBounds(x, y, width, height);
        setBackground(Color.WHITE);
        this.speed = speed;
    }

    public int getSpeed()
    {
        return speed;
    }


}
