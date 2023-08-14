package Hub.Games.FlappyReversed;

import Hub.Hub;

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

        super("Flappy Reverse Bird");
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        pack();
        setLocationRelativeTo(null);
        setFocusable(true);

        addKeyListener(this);

        // Icon
        var img = new ImageIcon("src\\Graphics\\img_6.jpg");
        setIconImage(img.getImage());


        // Initialization
        bird = new Bird(20, 10);
        obstacle = new Obstacle(300, 10);
        score = 0;


        // Game loop
        loop = new Timer(15,this);
        loop.start();
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                loop.stop();
                var choice = JOptionPane.showConfirmDialog(null, "Do you want to go back to hub ?"
                        , "Exit", JOptionPane.YES_NO_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION)
                {
                    var frame = new Hub();
                    frame.setVisible(true);
                    dispose();
                }
                else if (choice == JOptionPane.NO_OPTION)
                {
                    loop.start();
                }
                else if (choice == JOptionPane.CANCEL_OPTION)
                {
                    System.exit(0);
                }
            }
        });
    }

    // Update for game state
    private void update()
    {
        bird.fall();
        obstacle.update();

        if (bird.getY() <= 0 || bird.getY() >= 600 - bird.getS())
            gameOver();

        if (bird.collision(obstacle))
            gameOver();

        if (!obstacle.pass(bird))
        {
            score++;
        }

        if (bird.outOfBounds())
            gameOver();
    }

    private void gameOver()
    {
        loop.stop();
        JOptionPane.showMessageDialog(this, "Game Over! Score: " + (score / 10));

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
        double birdDrawX = bird.getX() - bird.getS() / 2;
        double birdDrawY = bird.getY() - bird.getS() / 2;
        g.fillRect((int) birdDrawX, (int) birdDrawY, (int) bird.getS(), (int) bird.getS());

        // Obstacle
        g.setColor(Color.BLUE);
        g.fillRect((int) obstacle.getX(), (int) obstacle.getY(),(int) obstacle.getWidth(),(int) obstacle.getHeight());

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
