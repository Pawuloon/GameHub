package TicTac;

import javax.swing.*;
import java.awt.*;

public class Field extends JButton
{

    private int playerNum;
    public Field(int playerNum)
    {
        setPreferredSize(new Dimension(10,10));
        setFont(new Font("Arial", Font.PLAIN, 40));
        setFocusable(false);
        this.playerNum = playerNum;
        setText("");

        addActionListener(e ->
        {
           if (getText().equals(""))
           {
               if (this.playerNum == 1)
               {
                   setText("X");
               }
               else if (this.playerNum == 2)
               {
                   setText("O");
               }
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Invalid move");
           }

        });
    }

    public int getPlayerNum()
    {
        return playerNum;
    }

    public void setPlayerNum(int playerNum)
    {
        this.playerNum = playerNum;
    }
}
