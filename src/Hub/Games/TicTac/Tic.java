package Hub.Games.TicTac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Hub.Hub;

public class Tic extends JFrame
{

    public Tic()
    {
        setTitle("Tic Tac Toe");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);

        var img = new ImageIcon("src\\Graphics\\img_6.jpg");
        setIconImage(img.getImage());


        // Ask for number of fields
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
            var hub = new Hub();
            hub.setVisible(true);
            dispose();
        });

        // Window listener
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                var choice = JOptionPane.showConfirmDialog(null, "Do you want to go back to hub ?"
                        , "Exit", JOptionPane.YES_NO_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION)
                {
                    var frame = new Hub();
                    frame.setVisible(true);
                    dispose();
                }
                else if (choice == JOptionPane.CANCEL_OPTION)
                {
                    System.exit(0);
                }
            }
        });

        // Adding components
        add(panel, BorderLayout.CENTER);
        add(back, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);

    }



}
