package PingPong;

import javax.swing.*;

public class Pong extends JPanel
{
    public Pong()
    {
        var frame = new JFrame("Ping Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



}
