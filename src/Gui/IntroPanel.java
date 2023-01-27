package Gui;

import javax.swing.*;
import java.awt.*;

public class IntroPanel extends JPanel {

    private JPanel leftAlignedMenu;
    private Buttons buttons;
    private JPanel rightSidePanel;

    public IntroPanel(Buttons buttons){
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
    }

}
