package Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    private State state;
    private JPanel backPanel;
    private JPanel centerPanel;
    private JPanel welcomePanel;
    private JPanel genderPanel;
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
        state = State.WELCOME;
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
        centerPanel = new GenderPanel(buttons);
        genderPanel = new CategoryPanel(buttons);

        frame.add(backPanel);
        backPanel.setVisible(true);

        frame.setVisible(true);
        System.out.println(backPanel.getSize().getHeight());
    }

    public void updateGui(){
        System.out.println(buttons.getState());
       switch (buttons.getState()){

           case WELCOME ->{
                welcomePanel.setVisible(true);
                backPanel.add(welcomePanel);
            }
            case INTRO -> {
               welcomePanel.setVisible(false);
                backPanel.remove(welcomePanel);
                centerPanel.setVisible(true);
                backPanel.add(centerPanel);

            }
            case WOMAN, MAN, UNISEX -> {
                centerPanel.setVisible(false);
                backPanel.remove(centerPanel);
                genderPanel.setVisible(true);
                backPanel.add(genderPanel);
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