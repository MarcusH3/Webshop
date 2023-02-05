package Gui;

import DataBaseConnections.DataBaseConnection;
import Database.*;

import java.util.*;
import java.util.stream.Collectors;

public class MockRapport1 {

    List<Product> products = DataBaseConnection.getProduct("root", "marcusedlund");
    List<Color> colors = DataBaseConnection.getColor("root", "marcusedlund");
    List<Size> sizes = DataBaseConnection.getSize("root", "marcusedlund");
    List<Order> orders = DataBaseConnection.getOrders("root", "marcusedlund");
    List<OrderDetail> orderDetails = DataBaseConnection.getOrderDetail("root", "marcusedlund");
    List<Customer> customers = DataBaseConnection.getCustomer("root", "marcusedlund");
    List<CoordinationTable> coordinationTables = DataBaseConnection.getCTable("root", "marcusedlund");
    List<Inventory> inventories = DataBaseConnection.getInventory("root", "marcusedlund");

    public static void main(String[] args) {

        MockRapport1 mockRapport1 = new MockRapport1();
        mockRapport1.getColor();
        mockRapport1.getSize();
        mockRapport1.getProduct();
        mockRapport1.getCustomer();

    }

    public void getColor(){
        List<List<String>> result = orders.stream()
                .flatMap(order -> coordinationTables.stream()
                        .filter(coordTable -> Objects.equals(coordTable.getCoordinationTableID(), order.getCoordinationTableID()))
                        .flatMap(coordTable -> orderDetails.stream()
                                .filter(orderDetail -> Objects.equals(orderDetail.getCoordinationTableID(), coordTable.getCoordinationTableID()))
                                .flatMap(orderDetail -> inventories.stream()
                                        .filter(inventory -> Objects.equals(inventory.getInventoryID(), orderDetail.getInventoryID()))
                                        .flatMap(inventory -> products.stream()
                                                .filter(product -> Objects.equals(product.getProductID(), inventory.getProductID()))
                                                .flatMap(product -> colors.stream()
                                                        .filter(color -> Objects.equals(color.getColorID(), product.getColorID()))
                                                        .map(color -> Arrays.asList(Integer.toString(order.getOrderID()), color.getColorName())))))))
                .distinct().collect(Collectors.toList());

    }

    public void getSize(){

        List<List<String>> result = orders.stream()
                .flatMap(order -> coordinationTables.stream()
                        .filter(coordTable -> Objects.equals(coordTable.getCoordinationTableID(), order.getCoordinationTableID()))
                        .flatMap(coordTable -> orderDetails.stream()
                                .filter(orderDetail -> Objects.equals(orderDetail.getCoordinationTableID(), coordTable.getCoordinationTableID()))
                                .flatMap(orderDetail -> inventories.stream()
                                        .filter(inventory -> Objects.equals(inventory.getInventoryID(), orderDetail.getInventoryID()))
                                        .flatMap(inventory -> products.stream()
                                                        .filter(product -> Objects.equals(product.getProductID(), inventory.getProductID()))
                                                        .flatMap(product -> sizes.stream()
                                                                .filter(size -> Objects.equals(size.getSizeID(), product.getSizeID()))
                                                                .map(size -> Arrays.asList(Integer.toString(order.getOrderID()), Double.toString(size.getEuSize())))
                                                        ))))).distinct().collect(Collectors.toList());

        System.out.println("Hej");
    }
    public void getProduct(){

        List<List<String>>result = orders.stream()
                .flatMap(order -> coordinationTables.stream()
                        .filter(coordTable -> Objects.equals(coordTable.getCoordinationTableID(), order.getCoordinationTableID()))
                        .flatMap(coordTable -> orderDetails.stream()
                                .filter(orderDetail -> Objects.equals(orderDetail.getCoordinationTableID(), coordTable.getCoordinationTableID()))
                                .flatMap(orderDetail -> inventories.stream()
                                        .filter(inventory -> Objects.equals(inventory.getInventoryID(), orderDetail.getInventoryID()))
                                        .flatMap(inventory -> products.stream()
                                                .filter(product -> Objects.equals(product.getProductID(), inventory.getProductID()))
                                                .map(product -> Arrays.asList(Integer.toString(order.getOrderID()), product.getModelName()))))))
                .distinct().collect(Collectors.toList());


        System.out.println("Hej");
    }

    public void getCustomer(){



            List<String> customerNames = orders.stream()
                    .flatMap(order -> coordinationTables.stream()
                            .filter(coordinationTable -> order.getCoordinationTableID() == coordinationTable.getCoordinationTableID())
                            .flatMap(coordinationTable -> orderDetails.stream()
                                    .filter(orderDetail -> coordinationTable.getCoordinationTableID() == orderDetail.getCoordinationTableID())
                                    .flatMap(orderDetail -> customers.stream()
                                            .filter(customer -> coordinationTable.getCustomerID() == customer.getCustomerID())
                                            .map(customer -> customer.getFullName())
                                    ))).collect(Collectors.toList());



        System.out.println("hej");
    }

}
