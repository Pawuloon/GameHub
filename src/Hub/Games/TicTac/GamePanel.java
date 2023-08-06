package Hub.Games.TicTac;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GamePanel extends JPanel
{
    private final int size;
    public GamePanel(int size)
    {
        // Tic tac panel
        setPreferredSize(new Dimension(700, 500));
        this.size = size;

        setLayout(new GridLayout(size,size));

        setBackground(Color.BLACK);
        setVisible(true);

        var lastFis = new ArrayList<ArrayList<Field>>();

        // Fields
        for (int i = 0; i < size ; i++)
        {
            lastFis.add(new ArrayList<>());
            for (int j = 0; j < size; j++)
            {
                var field = new Field();
                lastFis.get(i).add(field);
                add(field);
            }
        }



        // Timer
        var timer = new Timer(0, e->
        {
            var winner = checkWinner(lastFis);


            switch (winner)
            {
                case "X" -> {
                    JOptionPane.showMessageDialog(null, "X won");
                    System.exit(0);
                }
                case "O" -> {
                    JOptionPane.showMessageDialog(null, "O won");
                    System.exit(0);
                }
                case null -> {
                    JOptionPane.showMessageDialog(null, "Draw");
                    System.exit(0);
                }
                default ->
                {
                    // Do nothing
                }
            }
        });
        timer.start();
    }



    private String checkWinner(ArrayList<ArrayList<Field>> lastFis)
    {
        // Rows
        for (int i = 0; i < size; i++) {
            if (lastFis.get(i).get(0).getText().equals(lastFis.get(i).get(1).getText())
                    && lastFis.get(i).get(1).getText().equals(lastFis.get(i).get(2).getText()))
                return lastFis.get(i).get(0).getText();
        }

        // Columns
        for (int i = 0; i < size; i++) {
            if (lastFis.get(0).get(i).getText().equals(lastFis.get(1).get(i).getText())
                    && lastFis.get(1).get(i).getText().equals(lastFis.get(2).get(i).getText()))
                return lastFis.get(0).get(i).getText();
        }

        // Diagonals
        if (lastFis.get(0).get(0).getText().equals(lastFis.get(1).get(1).getText())
                && lastFis.get(1).get(1).getText().equals(lastFis.get(2).get(2).getText()))
            return lastFis.get(0).get(0).getText();

        if (lastFis.get(0).get(2).getText().equals(lastFis.get(1).get(1).getText())
                && lastFis.get(1).get(1).getText().equals(lastFis.get(2).get(0).getText()))
            return lastFis.get(0).get(2).getText();

        // Draw
        for (int i = 0; i < size ; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (lastFis.get(i).get(j).getText().equals(" "))
                    return null;
            }
        }
        return null;
    }
}
