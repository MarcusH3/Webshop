package Gui;

import DataBaseConnections.DataBaseConnection;
import Database.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class customerSpending {

    private List<OrderDetail> orderDetails;
    private List<Product> products;
    private List<Inventory> inventory;
    private List<Customer> customers;
    private List<CoordinationTable> coordinationTables;
    public customerSpending(){
        orderDetails = DataBaseConnection.getOrderDetail("root", "Wa_(hmarcusedlund");
        products = DataBaseConnection.getProduct("root", "marcusedlund");
        inventory = DataBaseConnection.getInventory("root", "marcusedlund");
        customers = DataBaseConnection.getCustomer("root", "marcusedlund");
        coordinationTables = DataBaseConnection.getCTable("root", "marcusedlund");
    }

    public static void main(String[] args) {
        customerSpending c = new customerSpending();
        List<String> customersTotalSpent = c.getCustomersTotalSpent();
        System.out.println("Customers and their total spent:");
        for (String s : customersTotalSpent)
            System.out.println(s);
    }

    public List<String> getCustomersTotalSpent() {
        List<String> customersTotalSpent = new ArrayList<>();
        List<Integer> coordinationTableIDs = orderDetails.stream().map(OrderDetail::getCoordinationTableID).collect(Collectors.toList());        Set<Integer> uniqueCoordinationTableIDs = new HashSet<>(coordinationTableIDs);
        for (Integer coordinationTableID : uniqueCoordinationTableIDs) {
            double totalSpent = 0;
            for (int i = 0; i < orderDetails.size(); i++) {
                if (orderDetails.get(i).getCoordinationTableID() == coordinationTableID) {
                    int finalI = i;
                    double price = products.stream().filter(p -> p.getProductID() == inventory.get(finalI).getProductID()).findFirst().get().getPrice();
                    totalSpent += price * orderDetails.get(i).getQuantity();

                    int customerID = coordinationTables.stream().filter(c -> c.getCoordinationTableID() == coordinationTableID).findFirst().get().getCustomerID();
                    customersTotalSpent.add(customers.stream().filter(c -> c.getCustomerID() == customerID).findFirst().get().getCustomerFirstName() + " "
                            + customers.
                            stream().
                            filter(c -> c.getCustomerID() == customerID).
                            findFirst().get().getCustomerLastName() + " - " + totalSpent);
                }
            }

        }
        return customersTotalSpent;
    }
}


/* 3 En rapport som listar alla kunder och hur mycket pengar varje kund, sammanlagt, har beställt för.
Skriv ut varje kunds namn och summa */
