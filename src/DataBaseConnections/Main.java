package DataBaseConnections;

import Database.*;
import Gui.Gui;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Inventory> getInventory(){
        List<Inventory> inventories;
        inventories = DataBaseConnection.getInventory("root","marcusedlund");
        return inventories;
    }

    public List<Category> getCategories(){
        List<Category> categories;
        categories = DataBaseConnection.getCategory("root","marcusedlund");
        return categories;
    }

    public void insertNewCity(City city){
        DataBaseConnection.insertCity("root","marcusedlund", city);
    }
    public void insertNewCustomer(Customer customer){
        DataBaseConnection.insertCustomer("root","marcusedlund", customer);
    }

    public List<City> getCity(){
        List<City> city = new ArrayList<>();
        city = DataBaseConnection.getCity("root", "marcusedlund");
        return city;
    }
    public List<GenderCategory> getGender(){
        List<GenderCategory> genders;
        genders = DataBaseConnection.getGender("root", "marcusedlund");
        return genders;
    }
    public List<SubCategory> getSubCategory(){
        List<SubCategory> subCategories;
        subCategories = DataBaseConnection.getSubCategory("root", "marcusedlund");
        return subCategories;
    }

    public List<Color> getColor(){
        List<Color> colors;
        colors = DataBaseConnection.getColor("root", "marcusedlund");
        return colors;
    }
    public List<Size> getSize(){
        List<Size> sizes;
        sizes = DataBaseConnection.getSize("root", "marcusedlund");
        return sizes;
    }
    public List<Order> getOrders(){
        List<Order> orders;
        orders = DataBaseConnection.getOrders("root", "marcusedlund");
        return orders;
    }
    public List<CoordinationTable> getCTable(){
        List<CoordinationTable> coordinationTables;
        coordinationTables = DataBaseConnection.getCTable("root", "marcusedlund");
        return coordinationTables;
    }
    public List<OrderDetail> getOrderDetail(){
        List<OrderDetail> orderDetailList;
        orderDetailList = DataBaseConnection.getOrderDetail("root", "marcusedlund");
        return orderDetailList;
    }

    /*public List<String> getProduct(){
        List<String> products = new ArrayList<>();
        products = DataBaseConnection.getProduct("root", "marcusedlund");
        return products;
    }*/
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
    public ArrayList<Product> getProduct() {
        ArrayList<Product> products;
        products = (ArrayList<Product>) DataBaseConnection.getProduct("root","marcusedlund");
        return products;
    }


    public static void main(String[] args) {
       Gui.getInstance();
    }
}

