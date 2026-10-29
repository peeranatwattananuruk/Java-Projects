package SwingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class JButtonApp extends Window implements ActionListener {
    private JButton button1, button2;
    public JButtonApp() {
        // button
        ImageIcon snoutIcon = new ImageIcon("src/SwingGUI/Resources/Snout.jpg");
        ImageIcon tomatoIcon = new ImageIcon("src/SwingGUI/Resources/Tomato.jpg");
        button1 = new JButton("Button1");
        button1.setIcon(snoutIcon);

        // change image when pressed
        button1.setPressedIcon(tomatoIcon);

        // text
        button1.setText("Easy");
        button1.setFont(new Font("Dialog", Font.BOLD, 72));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        //alignment
        button1.setHorizontalAlignment(SwingConstants.CENTER);
        button1.setVerticalAlignment(SwingConstants.CENTER);
        // margin
        button1.setMargin(new Insets(10, 10, 10 ,10));

        // press alt + E to activate the button
        button1.setMnemonic(KeyEvent.VK_E);
        // action command
        button1.setActionCommand("Click");
        // perform a click after _ milliseconds (not thread safe)
        button1.doClick(1000);
        // delays the next press by _ miliiseconds
        button1.setMultiClickThreshhold(500);

        // best solution for multiple buttons
        button1.addActionListener(this);
        add(button1, BorderLayout.CENTER);

        button2 = new JButton("Button2");
        button2.addActionListener(this);
        add(button2, BorderLayout.EAST);

        /*
        // action listener (for single button)
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // perform actions
                System.out.println("Java is cool");
            }
        });
        */

        // add all components first then set visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            System.out.println("button1");

            JOptionPane.showMessageDialog(this, "Boom!");
        }
        else if (e.getActionCommand().equals("Button2")) {
            System.out.println("button2");
        }
    }
}
