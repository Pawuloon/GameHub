package Snake;

import javax.swing.*;
import java.awt.*;

public class SnakePanel extends JPanel
{

    public SnakePanel()
    {
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setFocusable(true);
        requestFocus();


    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);
    }
}
