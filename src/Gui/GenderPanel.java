package Gui;

import javax.swing.*;
import java.awt.*;

public class GenderPanel extends JPanel{
    public GenderPanel(Buttons buttons) {

        setLayout(new GridLayout());

        add(buttons.getButton1());
        add(buttons.getButton2());
        add(buttons.getButton3());

        setBackground(Color.white);
        setVisible(false);
    }

}
