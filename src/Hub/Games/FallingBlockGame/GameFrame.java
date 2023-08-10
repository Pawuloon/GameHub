package Hub.Games.FallingBlockGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Hub.Hub;

public class GameFrame extends JFrame
{
    public GameFrame()
    {
        super("Block Game");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                var choice = JOptionPane.showConfirmDialog(null, "Do you want to go back to hub ?"
                        , "Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION)
                {
                    var frame = new Hub();
                    frame.setVisible(true);
                    dispose();
                }
            }
        });
        setLayout(new BorderLayout());

        // Icon
        var img = new ImageIcon("src\\Graphics\\img_6.jpg");
        setIconImage(img.getImage());

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
