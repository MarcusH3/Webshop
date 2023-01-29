package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Arrays;

public class SignUpPanel extends JPanel {
    public SignUpPanel(Buttons buttons){
        setBackground(Color.white);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setPreferredSize(new Dimension(300,763));

        ImageIcon welcomeImage = new ImageIcon("Res/Title7.png");
        JLabel welcomeLabel = new JLabel(welcomeImage);
        leftPanel.add(welcomeLabel, BorderLayout.WEST);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.X_AXIS));
        backgroundPanel.setPreferredSize(new Dimension(700,763));

        JPanel bpLeftPanel = new JPanel();
        bpLeftPanel.setPreferredSize(new Dimension(200,763));
        bpLeftPanel.setBackground(Color.white);

        JPanel bpCenterPanel = new JPanel();
        bpCenterPanel.setPreferredSize(new Dimension(300,763));
        bpCenterPanel.setLayout(new BoxLayout(bpCenterPanel, BoxLayout.Y_AXIS));
        //CENTER TOP PANEL
        JPanel bpCpTopPanel = new JPanel();
        bpCpTopPanel.setPreferredSize(new Dimension(300, 168));
        bpCpTopPanel.setBackground(Color.white);

        //CENTER CENTER PANEL
        JPanel bpCpCenterPanel = new JPanel();
        bpCpCenterPanel.setPreferredSize(new Dimension(300, 428));
        bpCpCenterPanel.setLayout(new BoxLayout(bpCpCenterPanel, BoxLayout.Y_AXIS));
        bpCpCenterPanel.setBackground(Color.white);

        JTextField firstNameTf = new JTextField(20);
        firstNameTf.setText("First Name");
        firstNameTf.setForeground(Color.lightGray);
        firstNameTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        firstNameTf.setPreferredSize(new Dimension(300,71));
        firstNameTf.setMinimumSize(new Dimension(300,71));

        JTextField lastNameTf = new JTextField(20);
        lastNameTf.setText("Last Name");
        lastNameTf.setForeground(Color.lightGray);
        lastNameTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        lastNameTf.setPreferredSize(new Dimension(300,71));
        lastNameTf.setMinimumSize(new Dimension(300,71));

        JTextField emailTf = new JTextField(20);
        emailTf.setText("Email Address");
        emailTf.setForeground(Color.lightGray);
        emailTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        emailTf.setPreferredSize(new Dimension(300,71));
        emailTf.setMinimumSize(new Dimension(300,71));


        JTextField phoneNumberTf = new JTextField(20);
        phoneNumberTf.setText("Phone number");
        phoneNumberTf.setForeground(Color.lightGray);
        phoneNumberTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        phoneNumberTf.setPreferredSize(new Dimension(300,71));
        phoneNumberTf.setMinimumSize(new Dimension(300,71));

        JTextField addressTf = new JTextField(20);
        addressTf.setText("Address");
        addressTf.setForeground(Color.lightGray);
        addressTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        addressTf.setPreferredSize(new Dimension(300,71));
        addressTf.setMinimumSize(new Dimension(300,71));

        JTextField cityTf = new JTextField(20);
        cityTf.setText("City");
        cityTf.setForeground(Color.lightGray);
        cityTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        cityTf.setPreferredSize(new Dimension(300,71));
        cityTf.setMinimumSize(new Dimension(300,71));


        ArrayList<JTextField> textFields = new ArrayList<>();
        textFields.add(firstNameTf);
        textFields.add(lastNameTf);
        textFields.add(emailTf);
        textFields.add(phoneNumberTf);
        textFields.add(addressTf);
        textFields.add(cityTf);

        for (JTextField textField : textFields) {
            textField.addFocusListener(new FocusListener() {
                String temp = textField.getText();
                                           @Override
                                           public void focusGained(FocusEvent e) {
                                               if (textField.getText().equals("First Name")
                                                       || textField.getText().equals("Last Name")
                                                       || textField.getText().equals("Email Address")
                                                       || textField.getText().equals("Phone number")
                                                       || textField.getText().equals("Address")
                                                       || textField.getText().equals("City")) {
                                                   textField.setText("");
                                                   textField.setForeground(Color.black);
                                               }
                                           }

                                           @Override
                                           public void focusLost(FocusEvent e) {
                                               if (textField.getText().isEmpty()) {
                                                   textField.setText(temp);
                                                   textField.setForeground(Color.GRAY);
                                               }
                                           }
                                       });
        }

        bpCpCenterPanel.add(firstNameTf);
        bpCpCenterPanel.add(lastNameTf);
        bpCpCenterPanel.add(emailTf);
        bpCpCenterPanel.add(phoneNumberTf);
        bpCpCenterPanel.add(addressTf);
        bpCpCenterPanel.add(cityTf);


        //CENTER BOTTOM PANEL
        JPanel bpCpBottomPanel = new JPanel();
        bpCpBottomPanel.setPreferredSize(new Dimension(300, 168));
        bpCpBottomPanel.setBackground(Color.white);

        bpCenterPanel.add(bpCpTopPanel);
        bpCenterPanel.add(bpCpCenterPanel);
        bpCenterPanel.add(bpCpBottomPanel);

        JPanel bpRightPanel = new JPanel();
        bpRightPanel.setPreferredSize(new Dimension(200,763));
        bpRightPanel.setBackground(Color.white);

        backgroundPanel.add(bpLeftPanel);
        backgroundPanel.add(bpCenterPanel);
        backgroundPanel.add(bpRightPanel);

        add(leftPanel);
        add(backgroundPanel);
    }

}
