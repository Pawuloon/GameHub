package Hub.Games.PingPong;

import Hub.Hub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Pong extends JFrame implements KeyListener
{
    // TODO Add Changing functioning menu for ai and 2 player

    private final Paddle paddle1;
    private final Paddle paddle2;
    private final Ball ball;

    private final Score score;

    private Timer timer;


    private final String endScoreSet;
    public Pong()
    {
        setTitle("Pong");
        setPreferredSize(new Dimension(800, 600));
        getContentPane().setBackground(Color.BLACK);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addKeyListener(this);
        pack();
        setLocationRelativeTo(null);

        // End score
        endScoreSet = JOptionPane.showInputDialog(null, "Enter the score to win");

        if (endScoreSet.matches("[1-9]+"))
        {
            var endScore = Integer.parseInt(endScoreSet);
            if (endScore > 0 && endScore < 100)
            {
                JOptionPane.showMessageDialog(null, "The score to win is " + endScore);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid input");
                System.exit(0);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid input");
            System.exit(0);
        }

        // Restart Panel
        var resetPanel = new JPanel();
        resetPanel.setPreferredSize(new Dimension(100, 100));
        resetPanel.setBackground(Color.BLACK);
        resetPanel.setLayout(new BorderLayout());
        resetPanel.setOpaque(true);
        resetPanel.setVisible(true);

        // Restart button
        JButton restart = new JButton();
        restart.setPreferredSize(new Dimension(100, 100));
        restart.setBackground(Color.BLACK);

        restart.addActionListener(e ->
        {
            dispose();
            var pong = new Pong();
            pong.setVisible(true);
            dispose();
        });
        resetPanel.add(restart, BorderLayout.CENTER);


        paddle1 = new Paddle(10, 0, 40, 100, 30);
        paddle2 = new Paddle(735, 0, 40, 100, 30);
        ball = new Ball(395, 295, 40, 40);
        score = new Score(0,0);

        add(paddle1);
        add(paddle2);
        add(ball);
        add(score);
        add(resetPanel);
        setFocusable(true);

        start();
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                timer.stop();
                var choice = JOptionPane.showConfirmDialog(null, "Do you want to go back to hub ?", "Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION)
                {
                    var frame = new Hub();
                    frame.setVisible(true);
                    dispose();
                }
                else if (choice == JOptionPane.NO_OPTION)
                {
                    timer.start();
                }
            }
        });

    }


    // TODO Fix ball collision with paddle and wall
    private void moveBall()
    {
        if (ball.isColliding(paddle1) || ball.isColliding(paddle2))
        {
            ball.setxVelocity(ball.reverseXVelocity());
        }
        else if (ball.getY() < 0 || ball.getY() > getHeight() - ball.getHeight())
        {
            ball.setyVelocity(ball.reverseYVelocity());
        }
        else if (ball.getX() <= 0)
        {

            randomSpeed();
            score.setValue2(score.getValue2() + 1);
            score.repaint();
        }
        else if (ball.getX() >= getWidth() - ball.getWidth())
        {
            randomSpeed();
            score.setValue(score.getValue() + 1);
            score.repaint();
        }

        ball.setLocation(ball.getX() + ball.getxVelocity(), ball.getY() + ball.getyVelocity());

    }
    private void start()
    {
        randomSpeed();
        timer = new Timer(10, e ->
        {
            moveBall();
            repaint();
            if (score.getValue() == Integer.parseInt(endScoreSet) || score.getValue2() == Integer.parseInt(endScoreSet))
            {
                var winner = score.getValue() == Integer.parseInt(endScoreSet) ? "Player 1" : "Player 2";
                JOptionPane.showMessageDialog(null, winner + " won");
                System.exit(0);
            }
        });
        timer.start();
    }


    public void randomSpeed()
    {
        var x = ball.getX();
        var y = ball.getY();

        x = getWidth() / 2 - ball.getWidth() / 2;
        y = getHeight() / 2 - ball.getHeight() / 2;

        ball.setLocation(x, y);

        ball.setxVelocity(ball.getxVelocity());
        ball.setyVelocity(ball.getyVelocity());
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
