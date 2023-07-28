package Snake;

import javax.swing.*;
import java.awt.*;

public class Snak extends JFrame
{
    // TODO Finish this
    public Snak()
    {
        setTitle("Snake");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);

        var panel = new SnakePanel();

        add(panel, BorderLayout.CENTER);


    }
}
