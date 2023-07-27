package Hub;

import javax.swing.*;
import java.awt.*;
import java.io.*;


// Instruction class
public class Instruction extends JFrame
{
    public Instruction()
    {
        super("Instruction");
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);

        // Instruction panel content
        var mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setOpaque(true);

        var content = readFile();

        var label = new JLabel("Instruction");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(Color.RED);


        // Text area
        var textArea = new JTextArea(content);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.BOLD, 20));
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(true);
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Scroll pane
        var scroll = new JScrollPane(textArea);

        scroll.setPreferredSize(new Dimension(800, 600));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setBorder(BorderFactory.createEmptyBorder());


        // Back button
        var back = new JButton("Back");
        back.setPreferredSize(new Dimension(100, 100));
        back.addActionListener(e ->
        {
            var hub = new Hub();
            hub.setVisible(true);
            dispose();
        });


        // Adding components
        mainPanel.add(label, BorderLayout.NORTH);
        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.add(back, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);
    }


    // Read file method
    private String readFile()
    {
        try (var reader = new FileReader("src\\TxtFiles\\GameInst.txt"))
        {
            var bufferedReader = new BufferedReader(reader);
            var stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
