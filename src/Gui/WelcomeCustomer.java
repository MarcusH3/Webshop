package Gui;

import Database.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class WelcomeCustomer extends JPanel{
    private final List<Customer> customers;
    private final int customerID;
    public WelcomeCustomer(Buttons buttons) {
        customers = buttons.getGui().getMain().getCustomer();
        customerID = buttons.getCustID();

        setBackground(Color.white);
        setPreferredSize(new Dimension(700,763));
        setLayout(new FlowLayout());

        JLabel label = new JLabel();
        label.setText(getCustomerName());
        label.setOpaque(false);
        label.setForeground(Color.black);

        add(label);
    }

    public String getCustomerName(){
        int temp = customerID;
        String name = customers.stream().filter(c-> c.getCustomerID() == customerID)
                .map(Customer::getFullName).findFirst().orElse("");
        return "Welcome "+name;

    }
}
