package Snake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class SnakePanel extends JPanel
{



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
