package Gui;

import Database.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class SignUpPanel extends JPanel {

    private JTextField firstNameTf;
    private JTextField lastNameTf;
    private JTextField emailTf;
    private JTextField phoneNumberTf;
    private JTextField addressTf;
    private JTextField cityTf;
    private Customer customer;
    private ArrayList<Customer> customers;
    public SignUpPanel(Buttons buttons){

        customer = new Customer();

        setBackground(Color.white);
        setLayout(new GridLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(Color.white);

        ImageIcon welcomeImage = new ImageIcon("Res/Title7.png");
        JLabel welcomeLabel = new JLabel(welcomeImage);
        leftPanel.add(welcomeLabel, BorderLayout.WEST);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        //TOP PANEL ATTRIBUTES
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500,84));

        //CENTER PANEL ATTRIBUTES
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel leftBorder = new JPanel();
        leftBorder.setPreferredSize(new Dimension(100,421));
        leftBorder.setBackground(Color.white);
        JPanel rightBorder = new JPanel();
        rightBorder.setBackground(Color.white);
        rightBorder.setPreferredSize(new Dimension(100,421));
        JPanel centerBorder = new JPanel();
        centerBorder.setLayout(new BoxLayout(centerBorder,BoxLayout.Y_AXIS));
        centerBorder.setPreferredSize(new Dimension(300,421));

        //CENTER PANEL ELEMENTS
        firstNameTf = new JTextField(20);
        firstNameTf.setText("First Name");
        firstNameTf.setForeground(Color.lightGray);
        firstNameTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        firstNameTf.setMinimumSize(new Dimension(300,71));
        //firstNameTf.setPreferredSize(new Dimension(300,71));
        //firstNameTf.setMinimumSize(new Dimension(300,71));

        lastNameTf = new JTextField(20);
        lastNameTf.setText("Last Name");
        lastNameTf.setForeground(Color.lightGray);
        lastNameTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        //lastNameTf.setPreferredSize(new Dimension(300,71));
        //lastNameTf.setMinimumSize(new Dimension(300,71));

        emailTf = new JTextField(20);
        emailTf.setText("Email Address");
        emailTf.setForeground(Color.lightGray);
        emailTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        //emailTf.setPreferredSize(new Dimension(300,71));
        //emailTf.setMinimumSize(new Dimension(300,71));


        phoneNumberTf = new JTextField(20);
        phoneNumberTf.setText("Phone number");
        phoneNumberTf.setForeground(Color.lightGray);
        phoneNumberTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        //phoneNumberTf.setPreferredSize(new Dimension(300,71));
        //phoneNumberTf.setMinimumSize(new Dimension(300,71));

        addressTf = new JTextField(20);
        addressTf.setText("Address");
        addressTf.setForeground(Color.lightGray);
        addressTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        //addressTf.setPreferredSize(new Dimension(300,71));
        //addressTf.setMinimumSize(new Dimension(300,71));

        cityTf = new JTextField(20);
        cityTf.setText("City");
        cityTf.setForeground(Color.lightGray);
        cityTf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        //cityTf.setPreferredSize(new Dimension(300,71));
        //cityTf.setMinimumSize(new Dimension(300,71));

        List<JTextField> textFields1 = new ArrayList<>();
        ArrayList<JTextField> textFields = new ArrayList<>();
        textFields.add(firstNameTf);
        textFields.add(lastNameTf);
        textFields.add(emailTf);
        textFields.add(phoneNumberTf);
        textFields.add(addressTf);
        textFields.add(cityTf);

        textFields.forEach(textField -> new JTextFieldManipulator(textField));
        textFields.forEach(textField -> new JTextFieldManipulator(textField).initActionListener(textField, e->{
            System.out.println(textField.getText());
        }));

        JPasswordField passwordField1 = new JPasswordField(20);
        passwordField1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        passwordField1.setText("Password");
        passwordField1.setForeground(Color.lightGray);

        JPasswordField passwordField2 = new JPasswordField(20);
        passwordField2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        passwordField2.setText("Re-enter Password");
        passwordField2.setForeground(Color.lightGray);

        List<JPasswordField> passwordFields = new ArrayList<>();
        passwordFields.add(passwordField1);
        passwordFields.add(passwordField2);

        passwordFields.forEach(passwordField -> new JTextFieldManipulator(passwordField));

        //BOTTOM PANEL ATTRIBUTES
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setLayout(new BorderLayout());

        JPanel bpLefPanel = new JPanel();
        bpLefPanel.setPreferredSize(new Dimension(100, 421));
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

        JButton nextButton = buttons.getNextButton();
        nextButton.setPreferredSize(new Dimension(100,84));
        nextButton.setBackground(Color.WHITE);

        JButton previousButton = buttons.getPreviousButton();
        previousButton.setPreferredSize(new Dimension(100,84));
        previousButton.setBackground(Color.WHITE);

        bpCpCenterPanel.add(nextButton, BorderLayout.WEST);
        bpCpCenterPanel.add(previousButton,BorderLayout.EAST);

        JPanel bpCpBottomPanel = new JPanel();
        bpCpBottomPanel.setPreferredSize(new Dimension(300,84));
        bpCpBottomPanel.setBackground(Color.WHITE);
        bpCpBottomPanel.setLayout(new BorderLayout());

        bpCenterPanel.add(bpCpTopPanel);
        bpCenterPanel.add(bpCpCenterPanel);
        bpCenterPanel.add(bpCpBottomPanel);

        //bpCenterPanel.add(buttons.getLoginButton(), BorderLayout.WEST);
        //bpCenterPanel.add(buttons.getExitButton(), BorderLayout.EAST);

        JPanel bpRightPanel = new JPanel();
        bpRightPanel.setPreferredSize(new Dimension(100, 253));
        bpRightPanel.setBackground(Color.white);


        //ADD TO PANELS
        topPanel.setBackground(Color.white);

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
        cbCenterBorder.add(firstNameTf);
        cbCenterBorder.add(lastNameTf);
        cbCenterBorder.add(emailTf);
        cbCenterBorder.add(phoneNumberTf);
        cbCenterBorder.add(addressTf);
        cbCenterBorder.add(cityTf);
        cbCenterBorder.add(passwordField1);
        cbCenterBorder.add(passwordField2);

        centerBorder.add(cbTopBorder);
        centerBorder.add(cbCenterBorder);
        centerBorder.add(cbBottomBorder);

        centerPanel.add(leftBorder,BorderLayout.WEST);
        centerPanel.add(centerBorder,BorderLayout.CENTER);
        centerPanel.add(rightBorder, BorderLayout.EAST);

        bottomPanel.setBackground(Color.white);

        centerPanel.setPreferredSize(new Dimension(500,431));
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
    public void getNewCustomer(JTextField textField){
        String temp = textField.getText();
        if(textField.equals(firstNameTf)){
            customer.setCustomerFirstName(textField.getText());

        }
        if(textField.equals(lastNameTf)){
            customer.setCustomerLastName(textField.getText());

        }
        System.out.println("hej");
    }
}
