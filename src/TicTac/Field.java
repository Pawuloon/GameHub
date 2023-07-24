package TicTac;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JButton
{

    private int playerNum;
    public Field(int playerNum)
    {
        this.playerNum = playerNum;

        if(this.playerNum == 1)
        {
            setText("X");
        }
        else if (this.playerNum == 2)
        {
            setText("O");
        }
        else
        {
            setText("");
        }

        addActionListener(e ->
        {
           if (getText().equals(""))
           {
               if (this.playerNum == 1)
               {
                   setText("X");
                   this.playerNum = 2;
               }
               else
               {
                   setText("O");
                   this.playerNum = 1;
               }
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Invalid move");
           }

        });
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
}
