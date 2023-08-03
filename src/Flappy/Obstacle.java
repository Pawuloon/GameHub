package Flappy;

public class Obstacle
{
    // TODO Finish this

    private int x;
    private final int y;
    private final int width;
    private int height;

    private int gap;

    private int speed;

    public Obstacle(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = (int) (Math.random() * 400 + 120);
    }

    public void update()
    {
        x -= speed;

        if (x < -width)
        {
            x = 800;
            height = (int) (Math.random() * 400 + 120);
        }
    }

    public boolean pass(Bird b)
    {
        if (b.getX() + b.getSize() > x && b.getX() < x + width)
        {
            return b.getY() < y || b.getY() + b.getSize() > y + height;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
