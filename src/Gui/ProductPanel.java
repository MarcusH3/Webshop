package Gui;

import Database.*;
import Utilities.PromptText;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ProductPanel extends JPanel{
    private JComboBox comboBox;
    private JComboBox comboBox0;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private Buttons buttons;
    private boolean removing = false;
    private List<GenderCategory> genderCategories;
    private List<SubCategory> subCategories;
    private List<Category> categories;
    private List<Product> products;
    private List<String> genderStringList;
    private List<Database.Color> colors;
    private List<Size> sizes;

    public ProductPanel(Buttons buttons) {
        this.buttons = buttons;
        setBackground(Color.white);
        setPreferredSize(new Dimension(700, 763));
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(700,100));
        topPanel.setMaximumSize(new Dimension(700,100));
        topPanel.setBackground(Color.white);

     /*   JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(100,563));
        leftPanel.setMaximumSize(new Dimension(100,563));
        leftPanel.setBackground(Color.red);*/

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(100,563));
        rightPanel.setMaximumSize(new Dimension(100,563));
        rightPanel.setBackground(Color.white);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(700,100));
        bottomPanel.setMaximumSize(new Dimension(700,100));
        bottomPanel.setBackground(Color.white);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.white);

        add(topPanel,BorderLayout.NORTH);
        add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.WEST);

        comboBox = new JComboBox<String>();
        comboBox0 = new JComboBox<String>();
        comboBox1 = new JComboBox<String>();
        comboBox2 = new JComboBox<String>();
        comboBox3 = new JComboBox<String>();

        comboBox.setBackground(Color.white);
        comboBox0.setBackground(Color.white);
        comboBox1.setBackground(Color.white);
        comboBox2.setBackground(Color.white);
        comboBox3.setBackground(Color.white);

        genderCategories = buttons.getGui().getMain().getGender();
        categories = buttons.getGui().getMain().getCategories();
        subCategories = buttons.getGui().getMain().getSubCategory();
        products = buttons.getGui().getMain().getProduct();
        colors = buttons.getGui().getMain().getColor();
        sizes = buttons.getGui().getMain().getSize();


        genderStringList = genderCategories.stream().map(genderCategory -> genderCategory.getGenderCategoryName()).collect(Collectors.toList());

        populateComboBox(comboBox, "Select Gender",()-> genderStringList);

        comboBox.addActionListener(e->{
            if(removing)return;
            if(comboBox.getSelectedItem() != "Select Gender"){
                populateComboBox(comboBox0, "Select Category", ()-> getSubCategoryNames(comboBox.getSelectedItem().toString()));
                //populateComboBox(comboBox0, "Select Category", ()-> buttons.getGui().getMain().getCategoryByGender(comboBox.getSelectedItem().toString()));
                comboBox0.setVisible(true);
                comboBox1.setVisible(false);
                comboBox2.setVisible(false);
                comboBox3.setVisible(false);
            }
        });
        comboBox0.addActionListener(e->{
            if(removing)return;
            if(comboBox0.getSelectedItem() != "Select Category"){

                populateComboBox(comboBox1, "Select Product", ()-> getProductName(comboBox0.getSelectedItem().toString()));
                comboBox1.setVisible(true);
                comboBox2.setVisible(false);
                comboBox3.setVisible(false);
                comboBox1.setSelectedItem("Select Product");
            }
        });
        comboBox1.addActionListener(e->{
            if(removing)return;
            if(comboBox1.getSelectedItem() != "Select Product"){
                populateComboBox(comboBox2, "Select Color", ()-> getColor(comboBox1.getSelectedItem().toString()));
                comboBox2.setVisible(true);
                comboBox3.setVisible(false);
            }
        });
        comboBox2.addActionListener(e->{
            if(removing)return;
            if(comboBox2.getSelectedItem() != "Select Color"){
                populateComboBox(comboBox3, "Select Size", ()-> getSize(comboBox1.getSelectedItem().toString()));
                comboBox3.setVisible(true);
            }
        });

/*        comboBox3.addActionListener(e->{
            if(removing)return;
            if(comboBox3.getSelectedItem() != "Select Size"){
                new JLabel()

            }
        });*/

        centerPanel.add(comboBox);
        centerPanel.add(comboBox0);
        centerPanel.add(comboBox1);
        centerPanel.add(comboBox2);
        centerPanel.add(comboBox3);

        comboBox0.setVisible(false);
        comboBox1.setVisible(false);
        comboBox2.setVisible(false);
        comboBox3.setVisible(false);

    }

    public boolean isNotPromptText(JComboBox<String> comboBox, String promptText){

        if(comboBox.getSelectedItem() == null){
            return false;
        }
        if (!comboBox.getSelectedItem().equals(promptText)) {
            return true;
        }
        return false;
    }

    public void removeStringFromComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
    }

    public JComboBox<String> populateComboBox(JComboBox<String> comboBox, String promptText, Supplier<List<String>> entitySupplier) {
        removing = true;
        comboBox.removeAllItems();
        removing = false;
        List<String> entity = entitySupplier.get();
        comboBox.addItem(promptText);
        entity.stream().distinct().forEach(comboBox::addItem);

        return comboBox;
    }

    public List<String> getSubCategoryNames(String genderCategoryName) {
        return categories.stream()
                .filter(category -> genderCategories.stream()
                        .anyMatch(genderCategory -> genderCategory.getGenderCategoryName().equals(genderCategoryName)
                                && genderCategory.getGenderCategoryID() == category.getGenderCategoryID()))
                .map(category -> subCategories.stream()
                        .filter(subCategory -> subCategory.getSubCategoryID() == category.getSubCategoryID())
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .map(subCategory -> subCategory.getSubCategoryName())
                .collect(Collectors.toList());
    }

    public List<String> getProductName(String subCategoryName) {

    int categoryID = subCategories.stream()
            .filter(sc -> sc.getSubCategoryName().equals(subCategoryName))
            .map(sc -> categories.stream().filter(c -> c.getSubCategoryID() == sc.getSubCategoryID()).findFirst().orElse(null))
            .map(Category::getCategoryID)
            .findFirst()
            .orElse(null);


        List<String> stringList =
                products.stream()
                        .filter(p -> p.getCategoryID() == categoryID)
                        .map(Product::getModelName).distinct()
                        .collect(Collectors.toList());

        return stringList;
    }
    public List<String> getColor(String modelName){
        return products.stream()
                .filter(p -> p.getModelName().equals(modelName))
                .map(p -> colors.stream().filter(c -> c.getColorID() == p.getColorID()).findFirst().orElse(null))
                .map(Database.Color::getColorName)
                .collect(Collectors.toList());
    }

    public List<String> getSize(String modelName){
        return products.stream()
                .filter(p -> p.getModelName().equals(modelName))
                .map(p -> sizes.stream().filter(s -> s.getSizeID() == p.getSizeID()).findFirst().orElse(null))
                .map(Size::getEuSize)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
