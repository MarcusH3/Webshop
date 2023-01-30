package Gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPanel extends JPanel {
    private List<String> products;
    private List<String> sizes;
    private List<String> colors;
    private List<String> distinctListProduct;
    private List<String> distinctListSize;
    private List<String> distinctListColor;
    public ProductPanel(Buttons buttons){
        setBackground(Color.white);
        setPreferredSize(new Dimension(700,763));
        String[] product = new String[250];
        String[] color = new String[250];
        String[] size = new String[250];
        String[] inStock = new String[250];

        products = buttons.getGui().getMain().getProduct();

        distinctListProduct = products.stream().distinct().collect(Collectors.toList());
        int i = 0;
        for(String str : distinctListProduct){
            product[i++] = str;
        }
        JComboBox comboBox1 = new JComboBox(product);
        sizes = buttons.getGui().getMain().getSizeByProduct(comboBox1.getSelectedItem().toString());

        distinctListSize = sizes.stream().distinct().collect(Collectors.toList());
        i = 0;
        for(String str : distinctListSize){
            size[i++] = str;
        }
        JComboBox comboBox3 = new JComboBox(size);
        colors = buttons.getGui().getMain().getColorByProduct(comboBox1.getSelectedItem().toString());

        distinctListColor = colors.stream().distinct().collect(Collectors.toList());
        i = 0;
        for(String str : distinctListColor){
            color[i++] = str;
        }
        JComboBox comboBox2 = new JComboBox(color);

        JComboBox comboBox4 = new JComboBox(inStock);

        add(comboBox1);
        add(comboBox2);
        add(comboBox3);
        add(comboBox4);
    }
}
