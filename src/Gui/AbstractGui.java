package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class AbstractGui implements ActionListener {

    public abstract JButton getButton1();
    public abstract JButton getButton2();
    public abstract JButton getButton3();
    public abstract JButton getButton4();
    public abstract JButton getButton5();
    public abstract JButton getButton6();
    public abstract JButton getLoginButton();
    public abstract JButton getExitButton();

    public abstract GridBagConstraints getGridBagConstraints();

    public abstract void setState(State state);
    public abstract State getState();

}
