package Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TopFive extends JPanel {
    private JList<String> list;
    private ArrayList<String> stringList;
    public TopFive(Buttons buttons) {
        setPreferredSize(new Dimension(700,763));
        stringList = buttons.getStringList();
        list = new JList<>(stringList.toArray(new String[stringList.size()]));
        JScrollPane jScrollPane = new JScrollPane(list);
        jScrollPane.setPreferredSize(new Dimension(700,763));
        add(jScrollPane);
    }

}
