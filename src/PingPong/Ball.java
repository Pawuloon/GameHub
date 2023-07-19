package PingPong;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel
{
   private int xVelocity;
   private int yVelocity;


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
        setBackground(Color.BLACK);
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
        xVelocity = -xVelocity - ((int )(Math.random() * 2));
    }

    public void reverseYVelocity()
    {
        yVelocity = -yVelocity - ((int )(Math.random() * 2));
    }

    public int getxVelocity()
    {
        return xVelocity + ((int )(Math.random() * 2));
    }

    public int getyVelocity() {
        return yVelocity + ((int )(Math.random() * 2));
    }


}
