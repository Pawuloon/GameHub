package TicTac;

import javax.swing.*;
import java.awt.*;

public class Tic extends JFrame
{

    public Tic()
    {
        setTitle("Tic Tac Toe");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


        String ask;
        do
        {
            ask = JOptionPane.showInputDialog(
                    null, "How many fields do you want to have ?");
            if (ask == null)
                System.exit(-1);
            else if (ask.matches("[3-9]+"))
                break;
            else
                JOptionPane.showMessageDialog(null, "Invalid input");
        }while(true);
        // Tic tac panel
        var panel = new GamePanel(Integer.parseInt(ask));

        // Back button
        var back = new JButton("Back");
        back.setPreferredSize(new Dimension(100, 100));
        back.addActionListener(e ->
        {
            var hub = new Hub.Hub();
            hub.setVisible(true);
            dispose();
        });


        // Adding components
        add(panel, BorderLayout.CENTER);
        add(back, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);

    }



}
