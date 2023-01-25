package Gui;

import javax.swing.*;
import java.awt.*;

public class BackPanel extends JPanel {

    public BackPanel() {


        setBackground(Color.white);
        setLayout(new BorderLayout());

        JToolBar jToolBar = new JToolBar();
        jToolBar.setBackground(Color.white);
        jToolBar.setFloatable(false);

        JButton tbButton1 = new JButton("  File  ");
        tbButton1.setBackground(Color.white);
        tbButton1.setForeground(Color.black);
        tbButton1.setBorder(null);
        jToolBar.add(tbButton1);

        JButton tbButton2 = new JButton("  Edit  ");
        tbButton2.setBackground(Color.white);
        tbButton2.setForeground(Color.black);
        tbButton2.setBorder(null);
        jToolBar.add(tbButton2);

        add(jToolBar, BorderLayout.NORTH);
        setVisible(false);
    }

    public BackPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public BackPanel(LayoutManager layout) {
        super(layout);
    }

    public BackPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }
}
