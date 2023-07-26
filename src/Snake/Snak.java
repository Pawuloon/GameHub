package Snake;

import javax.swing.*;
import java.awt.*;

public class Snak extends JFrame
{
    public Snak()
    {
        setTitle("Snake");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pack();
    }
}
