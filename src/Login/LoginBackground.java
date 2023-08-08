package Login;

import javax.swing.*;
import java.awt.*;

public class LoginBackground extends JPanel
{
    private final Image[] images;
    private int ind;
    public LoginBackground()
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));
        images = new Image[]
                {
                        new ImageIcon("src\\Graphics\\img_4.jpg").getImage(),
                        new ImageIcon("src\\Graphics\\img_5.jpg").getImage(),
                        new ImageIcon("src\\Graphics\\img_6.jpg").getImage(),

                };
        ind = 0;
        var timer = new Timer(8000, e ->
        {
            ind++;
            if (ind == images.length)
                ind = 0;
            repaint();
        });
        timer.start();
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        var image = images[ind];
        g.drawImage(image, 0, 0,getWidth(),getHeight(), this);
    }
}
