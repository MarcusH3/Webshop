package Gui;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.function.Consumer;

public class JTextFieldManipulator{

    private String temp;

    public JTextFieldManipulator(JTextComponent component) {
        initFocusListener(component);
    }
    public void initFocusListener(JTextComponent component){

    temp = component.getText();

    component.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            component.setText("");
            component.setForeground(Color.black);
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (component.getText().isEmpty()) {
                component.setText(temp);
                component.setForeground(Color.GRAY);
            }
        }
    });
}
}
