package Hub;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BackgroundPane extends JPanel
{
//    TODO Fix this class
    private final List<Image> images;
    private int index = 0;

    public BackgroundPane(List<Image> images)
    {
        this.images = images;
        setVisible(true);

    }

    public void nextImage()
    {
        index++;
        if (index >= images.size())
        {
            index = 0;
        }
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(images.get(index), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
