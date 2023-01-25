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

    private JButton loginButton;
    private JButton exitButton;
    private Gui gui;
    GridBagConstraints gbc;
    State state = State.WELCOME;
    public Buttons(Gui gui){

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
