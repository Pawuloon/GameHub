package Hub.Games.FallingBlockGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class Square extends JButton
{
    private boolean isAlive;
    private int score;
    public Square(int score)
    {
        super();
        this.score = score;
        setPreferredSize(new Dimension(30, 30));
        setFocusable(false);
        requestFocus();
        setColor();
        setOpaque(true);

        this.isAlive = true;
        addActionListener(e ->
        {
            setAlive(false);
            setVisible(false);
            setEnabled(false);
            sound();
            this.score++;
        });

    }

    //    Think about this method
    private static void sound()
    {
        try
        {
            System.out.println("Sound");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public void setAlive(boolean alive)
    {
        isAlive = alive;
    }

    public void setColor()
    {
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);

        setBackground(new Color(r, g, b));
    }

    public int getScore()
    {
        return score;
    }
}
