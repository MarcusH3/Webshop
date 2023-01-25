package Gui;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends JPanel {

    public CategoryPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public CategoryPanel(LayoutManager layout) {
        super(layout);
    }

    public CategoryPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public CategoryPanel(Buttons buttons) {

        setLayout(new GridLayout());

        add(buttons.getButton4());
        add(buttons.getButton5());
        add(buttons.getButton6());

        setBackground(Color.DARK_GRAY);
        setVisible(false);
    }
}
