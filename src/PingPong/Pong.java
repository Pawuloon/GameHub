package PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends JFrame implements KeyListener
{
    // TODO Add Changing functioning menu

    private Paddle paddle1;
    private Paddle paddle2;
    private Ball ball;
    public Pong()
    {
        setName("Pong");
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        pack();
        setLocationRelativeTo(null);


        paddle1 = new Paddle(100, 0, 40, 100, 10);
        paddle2 = new Paddle(700, 0, 40, 100, 10);
        ball = new Ball(395, 295, 40, 40);

        setLayout(null);
        add(paddle1);
        add(paddle2);
        add(ball);
        setFocusable(true);
        start();

    }


    private void moveBall()
    {
        if (ball.isColliding(paddle1) || ball.isColliding(paddle2))
        {
            ball.reverseXVelocity();
        }
        else if (ball.getY() < 0 || ball.getY() >= getHeight() - ball.getHeight())
        {
            ball.reverseYVelocity();
        }
        else if (ball.getX() <= 0 || ball.getX() >= getWidth() - ball.getWidth())
        {
            // TODO Add score
            ball.setLocation(395, 295);
        }
        ball.setLocation(ball.getX() + ball.getxVelocity(), ball.getY() + ball.getyVelocity());
    }
    private void start()
    {
        var timer = new Timer(10, e ->
        {
            moveBall();
            repaint();
        });
        timer.start();

    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            paddle1.setLocation(paddle1.getX(), paddle1.getY() - paddle1.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_S)
        {
            paddle1.setLocation(paddle1.getX(), paddle1.getY() + paddle1.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            paddle2.setLocation(paddle2.getX(), paddle2.getY() - paddle2.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            paddle2.setLocation(paddle2.getX(), paddle2.getY() + paddle2.getSpeed());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
