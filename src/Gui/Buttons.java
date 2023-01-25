package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends AbstractGui implements ActionListener{
    private JButton button1;
    private JButton button2;
    private JButton button3;

    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton introButton1;
    private JButton introButton2;
    private JButton introButton3;
    private JButton introButton4;
    private JButton introButton5;
    private JButton introButton6;
    private JButton introButton7;
    private JButton introButton8;
    private JButton introButton9;
    private JButton loginButton;
    private JButton exitButton;
    private Gui gui;
    private Dimension introButtonDimension;
    GridBagConstraints gbc;
    State state = State.WELCOME;
    public Buttons(Gui gui){

        introButtonDimension = new Dimension(200,60);
        this.gui = gui;

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0 / 3;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        button1 = new JButton("Woman");
        button2 = new JButton("Man");
        button3 = new JButton("Unisex");

        button1.setBackground(Color.white);
        button2.setBackground(Color.white);
        button3.setBackground(Color.white);

        button1.setIcon(getImageIcon("Res/Title1.png"));
        button2.setIcon(getImageIcon("Res/Title2.png"));
        button3.setIcon(getImageIcon("Res/Title3.png"));

        button1.setBorder(null);
        button2.setBorder(null);
        button3.setBorder(null);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        button4 = new JButton("Sneaker");
        button5 = new JButton("Sandal");
        button6 = new JButton("Slipper");

        button4.setBackground(Color.white);
        button5.setBackground(Color.white);
        button6.setBackground(Color.white);

        button4.setIcon(getImageIcon("Res/Title4.png"));
        button5.setIcon(getImageIcon("Res/Title5.png"));
        button6.setIcon(getImageIcon("Res/Title6.png"));

        button4.setBorder(null);
        button5.setBorder(null);
        button6.setBorder(null);

        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);

        loginButton = new JButton("LOGIN");
        loginButton.addActionListener(this);

        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);

        introButton1 = new JButton("BUTTON");
        introButton2 = new JButton("BUTTON");
        introButton3 = new JButton("Statistics");
        introButton4 = new JButton("BUTTON");
        introButton5 = new JButton("BUTTON");
        introButton6 = new JButton("BUTTON");
        introButton7 = new JButton("Return");
        introButton8 = new JButton("BUTTON");
        introButton9 = new JButton("BUTTON");

        introButton1.setPreferredSize(introButtonDimension);
        introButton2.setPreferredSize(introButtonDimension);
        introButton3.setPreferredSize(introButtonDimension);
        introButton4.setPreferredSize(introButtonDimension);
        introButton5.setPreferredSize(introButtonDimension);
        introButton6.setPreferredSize(introButtonDimension);
        introButton7.setPreferredSize(introButtonDimension);
        introButton8.setPreferredSize(introButtonDimension);
        introButton9.setPreferredSize(introButtonDimension);



        introButton1.setBorder(null);
        introButton2.setBorder(null);
        introButton3.setBorder(null);
        introButton4.setBorder(null);
        introButton5.setBorder(null);
        introButton6.setBorder(null);
        introButton7.setBorder(null);
        introButton8.setBorder(null);
        introButton9.setBorder(null);

        introButton1.setBackground(Color.cyan);
        introButton2.setBackground(Color.cyan);
        introButton3.setBackground(Color.cyan);
        introButton4.setBackground(Color.cyan);
        introButton5.setBackground(Color.cyan);
        introButton6.setBackground(Color.cyan);
        introButton7.setBackground(Color.cyan);
        introButton8.setBackground(Color.cyan);
        introButton9.setBackground(Color.cyan);

        introButton1.setIcon(new ImageIcon("Res/icon1.png"));
        introButton2.setIcon(new ImageIcon("Res/icon1.png"));
        introButton3.setIcon(new ImageIcon("Res/icon1.png"));
        introButton4.setIcon(new ImageIcon("Res/icon1.png"));
        introButton5.setIcon(new ImageIcon("Res/icon1.png"));
        introButton6.setIcon(new ImageIcon("Res/icon1.png"));
        introButton7.setIcon(new ImageIcon("Res/icon1.png"));
        introButton8.setIcon(new ImageIcon("Res/icon1.png"));
        introButton9.setIcon(new ImageIcon("Res/icon1.png"));

        introButton3.setHorizontalAlignment(SwingConstants.LEFT);
        introButton3.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton3.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton3.setFont(new Font("Arial", Font.PLAIN, 20));

        introButton4.setHorizontalAlignment(SwingConstants.LEFT);
        introButton4.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton4.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton4.setFont(new Font("Arial", Font.PLAIN, 20));

        introButton5.setHorizontalAlignment(SwingConstants.LEFT);
        introButton5.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton5.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton5.setFont(new Font("Arial", Font.PLAIN, 20));

        introButton6.setHorizontalAlignment(SwingConstants.LEFT);
        introButton6.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton6.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton6.setFont(new Font("Arial", Font.PLAIN, 20));

        introButton7.setHorizontalAlignment(SwingConstants.LEFT);
        introButton7.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton7.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton7.setFont(new Font("Arial", Font.PLAIN, 20));

        introButton8.setHorizontalAlignment(SwingConstants.LEFT);
        introButton8.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton8.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton8.setFont(new Font("Arial", Font.PLAIN, 20));

        introButton3.addActionListener(this);
        introButton7.addActionListener(this);
        /*introButton9.setHorizontalAlignment(SwingConstants.LEFT);
        introButton9.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton9.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton9.setFont(new Font("Arial", Font.PLAIN, 20));*/
    }

    public static ImageIcon getImageIcon(String path){
        ImageIcon woman = new ImageIcon(path);
        Image image = woman.getImage();
        int width = 304;
        int height = 723;
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(newImage);
        return newIcon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(getState()){
            case WELCOME -> {
                if(e.getSource() == loginButton){
                    setState(State.INTRO);
                    gui.updateGui();
                    System.out.println("hej");
                }
                if(e.getSource() == exitButton){
                    System.exit(1);
                }
            }
            case INTRO -> {
                if(e.getSource()==button1){
                    setState(State.WOMAN);
                    gui.updateGui();
                    System.out.println("Woman");

                } else if (e.getSource()== button2) {
                    setState(State.MAN);
                    gui.updateGui();
                    System.out.println("Man");
                }
                else if (e.getSource()== button3) {
                    System.out.println("Unisex");
                    setState(State.UNISEX);
                    gui.updateGui();
                }
                else if (e.getSource()== introButton3) {
                    System.out.println("Unisex");
                    setState(State.UNISEX);
                    gui.updateGui();
                }
                else if (e.getSource()== introButton7) {
                    System.out.println("Unisex");
                    setState(State.WELCOME);
                    gui.updateGui();
                }
            }
            case WOMAN, MAN, UNISEX-> {
                if(e.getSource()==button4){
                    setState(State.SNEAKER);
                    System.out.println("Sneaker");
                } else if (e.getSource()== button5) {
                    setState(State.SANDAL);
                    System.out.println("Sandal");
                }
                else if (e.getSource()== button6) {
                    System.out.println("Slipper");
                    setState(State.SLIPPER);
                }
            }

        }
    }

    @Override
    public JButton getButton1() {
        return button1;
    }

    @Override
    public JButton getButton2() {
        return button2;
    }

    @Override
    public JButton getButton3() {
        return button3;
    }

    @Override
    public JButton getButton4() {
        return button4;
    }

    @Override
    public JButton getButton5() {
        return button5;
    }

    @Override
    public JButton getButton6() {
        return button6;
    }

    @Override
    public JButton getLoginButton() {
        return loginButton;
    }

    @Override
    public JButton getExitButton() {
        return exitButton;
    }

    @Override
    public JButton getIntroButton1() {
        return introButton1;
    }

    @Override
    public JButton getIntroButton2() {
        return introButton2;
    }

    @Override
    public JButton getIntroButton3() {
        return introButton3;
    }

    @Override
    public JButton getIntroButton4() {
        return introButton4;
    }

    @Override
    public JButton getIntroButton5() {
        return introButton5;
    }

    @Override
    public JButton getIntroButton6() {
        return introButton6;
    }

    @Override
    public JButton getIntroButton7() {
        return introButton7;
    }

    @Override
    public JButton getIntroButton8() {
        return introButton8;
    }

    @Override
    public JButton getIntroButton9() {
        return introButton9;
    }

    @Override
    public GridBagConstraints getGridBagConstraints() {
        return gbc;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }
}
