package Gui;

import Database.City;
import Database.Customer;
import Utilities.JTextFieldManipulator;
import Utilities.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SignUpPanel extends JPanel {

    private JTextField firstNameTf;
    private JTextField lastNameTf;
    private JTextField emailTf;
    private JTextField phoneNumberTf;
    private JTextField addressTf;
    private JTextField cityTf;
    private Customer customer;
    private ArrayList<Customer> customers;
    private final String firstName = "First Name";
    private final String lastName = "Last Name";
    private final String eMail = "Email Address";
    private final String phoneNumber = "Phone number";
    private final String address = "Address";
    private final String city = "City";
    private String tempCity;
    private Buttons buttons;
    private boolean isTextFieldReady = false;
    private boolean isPasswordFieldReady = false;

    public SignUpPanel(Buttons buttons){
        this.buttons = buttons;
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
        lastNameTf = new JTextField(20);
        emailTf = new JTextField(20);
        phoneNumberTf = new JTextField(20);
        addressTf = new JTextField(20);
        cityTf = new JTextField(20);

        List<JTextField> textFields = new ArrayList<>();
        textFields.add(firstNameTf);
        textFields.add(lastNameTf);
        textFields.add(emailTf);
        textFields.add(phoneNumberTf);
        textFields.add(addressTf);
        textFields.add(cityTf);

        for(JTextField textField : textFields){
            if(textField == firstNameTf){
                firstNameTf.setText(firstName);
            }
            if(textField == lastNameTf){
                lastNameTf.setText(lastName);

            }
            if(textField == emailTf){
                emailTf.setText(eMail);

            }
            if(textField == phoneNumberTf){
                phoneNumberTf.setText(phoneNumber);

            }
            if(textField == addressTf){
                addressTf.setText(address);

            }
            if(textField == cityTf){
                cityTf.setText(city);

            }
            textField.setForeground(Color.lightGray);
            textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
            textField.setMinimumSize(new Dimension(300,71));
        }



        textFields.forEach(textField -> new JTextFieldManipulator(textField));

        textFields.forEach(textField -> textField.addActionListener(e->{
            System.out.println(textField.getText());
        }));

        JPasswordField passwordField1 = new JPasswordField(20);
        JPasswordField passwordField2 = new JPasswordField(20);

        List<JPasswordField> passwordFields = new ArrayList<>();
        passwordFields.add(passwordField1);
        passwordFields.add(passwordField2);

        for(JPasswordField passwordField : passwordFields){
            if(passwordField == passwordField1){
                passwordField1.setText("Password");
            }
            if(passwordField == passwordField2){
                passwordField2.setText("Re-enter Password");

            }
            passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
            passwordField.setForeground(Color.lightGray);
        }

        passwordFields.forEach(passwordField -> new JTextFieldManipulator(passwordField));
        passwordFields.forEach(passwordField -> passwordField.addActionListener(e->{
            System.out.println(passwordField.getText());
        }));

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

        nextButton.addActionListener(e->{
            for(JTextField textField : textFields){
                if(textField.getText() == null || Objects.equals(textField.getText(), firstName) ||
                        Objects.equals(textField.getText(), lastName) || Objects.equals(textField.getText(), eMail) ||
                        Objects.equals(textField.getText(), phoneNumber) || Objects.equals(textField.getText(), address) ||
                        Objects.equals(textField.getText(), city)){
                        textField.setForeground(Color.RED);
                }
                else{
                    setNewCustomer(textField);
                    isTextFieldReady = true;
                }

            }
            for(JPasswordField passwordField : passwordFields){
                if(passwordField.getText() == null || passwordField.getText().isEmpty()){
                    passwordField.setForeground(Color.RED);
                }
            }
            if(!passwordField1.getText().equals(passwordField2.getText())||
                    passwordField1.getText() == null || passwordField1.getText().isEmpty()||
                    passwordField2.getText() == null || passwordField2.getText().isEmpty()){
                passwordField1.setForeground(Color.RED);
                passwordField2.setForeground(Color.RED);
            }
            else if (passwordField1.getText().equals(passwordField2.getText())) {
                setNewCustomerPassword(passwordField1);
                isPasswordFieldReady = true;
            }
            if(isTextFieldReady && isPasswordFieldReady){
                customer.getCityID();
                buttons.getGui().getMain().insertNewCustomer(customer);
                buttons.setState(State.INTRO);
                buttons.getGui().updateGui();
            }
        });
        add(leftPanel);
        add(backgroundPanel);

    }
    public void setNewCustomer(JTextField textField){
        if(textField.equals(firstNameTf)){
            customer.setCustomerFirstName(textField.getText());
        }
        if(textField.equals(lastNameTf)){
            customer.setCustomerLastName(textField.getText());
        }
        if(textField.equals(emailTf)){
            customer.setCustomerEMail(textField.getText());
        }
        if(textField.equals(phoneNumberTf)){
            customer.setCustomerPhoneNumber(textField.getText());
        }
        if(textField.equals(addressTf)){
            customer.setCustomerAddress(textField.getText());
        }
        if(textField.equals(cityTf)) {
            String targetCityName = cityTf.getText();
            List<City> cities = buttons.getGui().getMain().getCity();

            boolean doOperation = true;
            while (doOperation) {
                boolean matchFound = cityNameMatch(targetCityName, cities);
                if (matchFound) {
                    System.out.println("Match found: " + targetCityName);
                    Optional<City> cityObject = cities.stream().filter(city -> city.getCityName().equalsIgnoreCase(targetCityName)).findFirst();
                    if (cityObject.isPresent()) {
                        int cityID = cityObject.get().getCityID();
                        customer.setCityID(cityID);
                        doOperation = false;
                    }

                } else {
                    System.out.println("No match found for: " + targetCityName);

                    City city = new City();
                    city.setCityName(targetCityName);
                    buttons.getGui().getMain().insertNewCity(city);
                    cities = buttons.getGui().getMain().getCity();
                }
            }
        }
    }
    public void setNewCustomerPassword(JPasswordField passwordField){
        customer.setPassword(passwordField.getText());
    }
    public boolean cityNameMatch(String targetCityName, List<City> cities){
        cities = buttons.getGui().getMain().getCity();

        if(cities.stream().anyMatch(city -> city.getCityName().equalsIgnoreCase(targetCityName))){
            return true;
        }
        else{
            return false;
        }
    }
}
