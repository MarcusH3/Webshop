package Gui;

import Database.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Buttons extends AbstractGui implements ActionListener, MouseListener {
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
    private JButton tempButton;
    private JButton signUpButton;
    private JButton nextButton;
    private JButton previousButton;
    private JTextField searchBar;
    private Gui gui;
    private Dimension introButtonDimension;
    private GridBagConstraints gbc;
    private State state = State.WELCOME;
    private ArrayList<String> stringList;

    private State previousState;

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
        introButton2 = new JButton("TOP PRODUCTS");
        introButton3 = new JButton("NEW LISTINGS");
        introButton4 = new JButton("EXPLORE");
        introButton5 = new JButton("SETTINGS");
        introButton6 = new JButton("RETURN");
        introButton7 = new JButton("Return");
        introButton8 = new JButton("BUTTON");
        introButton9 = new JButton("BUTTON");

        introButton1.setForeground(Color.WHITE);
        introButton2.setForeground(Color.WHITE);
        introButton3.setForeground(Color.WHITE);
        introButton4.setForeground(Color.WHITE);
        introButton5.setForeground(Color.WHITE);
        introButton6.setForeground(Color.WHITE);
        introButton7.setForeground(Color.WHITE);
        introButton8.setForeground(Color.WHITE);
        introButton9.setForeground(Color.WHITE);

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

        introButton1.setBackground(Color.white);
        introButton2.setBackground(Color.white);
        introButton3.setBackground(Color.white);
        introButton4.setBackground(Color.white);
        introButton5.setBackground(Color.white);
        introButton6.setBackground(Color.white);
        introButton7.setBackground(Color.white);
        introButton8.setBackground(Color.white);
        introButton9.setBackground(Color.white);

        introButton1.setOpaque(false);
        introButton2.setOpaque(false);
        introButton3.setOpaque(false);
        introButton4.setOpaque(false);
        introButton5.setOpaque(false);
        introButton6.setOpaque(false);
        introButton7.setOpaque(false);
        introButton8.setOpaque(false);
        introButton9.setOpaque(false);


        introButton1.addMouseListener(this);
        introButton2.addMouseListener(this);
        introButton3.addMouseListener(this);
        introButton4.addMouseListener(this);
        introButton5.addMouseListener(this);
        introButton6.addMouseListener(this);
        introButton7.addMouseListener(this);
        introButton8.addMouseListener(this);
        introButton9.addMouseListener(this);

        introButton1.setRolloverEnabled(false);
        introButton2.setRolloverEnabled(false);
        introButton3.setRolloverEnabled(false);
        introButton4.setRolloverEnabled(false);
        introButton5.setRolloverEnabled(false);
        introButton6.setRolloverEnabled(false);
        introButton7.setRolloverEnabled(false);
        introButton8.setRolloverEnabled(false);
        introButton9.setRolloverEnabled(false);



        introButton1.setIcon(new ImageIcon("Res/icon1.png"));
        introButton2.setIcon(new ImageIcon("Res/title11.png"));
        introButton3.setIcon(new ImageIcon("Res/title12.png"));
        introButton4.setIcon(new ImageIcon("Res/title9.png"));
        introButton5.setIcon(new ImageIcon("Res/title10.png"));
        introButton6.setIcon(new ImageIcon("Res/title14.png"));
        introButton7.setIcon(new ImageIcon("Res/icon1.png"));
        introButton8.setIcon(new ImageIcon("Res/icon1.png"));
        introButton9.setIcon(new ImageIcon("Res/icon1.png"));

        introButton1.setHorizontalAlignment(SwingConstants.LEFT);
        introButton1.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton1.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton1.setFont(new Font("Arial", Font.PLAIN, 15));

        introButton2.setHorizontalAlignment(SwingConstants.LEFT);
        introButton2.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton2.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton2.setFont(new Font("Arial", Font.PLAIN, 15));

        introButton3.setHorizontalAlignment(SwingConstants.LEFT);
        introButton3.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton3.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton3.setFont(new Font("Arial", Font.PLAIN, 15));

        introButton4.setHorizontalAlignment(SwingConstants.LEFT);
        introButton4.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton4.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton4.setFont(new Font("Arial", Font.PLAIN, 15));

        introButton5.setHorizontalAlignment(SwingConstants.LEFT);
        introButton5.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton5.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton5.setFont(new Font("Arial", Font.PLAIN, 15));

        introButton6.setHorizontalAlignment(SwingConstants.LEFT);
        introButton6.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton6.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton6.setFont(new Font("Arial", Font.PLAIN, 15));

        introButton7.setHorizontalAlignment(SwingConstants.LEFT);
        introButton7.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton7.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton7.setFont(new Font("Arial", Font.PLAIN, 15));

        introButton8.setHorizontalAlignment(SwingConstants.LEFT);
        introButton8.setHorizontalTextPosition(SwingConstants.TRAILING);
        introButton8.setVerticalTextPosition(SwingConstants.BOTTOM);
        introButton8.setFont(new Font("Arial", Font.PLAIN, 15));

        introButton1.addActionListener(this);
        introButton2.addActionListener(this);
        introButton3.addActionListener(this);
        introButton4.addActionListener(this);
        introButton5.addActionListener(this);
        introButton6.addActionListener(this);
        introButton7.addActionListener(this);
        introButton8.addActionListener(this);
        introButton9.addActionListener(this);

        signUpButton = new JButton("Sign up");
        signUpButton.setForeground(Color.CYAN);
        signUpButton.setBorderPainted(false);
        signUpButton.setFocusPainted(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.addActionListener(this);

        nextButton = new JButton("NEXT");
        nextButton.addActionListener(this);

        previousButton = new JButton("RETURN");
        previousButton.addActionListener(this);
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
                    ArrayList<Customer> customers = gui.getMain().getCustomer();
                    for(Customer customer : customers){
                        if(customer.getCustomerFirstName().equalsIgnoreCase("marcus")) {
                            setPreviousState(getState());
                            setState(State.INTRO);
                            gui.getBackPanel().getComponent(0).setVisible(false);
                            gui.getBackPanel().remove(0);
                            gui.updateGui();
                        }
                    }
                    System.out.println("Sorry you god damn commie");

                }
                if(e.getSource() == exitButton){
                    System.exit(1);
                }
                if(e.getSource() == signUpButton){
                    setState(State.SIGN_UP);
                    gui.updateGui();
                }
            }
            case SIGN_UP -> {
                if (e.getSource() == previousButton){
                    setState(State.WELCOME);
                    gui.updateGui();
                }
                if(e.getSource() == nextButton){
                    setState(State.INTRO);
                    gui.updateGui();
                }
            }
            case INTRO, NOT_FOUND, TOP_FIVE -> {
                if(e.getSource()==button1){
                    setPreviousState(getState());
                    setState(State.WOMAN);
                    gui.updateGui();
                    System.out.println("Woman");

                } else if (e.getSource()== introButton2) {
                    stringList = gui.getMain().getTopFive();
                    setState(State.TOP_FIVE);
                    gui.updateGui();
                }
                else if (e.getSource()== introButton3) {
                    setPreviousState(getState());
                    System.out.println("NEW LISTINGS");
                    setState(State.NOT_FOUND);
                    gui.updateGui();
                }
                else if (e.getSource()== introButton4) {
                    setPreviousState(getState());
                    System.out.println("EXPLORE");
                    gui.getMain().getCustomer();
                    setState(State.NOT_FOUND);
                    gui.updateGui();
                }
                else if (e.getSource()== introButton5) {
                    setPreviousState(getState());
                    System.out.println("SETTINGS");
                    setState(State.NOT_FOUND);
                    gui.updateGui();
                }
                else if (e.getSource()== introButton6) {
                    System.out.println(getPreviousState());
                    switch (getState()){
                        case INTRO -> {
                            setState(State.WELCOME);
                            gui.updateGui();
                        }
                        case NOT_FOUND, TOP_FIVE -> {
                            setState(State.INTRO);
                            gui.updateGui();
                        }
                    }
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
    public JButton getSignUpButton() {
        return signUpButton;
    }

    @Override
    public JButton getNextButton() {
        return nextButton;
    }

    @Override
    public JButton getPreviousButton() {
        return previousButton;
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

    @Override
    public void mouseClicked(MouseEvent e) {
        tempButton = (JButton) e.getSource();
        tempButton.setOpaque(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        tempButton = (JButton) e.getSource();
        tempButton.setBackground(Color.WHITE);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        tempButton = (JButton) e.getSource();
        tempButton.setOpaque(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        tempButton = (JButton) e.getSource();
        tempButton.setOpaque(false);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        tempButton = (JButton) e.getSource();
        tempButton.setOpaque(false);
    }

    public State getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    public ArrayList<String> getStringList() {
        return stringList;
    }
    public Gui getGui(){
        return gui;
    }

    public JTextField getSearchBar() {
        return searchBar;
    }
}
