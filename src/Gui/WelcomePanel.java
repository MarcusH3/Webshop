package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class WelcomePanel extends JPanel{

    public WelcomePanel(Buttons buttons){

        setBackground(Color.white);
        setLayout(new GridLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(Color.WHITE);

        ImageIcon welcomeImage = new ImageIcon("Res/Title7.png");
        JLabel welcomeLabel = new JLabel(welcomeImage);
        leftPanel.add(welcomeLabel, BorderLayout.WEST);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));


        //TOP PANEL ATTRIBUTES
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JPanel upperBorder = new JPanel();
        upperBorder.setBackground(Color.white);
        upperBorder.setPreferredSize(new Dimension(500,84));

        JPanel centerTop = new JPanel();
        centerTop.setPreferredSize(new Dimension(500,84));
        centerTop.setLayout(new BorderLayout());
        centerTop.setBackground(Color.white);

        JPanel ctLeft = new JPanel();
        ctLeft.setPreferredSize(new Dimension(100,84));
        ctLeft.setBackground(Color.white);

        JPanel ctCenter = new JPanel();
        ctCenter.setLayout(new BorderLayout());
        ctCenter.setPreferredSize(new Dimension(300,84));
        ctCenter.setBackground(Color.WHITE);

        JPanel ctRight = new JPanel();
        ctRight.setPreferredSize(new Dimension(100, 84));
        ctRight.setBackground(Color.white);

        JPanel loweBorder = new JPanel();
        loweBorder.setBackground(Color.white);
        loweBorder.setPreferredSize(new Dimension(500,84));

        JLabel title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        title.setAlignmentX(LEFT_ALIGNMENT);
        ctCenter.add(title, BorderLayout.WEST);

        centerTop.add(ctLeft, BorderLayout.WEST);
        centerTop.add(ctCenter, BorderLayout.CENTER);
        centerTop.add(ctRight, BorderLayout.EAST);

        //CENTER PANEL ATTRIBUTES
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel leftBorder = new JPanel();
        leftBorder.setPreferredSize(new Dimension(100,253));
        leftBorder.setBackground(Color.white);
        JPanel rightBorder = new JPanel();
        rightBorder.setBackground(Color.white);
        rightBorder.setPreferredSize(new Dimension(100,253));
        JPanel centerBorder = new JPanel();
        centerBorder.setLayout(new BoxLayout(centerBorder,BoxLayout.Y_AXIS));
        centerBorder.setPreferredSize(new Dimension(300,253));

        //CENTER PANEL ELEMENTS
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField textField = new JTextField(20);
        textField.setText("Username");
        textField.setForeground(Color.lightGray);
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Username")) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("Username");
                    textField.setForeground(Color.GRAY);
                }
            }
        });

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        passwordField.setText("Password");
        passwordField.setForeground(Color.lightGray);
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("Password")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("Password");
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });


        //BOTTOM PANEL ATTRIBUTES
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setLayout(new BorderLayout());

        JPanel bpLefPanel = new JPanel();
        bpLefPanel.setPreferredSize(new Dimension(100, 253));
        bpLefPanel.setBackground(Color.white);

        JPanel bpCenterPanel = new JPanel();
        bpCenterPanel.setLayout(new BoxLayout(bpCenterPanel,BoxLayout.Y_AXIS));
        bpCenterPanel.setPreferredSize(new Dimension(300, 253));
        bpCenterPanel.setBackground(Color.white);

        JPanel bpCpTopPanel = new JPanel();
        bpCpTopPanel.setPreferredSize(new Dimension(300,84));
        bpCpTopPanel.setBackground(Color.WHITE);

        JPanel bpCpCenterPanel = new JPanel();
        bpCpCenterPanel.setLayout(new BorderLayout());
        bpCpCenterPanel.setPreferredSize(new Dimension(300,84));
        bpCpCenterPanel.setBackground(Color.WHITE);

        JButton loginButton = buttons.getLoginButton();
        loginButton.setPreferredSize(new Dimension(100,84));
        loginButton.setBackground(Color.WHITE);

        JButton exitButton = buttons.getExitButton();
        exitButton.setPreferredSize(new Dimension(100,84));
        exitButton.setBackground(Color.WHITE);

        bpCpCenterPanel.add(loginButton, BorderLayout.WEST);
        bpCpCenterPanel.add(exitButton,BorderLayout.EAST);

        JPanel bpCpBottomPanel = new JPanel();
        bpCpBottomPanel.setPreferredSize(new Dimension(300,84));
        bpCpBottomPanel.setBackground(Color.WHITE);
        bpCpBottomPanel.setLayout(new BorderLayout());
        bpCpBottomPanel.add(buttons.getSignUpButton());

        bpCenterPanel.add(bpCpTopPanel);
        bpCenterPanel.add(bpCpCenterPanel);
        bpCenterPanel.add(bpCpBottomPanel);

       // bpCenterPanel.add(buttons.getLoginButton(), BorderLayout.WEST);
        //bpCenterPanel.add(buttons.getExitButton(), BorderLayout.EAST);

        JPanel bpRightPanel = new JPanel();
        bpRightPanel.setPreferredSize(new Dimension(100, 253));
        bpRightPanel.setBackground(Color.white);


        //ADD TO PANELS
        topPanel.setBackground(Color.white);
        topPanel.add(upperBorder);
        topPanel.add(centerTop);
        topPanel.add(loweBorder);

        JPanel cbTopBorder = new JPanel();
        cbTopBorder.setPreferredSize(new Dimension(300,84));
        cbTopBorder.setBackground(Color.WHITE);

        JPanel cbBottomBorder = new JPanel();
        cbBottomBorder.setPreferredSize(new Dimension(300,84));
        cbBottomBorder.setBackground(Color.WHITE);

        JPanel cbCenterBorder = new JPanel();
        cbCenterBorder.setPreferredSize(new Dimension(300,84));
        cbCenterBorder.setBackground(Color.WHITE);
        cbCenterBorder.setLayout(new BoxLayout(cbCenterBorder, BoxLayout.Y_AXIS));

        centerBorder.setBackground(Color.WHITE);
        cbCenterBorder.add(usernameLabel);
        cbCenterBorder.add(textField);
        cbCenterBorder.add(passwordLabel);
        cbCenterBorder.add(passwordField);

        centerBorder.add(cbTopBorder);
        centerBorder.add(cbCenterBorder);
        centerBorder.add(cbBottomBorder);

        centerPanel.add(leftBorder,BorderLayout.WEST);
        centerPanel.add(centerBorder,BorderLayout.CENTER);
        centerPanel.add(rightBorder, BorderLayout.EAST);


        bottomPanel.setBackground(Color.white);


        topPanel.setPreferredSize(new Dimension(500,253));
        centerPanel.setPreferredSize(new Dimension(500,253));
        bottomPanel.setPreferredSize(new Dimension(500,253));

        bottomPanel.add(bpLefPanel, BorderLayout.WEST);
        bottomPanel.add(bpCenterPanel, BorderLayout.CENTER);
        bottomPanel.add(bpRightPanel, BorderLayout.EAST);

        backgroundPanel.add(topPanel);
        backgroundPanel.add(centerPanel);
        backgroundPanel.add(bottomPanel);

        add(leftPanel);
        add(backgroundPanel);
    }

}
