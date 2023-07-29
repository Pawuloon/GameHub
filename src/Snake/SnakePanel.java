package Snake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SnakePanel extends JPanel
{
    private ArrayList<Point> snake;
    private Point fruit;

    private void draw(Graphics graphics)
    {
        // Background
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, getWidth(), getHeight());

        // Snake
        graphics.setColor(Color.RED);


    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }


}
