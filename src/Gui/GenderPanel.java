package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GenderPanel extends JPanel{
    public GenderPanel(Buttons buttons) {

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        //LEFT PANEL ATTRIBUTES
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(300,763));
        leftPanel.setBackground(Color.cyan);

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(300,84));
        panel1.setBackground(Color.cyan);

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(300,84));
        JTextField textField = new JTextField(20);
       // textField.setPreferredSize(new Dimension(200,60));
        textField.setText("Search");
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        textField.setForeground(Color.lightGray);
        textField.setBackground(Color.cyan);
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Search")) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("Search");
                    textField.setForeground(Color.GRAY);
                }
            }
        });
        panel2.add(textField);
        panel2.setBackground(Color.cyan);

        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(300,84));
        panel3.add(buttons.getIntroButton3());
        panel3.setBackground(Color.cyan);

        JPanel panel4 = new JPanel();
        panel4.setPreferredSize(new Dimension(300,84));
        panel4.add(buttons.getIntroButton4());
        panel4.setBackground(Color.cyan);

        JPanel panel5 = new JPanel();
        panel5.setPreferredSize(new Dimension(300,84));
        panel5.add(buttons.getIntroButton5());
        panel5.setBackground(Color.cyan);

        JPanel panel6 = new JPanel();
        panel6.setPreferredSize(new Dimension(300,84));
        panel6.add(buttons.getIntroButton6());
        panel6.setBackground(Color.cyan);

        JPanel panel7 = new JPanel();
        panel7.setPreferredSize(new Dimension(300,84));
        panel7.add(buttons.getIntroButton7());
        panel7.setBackground(Color.cyan);

        JPanel panel8 = new JPanel();
        panel8.setPreferredSize(new Dimension(300,84));
        panel8.setBackground(Color.cyan);

        JPanel panel9 = new JPanel();
        panel9.setPreferredSize(new Dimension(300,84));
        panel9.setBackground(Color.cyan);

        leftPanel.add(panel1);
        leftPanel.add(panel2);
        leftPanel.add(panel3);
        leftPanel.add(panel4);
        leftPanel.add(panel5);
        leftPanel.add(panel6);
        leftPanel.add(panel7);
        leftPanel.add(panel8);
        leftPanel.add(panel9);


        //RIGHT PANEL ATTRIBUTES
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setPreferredSize(new Dimension(700,763));



        /*add(buttons.getButton1());
        add(buttons.getButton2());
        add(buttons.getButton3());*/
        add(leftPanel);
        add(rightPanel);

        setBackground(Color.white);
        setVisible(false);
    }

}
