package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Snak extends JFrame
{


    private static ArrayList<Point> snake;

    private static Point fruit;
    private int direction;
    private static boolean isRunning;

    // TODO Finish this
    public Snak()
    {
        setTitle("Snake");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);

        var panel = new SnakePanel();

        // Adding components
        add(panel, BorderLayout.CENTER);

        snake = new ArrayList<>();
        snake.add(new Point(400, 300));
        fruit = generateFruit();
        direction = 1;
        isRunning = true;

        // Game loop
        gameLoop();

        // Key listener
        addKeyListener(new KeyListener()
        {

            @Override
            public void keyPressed(KeyEvent e)
            {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_UP ->
                    {
                        if (direction != 2)
                            direction = 0;
                    }
                    case KeyEvent.VK_DOWN ->
                    {
                        if (direction != 0)
                            direction = 2;
                    }
                    case KeyEvent.VK_LEFT ->
                    {
                        if (direction != 1)
                            direction = 3;
                    }
                    case KeyEvent.VK_RIGHT ->
                    {
                        if (direction != 3)
                            direction = 1;
                    }
                }
            }
            @Override
            public void keyTyped(KeyEvent e)
            {

            }



            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setFocusable(true);

    }


    // Move snake
    private void move()
    {
        var head = snake.get(0);
        Point newHead;

        switch (direction)
        {
            case 0 -> newHead = new Point(head.x, head.y - 20);
            case 1 -> newHead = new Point(head.x + 20, head.y);
            case 2 -> newHead = new Point(head.x, head.y + 20);
            case 3 -> newHead = new Point(head.x - 20, head.y);
            default ->
            {
            return;
            }
        }
        snake.add(0, newHead);

        if (newHead != fruit)
            snake.remove(snake.size() - 1);
        else
            fruit = generateFruit();

    }

    // Check for collision
    private void collision()
    {
        var head = snake.get(0);
        if (head.x < 0 || head.x > getWidth() || head.y < 0 || head.y > getHeight())
        {
            isRunning = false;
            return;
        }

        for (int i = 1; i < snake.size() ; i++)
        {
            if (head.equals(snake.get(i)))
            {
                isRunning = false;
                return;
            }
        }

    }

    // Generate fruit
    private Point generateFruit()
    {
        var rand = new Random();
        return new Point(rand.nextInt(getWidth() / 20) * 20,
                         rand.nextInt(getHeight() / 20) * 20);
    }


    private void gameLoop()
    {
        var timer = new Timer(100, e ->
        {
            if (!isRunning)
                return;
            move();
            collision();
            repaint();
        });
        timer.start();
    }


    public static ArrayList<Point> getSnake()
    {
        return snake;
    }

    public static Point getFruit()
    {
        return fruit;
    }

    public static boolean isRunning()
    {
        return isRunning;
    }
}
