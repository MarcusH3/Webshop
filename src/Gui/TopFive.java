package Gui;

import Database.*;
import Utilities.IntOperation;
import Utilities.ListManipulator;
import Utilities.IntegerListOperation;
import Utilities.StringListOperation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TopFive extends JPanel {

    private final List<Product> products;
    private final List<Order> orders;
    private final List<CoordinationTable> coordinationTables;
    private final List<OrderDetail> orderDetails;
    private final List<Inventory> inventories;

    private final List<Integer> inventoryIDTemp;
    private final List<Integer> quantity;
    private final List<String> modelName;
    private final List<int[]> unitsByID;
    private final  List<String> topFive;

    public TopFive(Buttons buttons) {
    products = buttons.getGui().getMain().getProduct();
    orders =  buttons.getGui().getMain().getOrders();
    coordinationTables = buttons.getGui().getMain().getCTable();
    orderDetails = buttons.getGui().getMain().getOrderDetail();
    inventories = buttons.getGui().getMain().getInventory();

    quantity = getQuantity();
    inventoryIDTemp = getInventoryIDTemp();
    unitsByID = getUnitsByID();
    modelName = getModelName();
    topFive =  getTopFive();

        setPreferredSize(new Dimension(700,763));
        for(String string : topFive){
            add(new JLabel(string));
        }

    }
    public List<String>  getTopFive(){
        List<String[]> tempTopFive = new ArrayList<>();
        List<String> tempStringList = new ArrayList<>();
        for (int i = 0; i < modelName.size(); i++) {

           tempTopFive.add(new String[]{modelName.get(i),Integer.toString(unitsByID.get(i)[1])});
        }

        StringListOperation stringListOperation = list -> {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i)[0].equals(list.get(j)[0])) {

                        int firstString = Integer.parseInt(list.get(i)[1]);
                        int secondString = Integer.parseInt(list.get(j)[1]);
                        int result = firstString + secondString;

                        list.get(i)[1] = Integer.toString(result);
                        list.remove(j);
                    }
                }
            }
        };
        stringListOperation.manipulateList(tempTopFive);
        for(int i = 0; i<tempTopFive.size(); i++){
            tempStringList.add(tempTopFive.get(i)[0] + " " + tempTopFive.get(i)[1]);
        }
        return tempStringList;
    }

    public List<Integer> getInventoryIDTemp() {
        return orderDetails.stream().filter(o-> quantity.stream().
                anyMatch(q -> q == o.getQuantity())).map(OrderDetail::getInventoryID).collect(Collectors.toList());
    }

    public List<Integer> getQuantity() {
        return orderDetails.stream().filter(o->o.getQuantity()>0).map(OrderDetail::getQuantity).collect(Collectors.toList());
    }

    public List<int[]> getUnitsByID(){

        List<int[]> intArray = new ArrayList<>();
        for(int i = 0; i<quantity.size(); i++){
            IntOperation operation = (number1, number2) -> new int[]{number1, number2};
            int[] result = operation.apply(inventoryIDTemp.get(i), quantity.get(i));
            intArray.add(result);
        }
        return intArray;
    }
    public List<String> getModelName() {

        List<Integer> integerList = new ArrayList<>();

        IntegerListOperation listOperation = list -> {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i)[0] == list.get(j)[0]) {
                        list.get(i)[1] += list.get(j)[1];
                        list.remove(j);
                    }
                }
            }
        };

        listOperation.manipulateList(unitsByID);

        ListManipulator listManipulator = list -> {
            for (int i = 0; i < list.size(); i++) {
                integerList.add(list.get(i)[0]);
            }
        };
        listManipulator.apply(unitsByID);

        return  integerList.stream()
                .map(i -> products.stream().filter(p -> p.getProductID() == i.intValue()).findFirst())
                .filter(Optional::isPresent).map(Optional::get).map(Product::getModelName).collect(Collectors.toList());

    }
}
