package DataBaseConnections;

import Database.City;
import Database.Customer;
import Gui.Gui;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<City> getCity(){
        List<City> city = new ArrayList<>();
        city = DataBaseConnection.getCity("root", "marcusedlund");
        return city;
    }
    public List<String> getProductByCategory(String gender, String category){
        List<String> products = new ArrayList<>();
        products = DataBaseConnection.getModelByCategory("root", "marcusedlund", gender, category);
        return products;
    }
    public List<String> getCategoryByGender(String gender){
        List<String> categories = new ArrayList<>();
        categories = DataBaseConnection.getCategoryByGender("root", "marcusedlund", gender);
        return categories;
    }
    public List<String> getGender(){
        List<String> genders = new ArrayList<>();
        genders = DataBaseConnection.getGender("root", "marcusedlund");
        return genders;
    }

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
       Gui.getInstance();
    }

}
