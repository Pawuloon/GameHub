package FallingBlockGame;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel
{
    private final Image[] images;
    private int ind;
    public Background()
    {
        setLayout(new BorderLayout());
        images = new Image[]
        {
                new ImageIcon("src\\Blocks\\BlockGame\\images\\img.png").getImage(),
                new ImageIcon("src\\Blocks\\BlockGame\\images\\img_1.png").getImage(),
                new ImageIcon("src\\Blocks\\BlockGame\\images\\img_2.png").getImage(),
                new ImageIcon("src\\Blocks\\BlockGame\\images\\img_3.png").getImage(),
        };
        setPreferredSize(new Dimension(800, 600));
        ind = 0;
        var timer = new Timer(8000, e ->
        {
            ind++;
            if (ind == images.length)
                ind = 0;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        var image = images[ind];
        g.drawImage(image, 0, 0,getWidth(),getHeight(), this);
    }
}
