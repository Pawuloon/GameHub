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
        xVelocity = 4;
        yVelocity = 4;
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


    public int reverseXVelocity()
    {
        xVelocity = -(xVelocity + ((int )(Math.random() * 1)));
        return xVelocity;
    }

    public int reverseYVelocity()
    {
        yVelocity = -(yVelocity + ((int )(Math.random() * 1)));
        return yVelocity;
    }




    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getxVelocity()
    {
        return xVelocity + ((int )(Math.random() * 2));
    }

    public int getyVelocity() {
        return yVelocity + ((int )(Math.random() * 2));
    }


}
