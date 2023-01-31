package Gui;

import Utilities.State;

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

    public abstract JButton getIntroButton1();
    public abstract JButton getIntroButton2();
    public abstract JButton getIntroButton3();
    public abstract JButton getIntroButton4();
    public abstract JButton getIntroButton5();
    public abstract JButton getIntroButton6();
    public abstract JButton getIntroButton7();
    public abstract JButton getIntroButton8();
    public abstract JButton getIntroButton9();
    public abstract JButton getSignUpButton();
    public abstract JButton getNextButton();
    public abstract JButton getPreviousButton();

    public abstract GridBagConstraints getGridBagConstraints();

    public abstract void setState(State state);
    public abstract State getState();

}
