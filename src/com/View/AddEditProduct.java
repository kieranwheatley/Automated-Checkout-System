package com.View;

import com.Controller.AddEditController;
import com.Controller.StockController;
import com.Controller.UserViewController;
import com.Model.StockDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class AddEditProduct extends JFrame{
    private JPanel JPanelAddEdit;
    private JLabel lblHeader;
    private JTextField txtName;
    private JTextField txtCost;
    private JTextField txtSale;
    private JLabel lblName;
    private JLabel lblCostPerUnit;
    private JLabel lblSalePrice;
    private JLabel lblStockLevel;
    private JPanel txtStockLevel;
    private JTextField txtStock;
    private JLabel lblProductCode;
    private JTextField txtProductCode;
    private JButton btnApply;
    private JButton btnCancel;
    private JComboBox cmbProducts;
    private JLabel lblSelectProduct;
    private JTextField txtMinimum;
    private JLabel lblMinimum;
    private AddEditProduct addProduct;
    private AddEditProduct editProduct;
    private StockController stockController;
    private UserViewController viewController;
    private AddEditController addEditController;


    public AddEditProduct() {

    }

    public void addProduct()
    {
        UserViewController viewController = new UserViewController();
        addEditController = new AddEditController();
        addProduct = this;
        stockController = new StockController();
        setContentPane(this.JPanelAddEdit);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        cmbProducts.setVisible(false);
        lblSelectProduct.setVisible(false);
        pack();
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(addProduct, viewController.till);
            }
        });
    }
    public void editProduct()
    {
        DecimalFormat pound = new DecimalFormat("#0.00");
        UserViewController viewController = new UserViewController();
        addEditController = new AddEditController();
        editProduct = this;
        stockController = new StockController();
        setContentPane(this.JPanelAddEdit);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        cmbProducts.setVisible(true);
        lblSelectProduct.setVisible(true);
        pack();
        addEditController.loadProductsToEdit(cmbProducts);
        btnApply.setText("Update Product");
        lblHeader.setText("Product Information - Update");
        cmbProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnApply.setEnabled(true);

                txtName.setText(StockDatabase.getInstance().stock.get(cmbProducts.getSelectedIndex()).getName());
                txtCost.setText(pound.format(StockDatabase.getInstance().stock.get(cmbProducts.getSelectedIndex()).getBuyPrice()));
                txtSale.setText(pound.format(StockDatabase.getInstance().stock.get(cmbProducts.getSelectedIndex()).getSalePrice()));
                txtStock.setText(String.valueOf(StockDatabase.getInstance().stock.get(cmbProducts.getSelectedIndex()).getStockLevel()));
                txtMinimum.setText(String.valueOf(StockDatabase.getInstance().stock.get(cmbProducts.getSelectedIndex()).getMinimumOrderLevel()));
                txtProductCode.setText(String.valueOf(StockDatabase.getInstance().stock.get(cmbProducts.getSelectedIndex()).getProductCode()));
            }
        });
        btnApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditController.applyProductEdit(txtName, txtCost, txtSale, txtStock, txtMinimum, txtProductCode, cmbProducts.getSelectedIndex());
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(editProduct, viewController.till);
            }
        });
    }
}
