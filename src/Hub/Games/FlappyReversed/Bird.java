package Hub.Games.FlappyReversed;

import java.awt.*;

public class Bird extends Rectangle
{
    // TODO Finish this
    private final int x;
    private int y;
    private int speed;
    private final int size = 20;

    public Bird(int x, int y)
    {
        this.x = x;
        this.y = y;
        speed = 0;
    }

    // Jumping speed
    public void move()
    {
        speed = -15;
    }

    // Update for game state for bird
    public void fall()
    {
        speed += 1;
        y += speed;
    }

    // Collision detection
    public boolean collision(Obstacle o)
    {
        if (getX() + getS() > o.getX() && getX() < o.getX() + o.getWidth())
            return getY() < o.getY() || getY() + getS() > o.getY() + o.getHeight();

        return false;
    }

    // Out of bounds check
    public boolean outOfBounds()
    {
        return y >= 600 - size || y <= 0;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public double getS()
    {
        return size;
    }
}
