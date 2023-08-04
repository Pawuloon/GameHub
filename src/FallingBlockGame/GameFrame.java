package FallingBlockGame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
    public GameFrame()
    {
        super("Block Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        var choice = JOptionPane.showInputDialog("Enter hardness lvl (1-4): ");
        var points = new Points();
        switch (choice)
        {
            case "2" -> add(new GamePanel(25, "Medium", points,20));
            case "3" -> add(new GamePanel(35, "Hard", points,25));
            case "4" -> add(new GamePanel(45, "Impossible", points,30));
            default -> add(new GamePanel(20, "Easy", points,15));
        }

        add(points, BorderLayout.SOUTH);

        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
