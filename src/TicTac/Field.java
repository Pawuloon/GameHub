package TicTac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Field extends JButton
{


    public Field(int playerNum)
    {
        setPreferredSize(new Dimension(10,10));
        setFont(new Font("Arial", Font.PLAIN, 40));
        setFocusable(false);
        setText("");

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == MouseEvent.BUTTON1)
                {
                    setText("X");
                }
                else if (e.getButton() == MouseEvent.BUTTON3)
                {
                    setText("O");
                }
                else if (e.getButton() == MouseEvent.BUTTON2)
                {
                    setText("");
                }
            }
        });
    }

}
