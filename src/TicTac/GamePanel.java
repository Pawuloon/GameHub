package TicTac;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel
{
    public GamePanel(int size)
    {
        // Tic tac panel
        setPreferredSize(new Dimension(700, 500));


        setLayout(new GridLayout(size,size));

        setBackground(Color.BLACK);
        setVisible(true);

        var fields = new ArrayList<Field>();

        // Fields
        for (int i = 0; i < size * size; i++)
        {
            fields.add(new Field(1));
        }
        for (var field : fields)
        {
            add(field);
        }

        var timer = new Timer(10, e->
        {
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



        });
        timer.start();




    }
}
