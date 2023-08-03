package Flappy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FlapPanel extends JPanel
{

    private Bird bird;
    private Obstacle obstacle;

    private int score;


    public FlapPanel()
    {
        // TODO Finish this
        setPreferredSize(new Dimension(800, 600));

        // Initialization
        bird = new Bird(200, 300);
        obstacle = new Obstacle(800, 300);
        score = 0;

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_SPACE)
                {
                    bird.move();
                }
            }
        });
    }

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

    }
}
