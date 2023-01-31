package Gui;

import Utilities.PromptText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;
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

    public ProductPanel(Buttons buttons) {
        this.buttons = buttons;
        setBackground(Color.white);
        setPreferredSize(new Dimension(700, 763));
        String[] product = new String[250];
        String[] color = new String[250];
        String[] size = new String[250];
        String[] inStock = new String[250];
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(700,100));
        topPanel.setMaximumSize(new Dimension(700,100));
        topPanel.setBackground(Color.blue);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(100,563));
        leftPanel.setMaximumSize(new Dimension(100,563));
        leftPanel.setBackground(Color.red);

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(100,563));
        rightPanel.setMaximumSize(new Dimension(100,563));
        rightPanel.setBackground(Color.red);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(700,100));
        bottomPanel.setMaximumSize(new Dimension(700,100));
        bottomPanel.setBackground(Color.blue);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.green);

        add(topPanel,BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        comboBox = new JComboBox<String>();
        comboBox0 = new JComboBox<String>();
        comboBox1 = new JComboBox<String>();
        comboBox2 = new JComboBox<String>();
        comboBox3 = new JComboBox<String>();


        populateComboBox(comboBox, "Select Gender",()-> buttons.getGui().getMain().getGender().stream().distinct().collect(Collectors.toList()));



        comboBox.addActionListener(e->{
            if(removing)return;
            if(comboBox.getSelectedItem() != "Select Gender"){
                populateComboBox(comboBox0, "Select Category", ()-> buttons.getGui().getMain().getCategoryByGender(comboBox.getSelectedItem().toString()));
                comboBox0.setVisible(true);
                comboBox1.setVisible(false);
                comboBox2.setVisible(false);
                comboBox3.setVisible(false);
            }
        });
        comboBox0.addActionListener(e->{
            if(removing)return;
            if(comboBox0.getSelectedItem() != "Select Category"){

                populateComboBox(comboBox1, "Select Product", ()-> buttons.getGui().getMain().getProductByCategory(comboBox.getSelectedItem().toString(),comboBox0.getSelectedItem().toString()));
                comboBox1.setVisible(true);
                comboBox2.setVisible(false);
                comboBox3.setVisible(false);
                comboBox1.setSelectedItem("Select Product");
            }
        });
        comboBox1.addActionListener(e->{
            if(removing)return;
            if(comboBox1.getSelectedItem() != "Select Product"){
                populateComboBox(comboBox2, "Select Color", ()-> buttons.getGui().getMain().getColorByProduct(comboBox1.getSelectedItem().toString()));
                comboBox2.setVisible(true);
                comboBox3.setVisible(false);
            }
        });
        comboBox2.addActionListener(e->{
            if(removing)return;
            if(comboBox2.getSelectedItem() != "Select Color"){
                populateComboBox(comboBox3, "Select Size", ()-> buttons.getGui().getMain().getSizeByProduct(comboBox1.getSelectedItem().toString()));
                comboBox3.setVisible(true);
            }
        });

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

}
