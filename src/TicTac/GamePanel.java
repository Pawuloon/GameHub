package TicTac;

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

        var fields = new ArrayList<Field>();
        var lastFis = new ArrayList<ArrayList<Field>>();

        // Fields
        for (int i = 0; i < size * size; i++)
        {
            fields.add(new Field());
        }
        for (var field : fields)
        {
            add(field);
        }
        for (int i = 0; i < size ; i++)
        {
            lastFis.add(new ArrayList<>());
            for (int j = 0; j < size; j++)
            {
                lastFis.get(i).add(new Field());
            }
        }



        // Timer
        var timer = new Timer(10, e->
        {
            var winner = checkWinner(lastFis);
            for (var field : fields)
            {
                if (field.getText().equals("X"))
                {
                    field.setForeground(Color.RED);
                }
                else if (field.getText().equals("O"))
                {
                    field.setForeground(Color.BLUE);
                }
                else
                {
                    field.setForeground(Color.BLACK);
                }
            }

            assert winner != null;
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
                case " " -> {
                    JOptionPane.showMessageDialog(null, "Draw");
                    System.exit(0);
                }
            }
        });
        timer.start();
    }


    // TODO Fix this method
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

        return null;
    }
}
