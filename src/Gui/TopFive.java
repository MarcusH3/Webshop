package Gui;

import Database.*;
import Utilities.SumLambda;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopFive extends JPanel {

    private final List<Product> products;
    private final List<Order> orders;
    private final List<CoordinationTable> coordinationTables;
    private final List<OrderDetail> orderDetails;
    private final List<Inventory> inventories;

    public TopFive(Buttons buttons) {
    products = buttons.getGui().getMain().getProduct();
    orders =  buttons.getGui().getMain().getOrders();
    coordinationTables = buttons.getGui().getMain().getCTable();
    orderDetails = buttons.getGui().getMain().getOrderDetail();
    inventories = buttons.getGui().getMain().getInventory();

    getQuantitiesSold();

        setPreferredSize(new Dimension(700,763));

    }
    public void getQuantitiesSold(){
        List<String> modelName;
        List<Integer> inventoryIDTemp;
        List<Integer> quantity;

        inventoryIDTemp = orderDetails.stream().filter(o->o.getQuantity()>0).map(OrderDetail::getQuantity).collect(Collectors.toList());

        quantity = orderDetails.stream().filter(o-> inventoryIDTemp.stream().
                anyMatch(i -> i.intValue() == o.getInventoryID())).map(OrderDetail::getQuantity).collect(Collectors.toList());

/*



        modelName = products.stream()
                .filter(p-> inventoryIDTemp.stream().anyMatch(i -> i.intValue() == p.getProductID()))
                .map(Product::getModelName).distinct()
                .collect(Collectors.toList());


        modelName =  products.stream().filter(p-> inventories.stream().anyMatch(i->i.getProductID() == p.getProductID()
        && orderDetails.stream().anyMatch(o->o.getInventoryID() == i.getInventoryID()
                && coordinationTables.stream().anyMatch(c->c.getCoordinationTableID() == o.getCoordinationTableID()
        && orders.stream().anyMatch(orders->orders.getCoordinationTableID() == c.getCoordinationTableID())))))
                .map(Product::getModelName).distinct().collect(Collectors.toList());*/




        System.out.println("hej;");
    }


}
