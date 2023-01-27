package DataBaseConnections;

import Database.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DataBaseConnection {
private Connection con;
private static Properties properties;


    public static Connection createConnection(){
        Connection con = null;
        return con;
    }

    public static void getCustomer(String username, String password){

        ArrayList<Customer> customers = new ArrayList<>();
        try {
            properties = new Properties();
            InputStream input = new FileInputStream("res/config.properties");
            properties.load(input);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try(Connection con = DriverManager.getConnection(
                properties.getProperty("urlString"), username,password)){
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT customerID, customerFirstName,customerLastName,customerAddress, customerEmail, customerPhoneNumber, cityID from customers");

            while(resultSet.next()){
                int customerID = resultSet.getInt("customerID");
                String firstName = resultSet.getString("customerFirstName");
                String lastName = resultSet.getString("customerLastName");
                String customerAddress = resultSet.getString("customerAddress");
                String customerEmail = resultSet.getString("customerEmail");
                String customerPhoneNumber = resultSet.getString("customerPhoneNumber");
                int cityID = resultSet.getInt("cityID");

                Customer customer = new Customer(customerID, firstName,lastName, customerPhoneNumber, customerEmail,null, customerAddress,cityID);
                customers.add(customer);

            }
            System.out.println("bajs");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

public static void connectAndQueryDB(String username, String password){

        try {
            properties = new Properties();
            InputStream input = new FileInputStream("res/config.properties");
            properties.load(input);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    try(Connection con = DriverManager.getConnection(
            properties.getProperty("urlString"), username,password)){
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT customerFirstName,customerLastName from customers");

            while(resultSet.next()){
                String firstName = resultSet.getString("customerFirstName");
                String lastName = resultSet.getString("customerLastName");

                System.out.println(lastName+", "+firstName+"\n");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
}

    public static void getTopFive(String username, String password){

        try {
            properties = new Properties();
            InputStream input = new FileInputStream("res/config.properties");
            properties.load(input);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try(Connection con = DriverManager.getConnection(
                properties.getProperty("urlString"), username,password)){
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT product.modelName, sum(orderdetail.quantity) as 'quantity'\n" +
                    "from product\n" +
                    "join inventory\n" +
                    "on product.productID = inventory.productID\n" +
                    "join orderdetail\n" +
                    "on orderdetail.inventoryID = inventory.inventoryID\n" +
                    "join coordinationTable\n" +
                    "on coordinationTable.coordinationTableID = orderdetail.coordinationTableID\n" +
                    "join orders\n" +
                    "on orders.coordinationTableID = coordinationTable.coordinationTableID\n" +
                    "group by product.modelName\n" +
                    "ORDER BY sum(orderdetail.quantity) DESC\n" +
                    "limit 5");

            while(resultSet.next()){
                String firstName = resultSet.getString("product.ModelName");
                String lastName = resultSet.getString("quantity");

                System.out.println(lastName+", "+firstName+"\n");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
       /* Data Access Object (DAO): A DAO is a class that abstracts the details of how the data is stored in the database,
        and provides a set of methods that the rest of the program can use to perform CRUD (Create, Read, Update, Delete)
        operations on the data.

        Database Connection: A class that handles connecting to the database and managing the connection. This class typically
        uses a JDBC (Java Database Connectivity) driver to connect to the database.
        Data Transfer Object (DTO): A DTO is a simple class that holds the data retrieved from the database and passed between
        the program and the DAO.

        Business Logic: The main class that handles the business logic of the program, it uses the DAO class to interact with the
        database and DTO classes to hold the data.

        Main: The main class that runs the program, it creates an instance of the business logic class and calls the methods to
        perform the desired operations.*/


    public static void addToCart(Integer currentCustomerOrder, Customer whoIsLoggedIn, int id) {
        try (Connection con = createConnection();
             CallableStatement cstmt = con.prepareCall("{CALL addToCart(?,?,?)}")) {

            cstmt.setInt(1, currentCustomerOrder);
            cstmt.setInt(2, whoIsLoggedIn.getId());
            cstmt.setInt(3, id);
            cstmt.execute();



           /*.showMessage("Added to cart", "New item added to  cart", null, Alert.AlertType.INFORMATION);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            if (!.isLoggedIn){
                .showMessage("Not logged in!", "You need to be logged in\nto make and order", null, Alert.AlertType.ERROR);
            }else {
                .showMessage("No Order", "You need to create a order first,\nbefore you can add products", null, Alert.AlertType.ERROR);
            }

        }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static void removeFromCart (Integer currentCustomerOrder, Customer whoIsLoggedIn,int id){

            try (Connection con = createConnection();
                 CallableStatement cstmt = con.prepareCall("{CALL remove_form_cart(?,?,?)}")) {

                cstmt.setInt(1, currentCustomerOrder);
                cstmt.setInt(2, whoIsLoggedIn.getId());
                cstmt.setInt(3, id);
                cstmt.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
