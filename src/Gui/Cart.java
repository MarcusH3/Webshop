package Gui;

import Database.Product;
import Database.Size;
import Utilities.State;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Cart extends JPanel{

    private final List<Product> products;
    private final List<Database.Color> colors;
    private final List<Size> sizes;
    private final List<Integer> productID;
    private final List <String> modelNames;
    private final List<String> colorNames;
    private final List<Double> euSizes;
    private final JButton proceedButton;
    private final JButton discardButton;
    private final JPanel topPanel;
    private final JPanel centerPanel;
    private final JPanel bottomPanel;
    private final Font font = new Font("Arial", Font.PLAIN, 20);

    public Cart(Buttons buttons){


        setPreferredSize(new Dimension(700, 763));
        setLayout(new BorderLayout());

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(700,100));
        topPanel.setMaximumSize(new Dimension(700,100));
        topPanel.setBackground(Color.white);

        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(700,100));
        bottomPanel.setMaximumSize(new Dimension(700,100));
        bottomPanel.setBackground(Color.white);

        proceedButton = buttons.getProceedButton();
        discardButton = buttons.getDiscardButton();
        bottomPanel.add(proceedButton);
        bottomPanel.add(discardButton);

        proceedButton.addActionListener(e->{
            System.out.println("ADD THIS TO STORED PROCEDURE");
        });
        discardButton.addActionListener(e->{
            buttons.getProductID().clear();
            buttons.setState(State.INTRO);
            buttons.getGui().updateGui();
        });
        centerPanel = new JPanel();
        centerPanel.setBackground(Color.white);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        products = buttons.getGui().getMain().getProduct();
        colors = buttons.getGui().getMain().getColor();
        sizes = buttons.getGui().getMain().getSize();

        productID = buttons.getProductID();

        setBackground(Color.white);
        setPreferredSize(new Dimension(700,763));

        modelNames = getProducts(productID);
        colorNames = getColorByID(productID);
        euSizes = getSizeByID(productID);

        for(String string : getProductMessage()){
            JLabel jLabel = new JLabel(string);
            jLabel.setFont(font);
            centerPanel.add(jLabel);
        }



        add(topPanel,BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.WEST);
    }

    public List<String> getProductMessage(){

        List<String> listToAppend = new ArrayList<>();

        for(int i = 0; i < modelNames.size(); i++){
            listToAppend.add("You want to buy : " + modelNames.get(i) + " of size " + euSizes.get(i)
                    + " and color "+ colorNames.get(i) + System.getProperty("line.separator"));
        }
        return listToAppend;
    }
    public List<String> getProducts(List<Integer> integers){

        List<String> productToCheckOut = new ArrayList<>();

        integers.stream().forEach(integer -> {
            String temp = products.stream()
                    .filter(p -> p.getProductID() == integer)
                    .map(Product::getModelName)
                    .findFirst()
                    .orElse(null);
            productToCheckOut.add(temp);
        });
        return productToCheckOut;
    }
    public List<String> getColorByID(List<Integer> integers){

        List<Integer> colorID = new ArrayList<>();
        List<String> colorNames = new ArrayList<>();

        integers.stream().forEach(integer -> {
            Integer temp = products.stream()
                    .filter(p -> p.getProductID() == integer)
                    .map(Product::getColorID).findFirst().orElse(null);
                    colorID.add(temp);
        });

        colorID.stream().forEach(color -> {
            String temp = colors.stream().filter(c-> c.getColorID()==color.intValue())
                    .map(Database.Color::getColorName).findFirst().orElse(null);
                    colorNames.add(temp);
        });
        return colorNames;
    }
    public List<Double> getSizeByID(List<Integer> integers){

        List<Integer> sizeID = new ArrayList<>();
        List<Double> euSize = new ArrayList<>();

        integers.stream().forEach(integer -> {
            Integer temp = products.stream()
                    .filter(p -> p.getProductID() == integer)
                    .map(Product::getSizeID).findFirst().orElse(null);
            sizeID.add(temp);
        });

        sizeID.stream().forEach(size -> {
            Double temp = sizes.stream().filter(s-> s.getSizeID()==size.intValue())
                    .map(Size::getEuSize).findFirst().orElse(null);
            euSize.add(temp);
        });
        return euSize;
    }
}