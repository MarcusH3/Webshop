package Gui;

import Database.*;
import Utilities.StringListOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Listings extends JPanel {
    private final List<Product> products;
    private final List<Database.Color> colors;
    private final List<Size> sizes;
    private final List<Order> orders;
    private final List<OrderDetail> orderDetails;
    private final List<Customer> customers;
    private final List<CoordinationTable> coordinationTables;
    private final List<Inventory> inventories;
    private final List<City> cities;
    private final JPanel centerListing1;
    private final JPanel centerListing2;
    private final JPanel centerListing3;
    private final JPanel centerListing4;
    private final JPanel centerListing5;
    private final JPanel centerListing6;

    JComboBox comboBox;
    JComboBox comboBox1;
    JComboBox comboBox2;

    public Listings(Buttons buttons) {
        products = buttons.getGui().getMain().getProduct();
        colors = buttons.getGui().getMain().getColor();
        sizes = buttons.getGui().getMain().getSize();
        orders = buttons.getGui().getMain().getOrders();
        orderDetails = buttons.getGui().getMain().getOrderDetail();
        customers = buttons.getGui().getMain().getCustomer();
        coordinationTables = buttons.getGui().getMain().getCTable();
        inventories = buttons.getGui().getMain().getInventory();
        cities = buttons.getGui().getMain().getCity();

        setBackground(Color.white);
        setPreferredSize(new Dimension(700,763));
        setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setPreferredSize(new Dimension(700, 100));
        north.setBackground(Color.white);

        JPanel west = new JPanel();
        west.setPreferredSize(new Dimension(150,563));
        west.setBackground(Color.white);

        JPanel center = new JPanel();
        center.setPreferredSize(new Dimension(450,563));
        center.setBackground(Color.white);

        centerListing1 = new JPanel();
        centerListing1.setPreferredSize(new Dimension(500,563));
        centerListing1.setBackground(Color.white);
        centerListing1.setLayout(new BoxLayout(centerListing1, BoxLayout.Y_AXIS));

        centerListing2 = new JPanel();
        centerListing2.setPreferredSize(new Dimension(500,563));
        centerListing2.setBackground(Color.white);
        centerListing2.setLayout(new BoxLayout(centerListing2, BoxLayout.Y_AXIS));

        centerListing3 = new JPanel();
        centerListing3.setPreferredSize(new Dimension(500,563));
        centerListing3.setBackground(Color.white);
        centerListing3.setLayout(new BoxLayout(centerListing3, BoxLayout.Y_AXIS));

        centerListing4 = new JPanel();
        centerListing4.setPreferredSize(new Dimension(500,563));
        centerListing4.setBackground(Color.white);
        centerListing4.setLayout(new BoxLayout(centerListing4, BoxLayout.Y_AXIS));

        centerListing5 = new JPanel();
        centerListing5.setPreferredSize(new Dimension(500,563));
        centerListing5.setBackground(Color.white);
        centerListing5.setLayout(new BoxLayout(centerListing5, BoxLayout.Y_AXIS));

        centerListing6 = new JPanel();
        centerListing6.setPreferredSize(new Dimension(500,563));
        centerListing6.setBackground(Color.white);
        centerListing6.setLayout(new BoxLayout(centerListing6, BoxLayout.Y_AXIS));

        center.add(centerListing1);
        center.add(centerListing2);
        center.add(centerListing3);
        center.add(centerListing4);
        center.add(centerListing5);
        center.add(centerListing6);

        JPanel east = new JPanel();
        east.setPreferredSize(new Dimension(100,563));
        east.setBackground(Color.white);

        JPanel south = new JPanel();
        south.setPreferredSize(new Dimension(700, 100));
        south.setBackground(Color.white);

        JButton modelButton = buttons.getModelButton();
        JButton colorButton = buttons.getColorButton();
        JButton sizeButton = buttons.getSizeButton();
        JButton cityButton = buttons.getCityButton();
        JButton customerOrders = buttons.getCustomerOrders();
        JButton customerSpending = buttons.getCustomerSpending();

        modelButton.setMinimumSize(new Dimension(100,70));
        colorButton.setMinimumSize(new Dimension(100,70));
        sizeButton.setMinimumSize(new Dimension(100,70));


        modelButton.addActionListener(e->{
            comboBox.setVisible(true);
            comboBox1.setVisible(false);
            comboBox2.setVisible(false);

            centerListing1.setVisible(false);
            centerListing2.setVisible(false);
            centerListing3.setVisible(false);
            centerListing4.setVisible(false);
            centerListing6.setVisible(false);
            centerListing5.setVisible(false);

        });

        colorButton.addActionListener(e->{
            comboBox.setVisible(false);
            comboBox1.setVisible(true);
            comboBox2.setVisible(false);

            centerListing1.setVisible(false);
            centerListing2.setVisible(false);
            centerListing3.setVisible(false);
            centerListing4.setVisible(false);
            centerListing6.setVisible(false);
            centerListing5.setVisible(false);
        });

        sizeButton.addActionListener(e->{
            comboBox.setVisible(false);
            comboBox1.setVisible(false);
            comboBox2.setVisible(true);

            centerListing1.setVisible(false);
            centerListing2.setVisible(false);
            centerListing3.setVisible(false);
            centerListing4.setVisible(false);
            centerListing6.setVisible(false);
            centerListing5.setVisible(false);
        });

        customerSpending.addActionListener(e->{
            centerListing5.removeAll();
            for (String item : getCustomersTotalSpent()){
                JLabel label2 = new JLabel(item);
                centerListing5.add(label2);
                centerListing1.setVisible(false);
                centerListing2.setVisible(false);
                centerListing3.setVisible(false);
                centerListing4.setVisible(false);
                centerListing6.setVisible(false);
                centerListing5.setVisible(true);

                comboBox.setVisible(false);
                comboBox1.setVisible(false);
                comboBox2.setVisible(false);


            }
            centerListing5.repaint();

            centerListing6.repaint();

        });

        customerOrders.addActionListener(e-> {
            centerListing6.removeAll();
            for (String item : getNumberOfOrdersByCustomer()) {
                JLabel label2 = new JLabel(item);
                centerListing6.add(label2);
                centerListing1.setVisible(false);
                centerListing2.setVisible(false);
                centerListing3.setVisible(false);
                centerListing4.setVisible(false);
                centerListing5.setVisible(false);
                centerListing6.setVisible(true);

                comboBox.setVisible(false);
                comboBox1.setVisible(false);
                comboBox2.setVisible(false);


            }
        });

        cityButton.addActionListener(e->{
            centerListing4.removeAll();
            for (String item : byCity()){
                JLabel label2 = new JLabel(item);
                centerListing4.add(label2);
                centerListing1.setVisible(false);
                centerListing2.setVisible(false);
                centerListing3.setVisible(false);
                centerListing4.setVisible(true);
                centerListing5.setVisible(false);
                centerListing6.setVisible(false);

                comboBox.setVisible(false);
                comboBox1.setVisible(false);
                comboBox2.setVisible(false);


            }
            centerListing4.repaint();
        });

        comboBox = new JComboBox<>();
        comboBox.setBackground(Color.white);
        comboBox.addItem("Select Model");
        products.stream().map(Product::getModelName).distinct().forEach(comboBox::addItem);

        comboBox1 = new JComboBox<>();
        comboBox1.setBackground(Color.white);
        comboBox1.addItem("Select Color");
        colors.stream().map(Database.Color::getColorName).distinct().forEach(comboBox1::addItem);

        comboBox2 = new JComboBox<>();
        comboBox2.setBackground(Color.white);
        comboBox2.addItem("Select Size");
        sizes.stream().map(Size::getEuSize).distinct().forEach(comboBox2::addItem);


        north.add(comboBox);
        north.add(comboBox1);
        north.add(comboBox2);

        comboBox.setVisible(false);
        comboBox1.setVisible(false);
        comboBox2.setVisible(false);



        comboBox.addActionListener(e->{
centerListing1.removeAll();
            if(comboBox.getSelectedItem() != "Select Model"){
                if(getNameByProduct(comboBox.getSelectedItem().toString()).size() == 0){
                    centerListing1.removeAll();
                }

                for (String item : getNameByProduct(comboBox.getSelectedItem().toString())) {
                        JLabel label2 = new JLabel(item);
                        centerListing1.add(label2);
                        centerListing1.setVisible(true);
                        centerListing2.setVisible(false);
                        centerListing3.setVisible(false);

                }
                }
        });

        comboBox1.addActionListener(e->{
            centerListing2.removeAll();
            if(comboBox1.getSelectedItem() != "Select Color"){
                centerListing2.removeAll();
                if(getNameByColor(comboBox1.getSelectedItem().toString()).size() == 0){
                    centerListing2.removeAll();
                    centerListing2.repaint();
                }

                for (String item : getNameByColor(comboBox1.getSelectedItem().toString())) {
                    JLabel label2 = new JLabel(item);
                    centerListing2.add(label2);
                    centerListing2.setVisible(true);
                    centerListing1.setVisible(false);
                    centerListing3.setVisible(false);

                }
            }
        });

        comboBox2.addActionListener(e->{
            if(comboBox2.getSelectedItem() != "Select Size"){
                centerListing3.removeAll();
                if(getNameBySize(comboBox2.getSelectedItem().toString()).size() == 0){
                    centerListing3.removeAll();
                    centerListing3.repaint();
                }

                for (String item : getNameBySize(comboBox2.getSelectedItem().toString())) {
                    JLabel label2 = new JLabel(item);
                    centerListing3.add(label2);
                    centerListing3.setVisible(true);
                    centerListing1.setVisible(false);
                    centerListing2.setVisible(false);

                }
            }
        });


        west.add(modelButton);
        west.add(colorButton);
        west.add(sizeButton);
        west.add(cityButton);
        west.add(customerOrders);
        west.add(customerSpending);

        add(north, BorderLayout.NORTH);
        add(west, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
        add(east, BorderLayout.EAST);
        add(south, BorderLayout.SOUTH);
    }

    public List<String> getNameByColor(String colorName){
        List<String> listToReturn = new ArrayList<>();
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
                                                        .map(color -> Arrays.asList(Integer.toString(coordTable.getCustomerID()), color.getColorName())))))))
                .distinct().collect(Collectors.toList());

        for(List<String> list : result){
            int temp = Integer.parseInt(list.get(0));
            if(list.stream().anyMatch(l->l.equals(colorName))) {
                listToReturn.add(getCustomer(temp) + " " + getAddress(temp));
            }
        }
        return listToReturn;

    }

    public List<String> getNameBySize(String sizeString){

        List<String> listToReturn = new ArrayList<>();
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

            for(List<String> list : result){
                int temp = Integer.parseInt(list.get(0));
                if(list.stream().anyMatch(l->l.equals(sizeString))) {
                    listToReturn.add(getCustomer(temp) + " " + getAddress(temp));
                }
            }
            return listToReturn;
    }
    public List<String> getNameByProduct(String modelName){
        List<String> listToReturn = new ArrayList<>();
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

        for(List<String> list : result){
            int temp = Integer.parseInt(list.get(0));
            if(list.stream().anyMatch(l->l.equals(modelName))) {
                listToReturn.add(getCustomer(temp) + " " + getAddress(temp));
            }
        }
        return listToReturn;

    }

    public String getCustomer(int id){

        String customerFullName =
                customers.stream()
                        .filter(c -> c.getCustomerID() == coordinationTables.stream()
                                .filter(ct -> ct.getCoordinationTableID() == orders.stream()
                                        .filter(o -> o.getOrderID() == id)
                                        .findFirst()
                                        .get()
                                        .getCoordinationTableID())
                                .findFirst()
                                .get()
                                .getCustomerID())
                        .findFirst()
                        .get()
                        .getFullName();

        return customerFullName;
    }
    public String getAddress(int id){
        return customers.stream().filter(c->c.getCustomerID() == id).map(Customer::getCustomerAddress).findAny().orElse(null);
    }

    public List<String> byCity(){
        List<Double> price = new ArrayList<>();
        List<Integer> id = new ArrayList<>();
        List<String> cityName = new ArrayList<>();
        List<String[]> cityAndPrice = new ArrayList<>();
        List<String> listToReturn = new ArrayList<>();

        List<Object> result = products.stream()
                .filter(p -> inventories.stream()
                        .anyMatch(i -> orderDetails.stream()
                                .anyMatch(od -> coordinationTables.stream()
                                        .anyMatch(c -> orders.stream()
                                                .anyMatch(o -> o.getCoordinationTableID() == c.getCoordinationTableID()
                                                        && c.getCoordinationTableID() == od.getCoordinationTableID()
                                                        && od.getInventoryID() == i.getInventoryID()
                                                        && p.getProductID() == i.getInventoryID())))))
                .map(p -> Arrays.asList(p.getProductID(), p.getPrice())).distinct()
                .collect(Collectors.toList());



for (Object obj : result){
    String temp = obj.toString();
    String[] arr = temp.split(",");
    String resultString = arr[1];
    resultString = resultString.replace("]", "");
    Double number = Double.parseDouble(resultString.trim()); // number will be 699
    price.add(number);
}
        for (Object obj : result){
            String temp = obj.toString();
            String[] arr = temp.split(",");
            String resultString = arr[0];
            resultString = resultString.replace("[", "");
            Integer number = Integer.parseInt(resultString.trim()); // number will be 699
            id.add(number);
        }
        for (Integer integer : id){
            String name = cities.stream().filter(c-> customers.stream()
                            .anyMatch(cu-> coordinationTables.stream()
                                    .anyMatch(co->orderDetails.stream()
                                            .anyMatch(o->c.getCityID() == cu.getCityID()
                                                            && co.getCustomerID() == cu.getCustomerID()
                                                            && co.getCoordinationTableID() == o.getCoordinationTableID()
                                                            && integer == o.getInventoryID()))))
                    .map(City::getCityName).findFirst().orElse(null);
            cityName.add(name);
        }

        for(int i = 0; i < cityName.size(); i++){
            String[] temp = {cityName.get(i), price.get(i).toString()};
            cityAndPrice.add(temp);
        }

        StringListOperation listOperation = list -> {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i)[0].equals(list.get(j)[0])) {
                        double temp1 = Double.valueOf(list.get(i)[1]);
                        double temp2 = Double.valueOf(list.get(j)[1]);
                        temp1 += temp2;
                        list.get(i)[1] = Double.toString(temp1);
                        list.remove(j);
                    }
                }
            }
        };

        listOperation.manipulateList(cityAndPrice);


        Collections.sort(cityAndPrice, Comparator.comparingDouble(arr -> Double.parseDouble(arr[1])));
        Collections.reverse(cityAndPrice);

        for(String[] str : cityAndPrice) {

                String strToJoin = String.join(" ", str);
            listToReturn.add(strToJoin);
        }
        return listToReturn;
    }
    public List<String> getCustomersTotalSpent() {
        List<String[]> listToManipulate = new ArrayList<>();
        List<String> customersTotalSpent = new ArrayList<>();
        List<String> listToReturn = new ArrayList<>();
        List<Integer> coordinationTableIDs = orderDetails.stream().map(OrderDetail::getCoordinationTableID).collect(Collectors.toList());        Set<Integer> uniqueCoordinationTableIDs = new HashSet<>(coordinationTableIDs);
        for (Integer coordinationTableID : uniqueCoordinationTableIDs) {
            double totalSpent = 0;
            for (int i = 0; i < orderDetails.size(); i++) {
                if (orderDetails.get(i).getCoordinationTableID() == coordinationTableID) {
                    int finalI = i;
                    double price = products.stream().filter(p -> p.getProductID() == inventories.get(finalI).getProductID()).findFirst().get().getPrice();
                    totalSpent += price * orderDetails.get(i).getQuantity();

                    int customerID = coordinationTables.stream().filter(c -> c.getCoordinationTableID() == coordinationTableID).findFirst().get().getCustomerID();
                    customersTotalSpent.add(customers.stream().filter(c -> c.getCustomerID() == customerID).findFirst().get().getCustomerFirstName() + " "
                            + customers.stream().filter(c -> c.getCustomerID() == customerID).
                            findFirst().get().getCustomerLastName() + " - " + totalSpent);
                }
            }

        }

        for(String str : customersTotalSpent){
            String[] parts = str.split(" - ");
            listToManipulate.add(parts);
        }


        StringListOperation listOperation = list -> {
            while(list.stream().anyMatch(arr -> list.stream().anyMatch(arr2 -> arr[0].equals(arr2[0]) && arr != arr2))) {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(i)[0].equals(list.get(j)[0])) {
                            double temp1 = Double.valueOf(list.get(i)[1]);
                            double temp2 = Double.valueOf(list.get(j)[1]);
                            temp1 += temp2;
                            list.get(i)[1] = Double.toString(temp1);
                            list.remove(j);
                        }
                    }
                }
            }
        };
        listOperation.manipulateList(listToManipulate);

        Collections.sort(listToManipulate, Comparator.comparingDouble(arr -> Double.parseDouble(arr[1])));
        Collections.reverse(listToManipulate);

        for(String[] str : listToManipulate) {

            String strToJoin = String.join(" ", str);
            listToReturn.add(strToJoin);
        }


        return listToReturn;
    }
    public List<String> getNumberOfOrdersByCustomer(){
        List<String[]> listToManipulate = new ArrayList<>();
        List<String> listToReturn = new ArrayList<>();
        List<String> customersOrder = new ArrayList<>();
        for(CoordinationTable coordinationTable: coordinationTables){
            int customerID = coordinationTable.getCustomerID();
            int orderCount = 0;
            for(Order order: orders){
                if(order.getCoordinationTableID() == customerID){
                    orderCount++;
                }
            }
            Optional<Customer> customer = customers.stream().filter(c -> c.getCustomerID() == customerID).findFirst();
            if(customer.isPresent()){
                customersOrder.add(customer.get().getCustomerFirstName() + " " + customer.get().getCustomerLastName() + "-" + orderCount);
            }
        }

        for(String str : customersOrder){
            String[] parts = str.split("-");
            listToManipulate.add(parts);
        }


        StringListOperation listOperation = list -> {
            while(list.stream().anyMatch(arr -> list.stream().anyMatch(arr2 -> arr[0].equals(arr2[0]) && arr != arr2))) {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(i)[0].equals(list.get(j)[0])) {
                            int temp1 = Integer.valueOf(list.get(i)[1]);
                            int temp2 = Integer.valueOf(list.get(j)[1]);
                            temp1 += temp2;
                            list.get(i)[1] = Integer.toString(temp1);
                            list.remove(j);
                        }
                    }
                }
            }
        };
        listOperation.manipulateList(listToManipulate);

        Collections.sort(listToManipulate, Comparator.comparingDouble(arr -> Double.parseDouble(arr[1])));
        Collections.reverse(listToManipulate);

        for(String[] str : listToManipulate) {

            String strToJoin = String.join(" ", str);
            listToReturn.add(strToJoin);
        }


        return listToReturn;
    }

}



