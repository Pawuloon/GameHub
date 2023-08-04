package FlappyReversed;

import java.awt.*;

public class Obstacle extends Rectangle
{
    private int x;
    private final int y;
    private final int width;
    private int height;


    public Obstacle(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = (int) (Math.random() * 400 + 200);
    }

    // Update for game state
    public void update()
    {
        x -= 5;

        if (x + width < 0)
        {
            x = 800;
            height = (int) (Math.random() * 400 + 200);
        }
    }

    // Collision detection
    public boolean pass(Bird b)
    {
        if (b.getX() + b.getS() > x && b.getX() < x + width)
        {
            return b.getY() < y || b.getY() + b.getS() > y + height;
        }
        return false;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
