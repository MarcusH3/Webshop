package DataBaseConnections;

import Database.Customer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<String> getColorByProduct(String productName){
        List<String> products = new ArrayList<>();
        products = DataBaseConnection.getColorByProduct("root", "marcusedlund", productName);
        return products;
    }
    public List<String> getSizeByProduct(String productName){
        List<String> products = new ArrayList<>();
        products = DataBaseConnection.getSizeByProduct("root", "marcusedlund", productName);
        return products;
    }
    public List<String> getProduct(){
        List<String> products = new ArrayList<>();
        products = DataBaseConnection.getProduct("root", "marcusedlund");
        return products;
    }
    public ArrayList<String> getTopFive(){
        ArrayList<String> topFive = new ArrayList<>();
       topFive = DataBaseConnection.getTopFive("root", "marcusedlund");
       return topFive;
    }
    public ArrayList<Customer> getCustomer(){
        ArrayList<Customer> customers;
        customers = DataBaseConnection.getCustomer("root", "marcusedlund");
        return customers;
    }
    public static void main(String[] args) {

    }

}
