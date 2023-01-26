package Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    private State state;
    private JPanel backPanel;
    private JPanel genderPanel;
    private JPanel welcomePanel;
    private JPanel categoryPanel;
    private JPanel pageNotFoundPanel;
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
        genderPanel = new GenderPanel(buttons);
        categoryPanel = new CategoryPanel(buttons);
        //pageNotFoundPanel = new PageNotFound(buttons);

        frame.add(backPanel);
        backPanel.setVisible(true);

        frame.setVisible(true);
        System.out.println(backPanel.getSize().getHeight());
    }

    public void updateGui(){
        System.out.println(buttons.getState());
       switch (buttons.getState()){

           case WELCOME ->{
               backPanel.getComponent(0).setVisible(false);
               backPanel.remove(0);
                welcomePanel.setVisible(true);
                backPanel.add(welcomePanel);
            }
            case INTRO -> {
                backPanel.getComponent(0).setVisible(false);
                backPanel.remove(0);
                genderPanel.setVisible(true);
                backPanel.add(genderPanel);

            }

            //TODO: Fix not found state;
           case NOT_FOUND -> {
               backPanel.getComponent(0).setVisible(false);
               backPanel.remove(0);
               genderPanel.setVisible(true);
               genderPanel.add(new JButton("hej"));
               backPanel.add(genderPanel);

           }
            case WOMAN, MAN, UNISEX -> {
                genderPanel.setVisible(false);
                backPanel.remove(genderPanel);
                categoryPanel.setVisible(true);
                backPanel.add(categoryPanel);
            }
            case SNEAKER, SANDAL, SLIPPER -> {

            }
        }
    }


    public static void main(String[] args) {
        gui = Gui.getInstance();
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
}