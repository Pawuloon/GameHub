package FallingBlockGame;

import javax.swing.*;
import java.awt.*;

public class Points extends JTextField
{
    public Points()
    {
        super("Points: 0 Time: ");
        setFont(new Font("Arial", Font.BOLD, 20));
        setBackground(Color.BLUE);
        setEditable(false);
        setLocation(400, 300);
        setPreferredSize(new Dimension(800, 50));
        setForeground(Color.RED);
    }
}
