package PingPong;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel
{
    public int xVelocity;
    public int yVelocity;


    public Ball(int x, int y, int width, int height)
    {
        setBounds(x, y, width, height);
        xVelocity = 2;
        yVelocity = 2;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(
                new Color(generateRandomColor(), generateRandomColor(), generateRandomColor()));
        g.fillOval(0, 0, getWidth(), getHeight());
    }


    public int generateRandomColor()
    {
        return (int) (Math.random() * 255);
    }

    public boolean isColliding(Paddle paddle)
    {
        return paddle.getBounds().intersects(getBounds());
    }


    public void reverseXVelocity()
    {
        xVelocity = -xVelocity;
    }

    public void reverseYVelocity()
    {
        yVelocity = -yVelocity;
    }

    public int getxVelocity()
    {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }


}
