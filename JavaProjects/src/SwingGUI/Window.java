package SwingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Window extends JFrame {
    public Window() {
        super("My First Java Window");

        setTitle("new title");
        setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        setSize(new Dimension(600, 600));
        // 0,0 = top left
        setLocation(0, 0);
        // null = center
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.GREEN);

        /*
        // label
        JLabel label = new JLabel("Hello World!");
        add(label);
        label.setHorizontalTextPosition(JLabel.CENTER);
        // SwingConstants : always at that position regarding the resizing
        label.setVerticalTextPosition(SwingConstants.TOP);
        // printFonts(); // print all built-in fonts
        label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 72));
        // text color
        label.setForeground(Color.BLACK);
        // label.setForeground(Color.decode("#000000"));
        // label.setForeground(new Color(34,33, 159, 200));

        // image
        // copy image path from content root
        ImageIcon snoutIcon = new ImageIcon("src/SwingGUI/Resources/Snout.jpg");
        label.setIcon(snoutIcon);
        */

        // update
        repaint();
        revalidate();
    }

    // browse for built-in fonts
    private static void printFonts() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        Font[] allFonts = ge.getAllFonts();

        for (Font font : allFonts) {
            System.out.println(font.getFontName(Locale.US));
        }
    }
}
