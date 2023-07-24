package TicTac;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel
{
    public GamePanel(int size)
    {
        // Tic tac panel
        setPreferredSize(new Dimension(700, 500));
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        var fields = new ArrayList<Field>();

        // Fields

        for (int i = 0; i < size; i++)
        {
            fields.add(new Field(0));
        }



    }
}
