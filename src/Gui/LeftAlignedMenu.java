package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LeftAlignedMenu extends JPanel {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    public LeftAlignedMenu(Buttons buttons){

        setBackground(Color.white);
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setPreferredSize(new Dimension(300,763));

        ImageIcon welcomeImage = new ImageIcon("Res/Title8.png");
        JLabel welcomeLabel = new JLabel(welcomeImage);

        //ADD PANELS TO LABEL
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setPreferredSize(new Dimension(300,763));
        panel1.setBounds(0,0,300,763);
        panel1.setOpaque(false);

        JTextField searchBar = new JTextField();
        searchBar.setBounds(110, 108, 140, 60);
        searchBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        searchBar.setOpaque(false);
        searchBar.setText("Search product");
        searchBar.setForeground(Color.WHITE);

        searchBar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchBar.getText().equals("Search product")) {
                    searchBar.setText("");
                    searchBar.setForeground(Color.white);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchBar.getText().isEmpty()) {
                    searchBar.setText("Search product");
                    searchBar.setForeground(Color.white);
                }
            }
        });



        welcomeLabel.add(searchBar);



        button1 = buttons.getIntroButton1();
        button2 = buttons.getIntroButton2();
        button3 = buttons.getIntroButton3();
        button4 = buttons.getIntroButton4();
        button5 = buttons.getIntroButton5();
        button6 = buttons.getIntroButton6();
        button7 = buttons.getIntroButton7();

        ImageIcon searchIcon = new ImageIcon("Res/Title13.png");
        JLabel searchLabel = new JLabel(searchIcon);
        searchLabel.setBounds(50,108,60,60);

        welcomeLabel.add(searchLabel);

        button2.setBounds(50,168,200,84);
        welcomeLabel.add(button2);
        button3.setBounds(50,252,200,84);
        welcomeLabel.add(button3);
        button4.setBounds(50,336,200,84);
        welcomeLabel.add(button4);
        button5.setBounds(50,410,200,84);
        welcomeLabel.add(button5);
        button6.setBounds(50,494,200,84);
        welcomeLabel.add(button6);

        /*panel1.add(button2);
        welcomeLabel.add(panel1);
        panel1.add(button3);
        welcomeLabel.add(panel1);
        panel1.add(button4);
        welcomeLabel.add(panel1);
        panel1.add(button5);
        welcomeLabel.add(panel1);
        panel1.add(button6);
        welcomeLabel.add(panel1);*/

        leftPanel.add(welcomeLabel, BorderLayout.WEST);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        add(leftPanel);
        setPreferredSize(new Dimension(300,763));
    }
}
