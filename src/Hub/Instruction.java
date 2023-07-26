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

        // Instruction panel content
        var mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.setLayout(new BorderLayout());

        var content = readFile();

        var label = new JLabel("Instruction");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        // Scroll pane
        var scroll = new JScrollPane(new JTextArea(content));

        scroll.setPreferredSize(new Dimension(800, 600));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setBorder(BorderFactory.createEmptyBorder());

        // Adding components
        mainPanel.add(label, BorderLayout.NORTH);
        mainPanel.add(scroll, BorderLayout.CENTER);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
