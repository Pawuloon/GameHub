package Hub.Games.PingPong;

import javax.swing.*;
import java.awt.*;

public class Score extends JPanel
{
    private int value;

    private int value2;
    public Score(int value, int value2)
    {
        setBounds(0, 0, 800, 600);
        this.value = value;
        this.value2 = value2;
        setLayout(null);
        setVisible(true);
    }

    public int getValue2()
    {
        return value2;
    }

    public void setValue2(int value2)
    {
        this.value2 = value2;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.drawString(value + ":" + value2, 390, 50);


    }


}
