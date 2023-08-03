package Flappy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlapFrame extends JFrame implements ActionListener, KeyListener
{

    private Bird bird;
    private Obstacle obstacle;

    private int score;

    private final Timer loop;


    public FlapFrame()
    {
        // TODO Finish this
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        pack();
        setLocationRelativeTo(null);
        setFocusable(true);

        addKeyListener(this);
        // Initialization
        bird = new Bird(200, 300);
        obstacle = new Obstacle(800, 300);
        score = 0;


        // Game loop
        loop = new Timer(20,this);
        loop.start();
    }

    // Update for game state
    private void update()
    {
        bird.fall();
        obstacle.update();

        if (bird.collision(obstacle))
            gameOver();

        if (!obstacle.pass(bird))
             score++;

        if (bird.outOfBounds())
            gameOver();
    }

    private void gameOver()
    {
        loop.stop();
        JOptionPane.showMessageDialog(this, "Game Over! Score: " + score);

        var ans = JOptionPane.showConfirmDialog(this, "Play again?");
        if (ans == JOptionPane.YES_OPTION)
        {
            bird = new Bird(200, 300);
            obstacle = new Obstacle(800, 300);
            score = 0;
            loop.start();
        }
        else
            System.exit(0);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        // Background
        g.setColor(Color.GREEN);
        g.fillRect(0, 550, 800, 50);

        // Bird
        g.setColor(Color.RED);
        g.fillRect(bird.getX(), bird.getY(), bird.getSize(), bird.getSize());

        // Obstacle
        g.setColor(Color.BLUE);
        g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());

        // Score
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 10);

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        update();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            bird.move();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
