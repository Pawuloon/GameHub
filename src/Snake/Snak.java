package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Snak extends JFrame
{



    private int direction;
    private boolean isRunning;

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

        // Adding components
        add(panel, BorderLayout.CENTER);
        addKeyListener(new KeyListener()
        {

            @Override
            public void keyPressed(KeyEvent e)
            {

            }
            @Override
            public void keyTyped(KeyEvent e)
            {

            }



            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }




    private void gameLoop()
    {

    }
}
