package Hub;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BackgroundPane extends JPanel
{
    private final List<Image> images;
    private int index;

    public BackgroundPane()
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));
        this.images = List.of(
                new ImageIcon("src\\Graphics\\img.png").getImage(),
                new ImageIcon("src\\Graphics\\img_1.png").getImage(),
                new ImageIcon("src\\Graphics\\img_2.png").getImage(),
                new ImageIcon("src\\Graphics\\img_3.png").getImage()
        );
        index = 0;
        var timer = new Timer(8000, e ->
        {
            index++;
            if (index == images.size())
                index = 0;
            repaint();
        });
        timer.start();
        setVisible(true);

    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(images.get(index), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
