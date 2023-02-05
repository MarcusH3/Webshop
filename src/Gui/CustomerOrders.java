package Gui;
import DataBaseConnections.DataBaseConnection;
import Database.*;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class CustomerOrders {

    private List<CoordinationTable> coordinationTables;
    private List<Order> orders;
    private List<Customer> customers;


    public CustomerOrders(){
        coordinationTables = DataBaseConnection.getCTable("root", "marcusedlund");
        orders = DataBaseConnection.getOrders("root", "marcusedlund");
        customers = DataBaseConnection.getCustomer("root", "Wmarcusedlund");
    }
    public static void main(String[] args) {
            CustomerOrders c = new CustomerOrders();
            List<String> customersOrder = c.getNumberOfOrdersByCustomer();
            System.out.println("Customers and their number of orders:");
            for (String s : customersOrder)
                System.out.println(s);
        }

    public List<String> getNumberOfOrdersByCustomer(){
        List<String> customersOrder = new ArrayList<>();
        for(CoordinationTable coordinationTable: coordinationTables){
            int customerID = coordinationTable.getCustomerID();
            int orderCount = 0;
            for(Order order: orders){
                if(order.getCoordinationTableID() == customerID){
                    orderCount++;
                }
            }
            Optional<Customer> customer = customers.stream().filter(c -> c.getCustomerID() == customerID).findFirst();
            if(customer.isPresent()){
                customersOrder.add(customer.get().getCustomerFirstName() + " " + customer.get().getCustomerLastName() + " " + orderCount);
            }
        }
        return customersOrder;
    }
}


/* 2 En rapport som listar alla kunder och hur mycket pengar varje kund, sammanlagt, har beställt för.
Skriv ut varje kunds namn och summa.
 */