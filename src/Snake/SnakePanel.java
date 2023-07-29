package Snake;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class SnakePanel extends JPanel
{


    private void draw(Graphics graphics)
    {
        // Background
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, 800, 600);

        // Fruit
        graphics.setColor(Color.GREEN);
        graphics.fillRect(Snak.getFruit().x, Snak.getFruit().y, 20, 20);

        // Snake
        graphics.setColor(Color.RED);
        for (var point : Snak.getSnake())
             graphics.fillRect(point.x, point.y, 20, 20);

        if (!Snak.isRunning())
        {
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Arial", Font.BOLD, 50));
            graphics.drawString("Game Over", 300, 300);
        }
    }


    // Generate random color
    private Color randomColor()
    {
        var random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }


}
