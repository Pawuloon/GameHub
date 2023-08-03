package Flappy;

public class Bird
{
    // TODO Finish this
    private final int x;
    private int y;
    private int speed;
    private final int size = 30;

    public Bird(int x, int y)
    {
        this.x = x;
        this.y = y;
        speed = 0;
    }

    public void move()
    {
        speed = -20;
    }

    public void fall()
    {
        speed += 1;
        y += speed;
    }

    public boolean collision(Obstacle o)
    {
        if (x + size > o.getX() && x < o.getX() + o.getWidth())
        {
            return y < o.getY() || y + size > o.getY() + o.getHeight();
        }
        return false;
    }

    public boolean outOfBounds()
    {
        return y >= 600 - size;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize()
    {
        return size;
    }
}
