package DataBaseConnections;

import Database.*;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class DataBaseConnection {
private Connection con;
private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customers (customerFirstName, CustomerLastName" +
        ",customerAddress,customerEmail,customerPassword,customerPhoneNumber,CityID) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_CITY_SQL = "INSERT INTO city (cityName) VALUES (?)";
    private static final String sql_string = "call addTocart(?,?,?)";

    private static Properties properties;


    public static Connection createConnection(){
        Connection con = null;
        return con;
    }

    public static boolean isLoginValid(String customerEMail, String customerPassword){
        try (Connection con = createConnection();
             PreparedStatement stmt = con.prepareStatement(
                     "SELECT * FROM myseconddatabase.customers" +
                             " WHERE customers.customerEMail =? AND customerPassword =?")){

            stmt.setString((1), customerEMail);
            stmt.setString(2,customerPassword);

            ResultSet rs = stmt.executeQuery();
            // TODO: 2023-02-01  If login is valid, return true and present new GUI screeen.
            if(rs.next()){
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }  // TODO: 2023-02-01  If login not valid, return false and present error message or direct to create new user.




    public static List<GenderCategory> getGender(String username, String password){

        List<GenderCategory> genderList = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT * from genderCategory");

            while(resultSet.next()){
                int genderID = resultSet.getInt("genderCategory.genderCategoryID");
                String gender = resultSet.getString("genderCategory.genderCategoryName");
                GenderCategory genderCategory = new GenderCategory();
                genderCategory.setGenderCategoryID(genderID);
                genderCategory.setGenderCategoryName(gender);

                genderList.add(genderCategory);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return genderList;
    }

    public static List<SubCategory> getSubCategory(String username, String password){

        List<SubCategory> subCategories = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT * from subCategory");

            while(resultSet.next()){
                int subCategoryID = resultSet.getInt("subCategory.subCategoryID");
                String subCategoryName = resultSet.getString("subCategory.subCategoryName");
                SubCategory subCategory = new SubCategory();
                subCategory.setSubCategoryID(subCategoryID);
                subCategory.setSubCategoryName(subCategoryName);

                subCategories.add(subCategory);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return subCategories;
    }

    public static List<Color> getColor(String username, String password){

        List<Color> colors = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT * from Color");

            while(resultSet.next()){
                int colorID = resultSet.getInt("Color.ColorID");
                String colorName = resultSet.getString("Color.ColorName");
                Color color = new Color();
                color.setColorID(colorID);
                color.setColorName(colorName);

                colors.add(color);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return colors;
    }

    public static List<Size> getSize(String username, String password){

        List<Size> sizes = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT * from Size");

            while(resultSet.next()){
                int sizeID = resultSet.getInt("size.sizeID");
                int euSize = resultSet.getInt("size.euSize");
                int ukSize = resultSet.getInt("size.ukSize");
                int usSize = resultSet.getInt("size.usSize");

                Size size = new Size(sizeID,euSize,ukSize,usSize);


                sizes.add(size);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return sizes;
    }

    public static List<Inventory> getInventory(String username, String password){

        List<Inventory> inventories = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT * from inventory");

            while(resultSet.next()){
                int inventoryID = resultSet.getInt("inventory.inventoryID");
                int productID = resultSet.getInt("inventory.productID");
                int inStock = resultSet.getInt("inventory.inStock");

                Inventory inventory = new Inventory(inventoryID,productID,inStock);


                inventories.add(inventory);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return inventories;
    }

    public static List<Product> getProduct(String username, String password){
        List<Product>products = new ArrayList<>();
        try {
            properties = new Properties();
            InputStream input = new FileInputStream("res/config.properties");
            properties.load(input);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(
                properties.getProperty("urlString"), username,password)){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM myseconddatabase.product " +
                    " JOIN myseconddatabase.color ON product.colorID = color.colorID " +
                    " JOIN myseconddatabase.manufacturer ON product.manufacturerID " +
                    " JOIN myseconddatabase.size ON product.sizeID = size.sizeID; ");{
            while (rs.next()) {
                Product product = new Product();
                int id = rs.getInt("product.productID");
                String modelName = rs.getString("product.modelName");
                double price = rs.getDouble("Price");
                Size size = new Size(rs.getInt("sizeID"), rs.getInt("euSize"), rs.getInt("ukSize"), rs.getInt("usSize"));
                Manufacturer manufacturer = new Manufacturer(rs.getInt("manufacturerID"), rs.getString("manufacturerName"));
                Color color = new Color(rs.getInt("colorID"), rs.getString("colorName"));
                int categoryID = rs.getInt("product.categoryID");

                product.setProductID(id);
                product.setModelName(modelName);
                product.setPrice(price);
                product.setSizeID(size.getSizeID());
                product.setCategoryID(categoryID);
                product.setManufacturerID(manufacturer.getManufacturerID());
                product.setColorID(color.getColorID());
                products.add(product);
            }
        }
        }
        catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return products;
    }

       /* ArrayList<String> products = new ArrayList<>();
        try {
            properties = new Properties();
            InputStream input = new FileInputStream("Res/config.properties");
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
    }*/
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
            InputStream input = new FileInputStream("Res/config.properties");
            properties.load(input);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try(Connection con = DriverManager.getConnection(
                properties.getProperty("urlString"), username,password)){
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT customerID, customerFirstName,customerLastName,customerAddress, customerEmail, customerPassword,customerPhoneNumber, cityID from myseconddatabase.customers");

            while(resultSet.next()){
                int customerID = resultSet.getInt("customerID");
                String firstName = resultSet.getString("customerFirstName");
                String lastName = resultSet.getString("customerLastName");
                String customerAddress = resultSet.getString("customerAddress");
                String customerEmail = resultSet.getString("customerEmail");
                String customerPassword = resultSet.getString("customerPassword");
                String customerPhoneNumber = resultSet.getString("customerPhoneNumber");
                int cityID = resultSet.getInt("cityID");

                Customer customer = new Customer(customerID, firstName,lastName,customerPhoneNumber, customerEmail,customerPassword, customerAddress,cityID);
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
            InputStream input = new FileInputStream("Res/config.properties");
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
    /*    public class DatabaseManager {
        private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        private final String DB_URL = "jdbc:mysql://hostname:port/database";
        private final String USER = "username";
        private final String PASS = "password";

        public boolean authenticate(String username, String password) {
            boolean isAuthenticated = false;

            try {
                Class.forName(JDBC_DRIVER);

                // Open a connection
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

                // Execute SQL query
                String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    isAuthenticated = true;
                }
                result.close();
                statement.close();
                conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return isAuthenticated;
        }
    }*/
    public static List<Order> getOrders(String username, String password){

        List<Order> orderList = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT * from orders");

            while(resultSet.next()){
                int orderID = resultSet.getInt("orders.orderID");
                int coordinationTableID = resultSet.getInt("orders.coordinationTableID");
                Timestamp orderDate = resultSet.getTimestamp("orders.orderDate");
                Timestamp lastUpdated = resultSet.getTimestamp("orders.lastUpdated");

                orderList.add(new Order(orderID,coordinationTableID,orderDate,lastUpdated));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return orderList;
    }

    public static List<CoordinationTable> getCTable(String username, String password){


        List<CoordinationTable> coordinationTableList = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT * from coordinationtable");

            while(resultSet.next()){
                int coordinationtableID = resultSet.getInt("coordinationtable.coordinationtableID");
                int customerID = resultSet.getInt("coordinationtable.customerID");
                Timestamp created = resultSet.getTimestamp("coordinationtable.created");
                Timestamp lastUpdated = resultSet.getTimestamp("coordinationtable.lastUpdated");

                coordinationTableList.add(new CoordinationTable(coordinationtableID,customerID,created,lastUpdated));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return coordinationTableList;
    }

    public static List<OrderDetail> getOrderDetail(String username, String password){


        List<OrderDetail> orderDetailList = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT * from orderdetail");

            while(resultSet.next()){
                int orderDetailID = resultSet.getInt("orderDetail.orderDetailID");
                int coordinationTableID = resultSet.getInt("orderDetail.coordinationTableID");
                int inventoryID = resultSet.getInt("orderDetail.inventoryID");
                int quantity = resultSet.getInt("orderDetail.quantity");
                Timestamp created = resultSet.getTimestamp("orderDetail.created");
                Timestamp lastUpdated = resultSet.getTimestamp("orderDetail.lastUpdated");

                orderDetailList.add(new OrderDetail(orderDetailID,coordinationTableID,inventoryID,quantity,created,lastUpdated));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return orderDetailList;
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

    public static List<Category> getCategory(String username, String password){


        List<Category> categories = new ArrayList<>();
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
            ResultSet resultSet = statement.executeQuery("SELECT * from Category");

            while(resultSet.next()){
                int categoryID = resultSet.getInt("category.categoryID");
                int subCategoryID = resultSet.getInt("category.subCategoryID");
                int genderCategoryID = resultSet.getInt("category.genderCategoryID");

                Category category = new Category();
                category.setCategoryID(categoryID);
                category.setSubCategoryID(subCategoryID);
                category.setGenderCategoryID(genderCategoryID);
                categories.add(category);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return categories;
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
            cstmt.setInt(2, whoIsLoggedIn.getCustomerID());
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
                cstmt.setInt(2, whoIsLoggedIn.getCustomerID());
                cstmt.setInt(3, id);
                cstmt.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public static void callProcedure(String username, String password, int orderID, int customerID, int productID){

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


            CallableStatement cs = con.prepareCall(sql_string);
            cs.setNull(2, Types.INTEGER);
            cs.setInt(1, customerID);
            cs.setInt(3, productID);
            cs.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}

