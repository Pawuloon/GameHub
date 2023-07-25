package Blocks.BlockGame;

import javax.swing.*;
import java.awt.*;


import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

public class GamePanel extends JPanel
{
    private final String difficulty;
    public GamePanel(int iterations, String difficulty, Points points, int req)
    {
        super();
        this.difficulty = difficulty;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(800, 600));
        var background = new Background();

        setOpaque(true);
        setFocusable(false);
        requestFocus();


        var squares = squareJList(iterations);
        var movmentsY = movmentsY(iterations);
        var movmentsX = movmentsX(iterations);




        final int[] time = {getTime()};
        var task = new TimerTask()
        {
            @Override
            public void run()
            {
                time[0] -= 5;
            }
        };
        var timer = new Timer(5, e ->
        {

               var pointsd = 0;
               task.run();
               pointsd = timerProcess(squares, movmentsX,movmentsY, points, pointsd, time[0]);
               if (pointsd >= req)
               {
                    JOptionPane.showConfirmDialog(null, "You have won the game !\n Your score is: " + pointsd + " !",
                            "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
               }
               else if (time[0] <= 0)
               {
                    JOptionPane.showConfirmDialog(null, "You have lost the game !\n Your score is: " + pointsd + " !",
                            "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
               }

                repaint();
        });

        add(background);
        timer.setRepeats(true);
        timer.setDelay(11);
        timer.start();

    }
    private int getRandomXCoordinate()
    {
        Random random = new Random();
        int max = getWidth() - 10;
        return random.nextInt(max);
    }

    private int getTime()
    {
        return switch (difficulty)
        {
            case "Medium" -> 9000;
            case "Hard" -> 7000;
            case "Impossible" -> 5000;
            default -> 12000;
        };
    }


    private ArrayList<Square> squareJList(int iterations)
    {
        var squares = new ArrayList<Square>();
        for (int i = 0; i < iterations; i++)
        {
            var square = new Square(0);
            square.setLocation(getWidth(), getHeight() - 100);
            squares.add(square);
            add(square);
        }
        return squares;
    }


    private ArrayList<Integer> movmentsY(int iterations)
    {
        return movementsGenerator(iterations);
    }


    private ArrayList<Integer> movmentsX(int iterations)
    {
        return movementsGenerator(iterations);
    }

    private ArrayList<Integer> movementsGenerator(int iterations)
    {
        var movmentsX = new ArrayList<Integer>();
        for (int i = 0; i < iterations; i++)
        {
            switch (difficulty)
            {
                case "Medium" -> movmentsX.add(new Random().nextInt(3) + 1);
                case "Hard" -> movmentsX.add(new Random().nextInt(4) + 1);
                case "Impossible" -> movmentsX.add(new Random().nextInt(5) + 1);
                default -> movmentsX.add(2);
            }
        }
        return movmentsX;
    }

    public void squarePosition(Square square)
    {
        square.setLocation(getRandomXCoordinate(), -1 * square.getHeight());
    }

    // The amount of squares on the screen
    private int timerProcess(ArrayList<Square> squares,
                             ArrayList<Integer> movmentsX,
                             ArrayList<Integer> movmentsY, JTextField points,
                             int pointsd, int time)

    {
        for (int i = 0; i < squares.size(); i++)
        {
            var square = squares.get(i);
            var x = square.getX();
            var y = square.getY();

            var movementX = movmentsX.get(i);
            var movementY = movmentsY.get(i);

            x += movementX;
            y += movementY;
            if (x + square.getWidth() >= getWidth() && square.isAlive())
            {
                movmentsX.set(i, -1 * movmentsX.get(i));
                square.setColor();
            }
            if (x <= 0 && square.isAlive())
            {
                movmentsX.set(i, -1 * movmentsX.get(i));
                square.setColor();
            }
            if (x >= getWidth() && square.isAlive())
            {
                movmentsX.set(i, -1 * movmentsX.get(i));
                square.setColor();
            }
            if (square.isAlive() && y >= getHeight())
            {
                squarePosition(square);
            }
            else
            {
                pointsd += square.getScore();
                square.setLocation(x, y);
            }
            points.setText("Points: " + pointsd + " Time: " + time/100);

        }

        return pointsd;
    }
}
