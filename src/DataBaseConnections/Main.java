package DataBaseConnections;

import java.util.ArrayList;

public class Main {

    public ArrayList<String> getProduct(){
        ArrayList<String> products = new ArrayList<>();
        products = DataBaseConnection.getProduct("root", "marcusedlund");
        return products;
    }
    public ArrayList<String> getTopFive(){
        ArrayList<String> topFive = new ArrayList<>();
       topFive = DataBaseConnection.getTopFive("root", "marcusedlund");
       return topFive;
    }
    public void getCustomer(){
        DataBaseConnection.getCustomer("root", "marcusedlund");
    }
    public static void main(String[] args) {

    }

}
