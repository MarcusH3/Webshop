package Gui;
import DataBaseConnections.Main;
import Utilities.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    private Main main;
    private State state;
    private JPanel backPanel;
    private JPanel genderPanel;
    private JPanel welcomePanel;
    private JPanel signUpPanel;
    private JPanel introPanel;
    private JPanel categoryPanel;
    private JPanel pageNotFoundPanel;
    private JPanel leftAlignedMenu;
    private JPanel topFiveMenu;
    private JPanel productPanel;
    private JPanel cart;
    private Buttons buttons;
    JList<String> jList;
    private boolean running;
    private static Gui gui = null;

    public static Gui getInstance(){
        if(gui == null){
            gui = new Gui();
        }
        return gui;
    }

    private Gui(){
        state = State.INTRO;
        buttons = new Buttons(this);
        main = new Main();
        makeGui();
        updateGui();

    }


    public void makeGui() {

        JFrame frame = new JFrame("GUI");
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.darkGray);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        backPanel = new BackPanel();
        welcomePanel = new WelcomePanel(buttons);
        introPanel = new IntroPanel(buttons);
        leftAlignedMenu = new LeftAlignedMenu(buttons);
        pageNotFoundPanel = new PageNotFound(buttons);
        genderPanel = new GenderPanel(buttons);
        signUpPanel = new SignUpPanel(buttons);


        //categoryPanel = new CategoryPanel(buttons);
        //

        frame.add(backPanel);
        backPanel.setVisible(true);

        frame.setVisible(true);
        System.out.println(backPanel.getSize().getHeight());
    }

    public void updateGui(){
        for(Component component : backPanel.getComponents()){
            component.setVisible(false);
            backPanel.remove(component);
        }
        for(Component component : introPanel.getComponents()){
            component.setVisible(false);
            introPanel.remove(component);
        }
       switch (buttons.getState()){

           case WELCOME ->{
               welcomePanel.setVisible(true);
               backPanel.add(welcomePanel);
            }
           case SIGN_UP -> {
               signUpPanel.setVisible(true);
               backPanel.add(signUpPanel);
           }
            case INTRO -> {
                introPanel.add(leftAlignedMenu);
                introPanel.add(genderPanel);
                introPanel.setVisible(true);
                backPanel.add(introPanel);
            }

            //TODO: Fix not found state;
           case NOT_FOUND -> {
               introPanel.add(leftAlignedMenu);
               introPanel.add(pageNotFoundPanel);
               introPanel.setVisible(true);
               backPanel.add(introPanel);
           }
           case TOP_FIVE -> {
               topFiveMenu = new TopFive(buttons);
               introPanel.add(leftAlignedMenu);
               introPanel.add(topFiveMenu);
               introPanel.setVisible(true);
               backPanel.add(introPanel);
           }
           case PRODUCTS -> {
               productPanel = new ProductPanel(buttons);
               introPanel.add(leftAlignedMenu);
               introPanel.add(productPanel);
               introPanel.setVisible(true);
               backPanel.add(introPanel);
           }
            case WOMAN, MAN, UNISEX -> {
                genderPanel.setVisible(false);
                backPanel.remove(genderPanel);
                categoryPanel.setVisible(true);
                backPanel.add(categoryPanel);
            }
           case CART -> {
               cart = new Cart(buttons);
               introPanel.add(leftAlignedMenu);
               introPanel.add(cart);
               introPanel.setVisible(true);
               backPanel.add(introPanel);
            }
        }
        for(Component component : introPanel.getComponents()){
            component.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public JPanel getGenderPanel() {
        return genderPanel;
    }

    public JPanel getLeftAlignedMenu() {
        return leftAlignedMenu;
    }

    public JPanel getWelcomePanel() {
        return welcomePanel;
    }

    public JPanel getIntroPanel() {
        return introPanel;
    }

    public JPanel getCategoryPanel() {
        return categoryPanel;
    }

    public JPanel getPageNotFoundPanel() {
        return pageNotFoundPanel;
    }

    public JPanel getBackPanel() {
        return backPanel;
    }
    public JPanel getSignUpPanel() {
        return signUpPanel;
    }
    public JPanel getProductPanel(){return productPanel;}
    public Main getMain() {
        return main;
    }
}