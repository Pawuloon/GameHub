package PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends JFrame implements KeyListener
{
    // TODO Add Changing functioning menu

    private final Paddle paddle1;
    private final Paddle paddle2;
    private final Ball ball;

    private final Score score;
    public Pong()
    {
        setTitle("Pong");
        setPreferredSize(new Dimension(800, 600));
        getContentPane().setBackground(Color.BLACK);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        pack();
        setLocationRelativeTo(null);

        paddle1 = new Paddle(10, 0, 40, 100, 30);
        paddle2 = new Paddle(735, 0, 40, 100, 30);
        ball = new Ball(395, 295, 40, 40);
        score = new Score(0,0);

        setLayout(null);
        add(paddle1);
        add(paddle2);
        add(ball);
        add(score);
        setFocusable(true);

        start();

    }


    // TODO Fix ball collision with paddle and wall
    private void moveBall()
    {
        if (ball.isColliding(paddle1) || ball.isColliding(paddle2))
        {
            ball.reverseXVelocity();
        }
        else if (ball.getY() <= 0 || ball.getY() >= getHeight() - ball.getHeight())
        {
            ball.reverseYVelocity();
        }
        else if (ball.getX() <= 0)
        {
            // TODO Add score
            ball.setLocation(395, 295);
            score.setValue2(score.getValue2() + 1);
            score.repaint();
        }
        else if (ball.getX() >= getWidth() - ball.getWidth())
        {
            // TODO Add score
            ball.setLocation(395, 295);
            score.setValue(score.getValue() + 1);
            score.repaint();
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
            if (paddle1.getY() <= 0)
            {
                return;
            }
            paddle1.setLocation(paddle1.getX(), paddle1.getY() - paddle1.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_S)
        {
            if (paddle1.getY() >= getHeight() - paddle1.getHeight())
            {
                return;
            }
            paddle1.setLocation(paddle1.getX(), paddle1.getY() + paddle1.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            if (paddle2.getY() <= 0)
            {
                return;
            }
            paddle2.setLocation(paddle2.getX(), paddle2.getY() - paddle2.getSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if (paddle2.getY() >= getHeight() - paddle2.getHeight())
            {
                return;
            }
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
