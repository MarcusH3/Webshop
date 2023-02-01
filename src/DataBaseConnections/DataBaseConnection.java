package DataBaseConnections;

import Database.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataBaseConnection {
private Connection con;
private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customers (customerFirstName, CustomerLastName" +
        ",customerAddress,customerEmail,customerPassword,customerPhoneNumber,CityID) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_CITY_SQL = "INSERT INTO city (cityName) VALUES (?)";

    private static Properties properties;


    public static Connection createConnection(){
        Connection con = null;
        return con;
    }

    public static List<String> getModelByCategory(String username, String password, String gender, String category){

        List<String> products = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT product.modelName\n" +
                    "FROM subcategory\n" +
                    "JOIN \n" +
                    "category \n" +
                    "on category.subcategoryID = subcategory.subCategoryID\n" +
                    "join gendercategory\n" +
                    "on category.genderCategoryID = gendercategory.genderCategoryID\n" +
                    "join product\n" +
                    "on product.categoryID = category.categoryID\n" +
                    "and product.categoryID = category.categoryID\n" +
                    "where gendercategory.genderCategoryName = '" + gender + "' and subcategory.subCategoryName = '" + category +"'");

            while(resultSet.next()){
                String model = resultSet.getString("product.modelName");
                products.add(model);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    public static List<String> getCategoryByGender(String username, String password, String gender){

        List<String> categories = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT subcategory.subcategoryName\n" +
                    "FROM subcategory\n" +
                    "JOIN \n" +
                    "category \n" +
                    "on category.subcategoryID = subcategory.subCategoryID\n" +
                    "join gendercategory\n" +
                    "on category.genderCategoryID = gendercategory.genderCategoryID\n" +
                    "where genderCategoryName = '" + gender + "'");

            while(resultSet.next()){
                String category = resultSet.getString("subcategory.subcategoryName");
                categories.add(category);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }
    public static List<String> getGender(String username, String password){

        List<String> genderList = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT genderCategory.genderCategoryName from genderCategory");

            while(resultSet.next()){
                String gender = resultSet.getString("genderCategory.genderCategoryName");
                genderList.add(gender);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return genderList;
    }

    public static List<String> getProduct(String username, String password){

        ArrayList<String> products = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT product.modelName from product");

            while(resultSet.next()){
                String modelName = resultSet.getString("product.ModelName");
                products.add(modelName);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
    public static List<String> getSizeByProduct(String username, String password, String productName){

        List<String> size = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT size.euSize FROM size " +
                    "JOIN product " +
                    "ON product.sizeID = size.sizeID " +
                    "WHERE product.modelName = '" + productName + "'");

            while(resultSet.next()){
                String euSize = resultSet.getString("size.euSize");
                size.add(euSize);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return size;
    }
    public static List<String> getColorByProduct(String username, String password, String productName){

        List<String> color = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT color.colorName FROM color " +
                    "JOIN product " +
                    "ON product.colorID = color.colorID " +
                    "WHERE product.modelName = '" + productName + "'");

            while(resultSet.next()){
                String colorName = resultSet.getString("color.colorName");
                color.add(colorName);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return color;
    }

    public static ArrayList<Customer> getCustomer(String username, String password){

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
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return customers;
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

    public static ArrayList<String> getTopFive(String username, String password){

        ArrayList<String> topFive = new ArrayList<>();
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
                String modelName = resultSet.getString("product.ModelName");
                String quantity = resultSet.getString("quantity");

                topFive.add(modelName + " " + quantity);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return topFive;
    }

    public static List<City> getCity(String username, String password){


        List<City> cityList = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT city.cityId, city.cityName from city");

            while(resultSet.next()){
                int cityID = resultSet.getInt("city.cityID");
                String cityName = resultSet.getString("city.cityName");

                City city = new City();
                city.setCityID(cityID);
                city.setCityName(cityName);
                cityList.add(city);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cityList;
    }

    public static void insertCustomer(String username, String password, Customer customer){

        try {
            properties = new Properties();
            InputStream input = new FileInputStream("res/config.properties");
            properties.load(input);
        }
        catch (IOException e){
            e.printStackTrace();
        };

        try(Connection con = DriverManager.getConnection(
                properties.getProperty("urlString"), username,password)){


                PreparedStatement preparedStatement = con.prepareStatement(INSERT_CUSTOMER_SQL);{
                preparedStatement.setString(1, customer.getCustomerFirstName());
                preparedStatement.setString(2, customer.getCustomerLastName());
                preparedStatement.setString(3, customer.getCustomerAddress());
                preparedStatement.setString(4, customer.getEmail());
                preparedStatement.setString(5, customer.getPassword());
                preparedStatement.setString(6, customer.getCustomerPhoneNumber());
                preparedStatement.setInt(7, customer.getCityID());
                preparedStatement.executeUpdate();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void insertCity(String username, String password, City City){

        try {
            properties = new Properties();
            InputStream input = new FileInputStream("res/config.properties");
            properties.load(input);
        }
        catch (IOException e){
            e.printStackTrace();
        };

        try(Connection con = DriverManager.getConnection(
                properties.getProperty("urlString"), username,password)){


            PreparedStatement preparedStatement = con.prepareStatement(INSERT_CITY_SQL);{
                preparedStatement.setString(1, City.getCityName());
                preparedStatement.executeUpdate();
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
