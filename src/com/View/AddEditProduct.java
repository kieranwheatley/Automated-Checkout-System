package com.View;

import com.Controller.AdminPanelController;
import com.Controller.StockController;
import com.Controller.UserViewController;
import com.Model.StockDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

//The actual View itself is abstract as this form has the base requirements we need but they change based on which version we use
//The methods below call this and implement it differenlt between Add, Edit, or Removing products
public abstract class AddEditProduct extends JFrame{
    private JPanel JPanelAddEdit;
    private JLabel lblHeader;
    private JTextField txtName;
    private JTextField txtCost;
    private JTextField txtSale;
    private JLabel lblName;
    private JLabel lblCostPerUnit;
    private JLabel lblSalePrice;
    private JLabel lblStockLevel;
    private JPanel valuesPanel;
    private JTextField txtStock;
    private JLabel lblProductCode;
    private JTextField txtProductCode;
    private JButton btnApply;
    private JButton btnCancel;
    private JComboBox cmbProducts;
    private JLabel lblSelectProduct;
    private JTextField txtMinimum;
    private JLabel lblMinimum;
    private JButton btnRemove;
    private JButton btnReturn;
    private AddEditProduct addProduct;
    private AddEditProduct editProduct;
    private AddEditProduct removeProduct;
    private StockController stockController;
    private AdminPanelController adminPanelController;
    private JTextField[] textFields;

    //This methods constructs the view appropriately for adding a new product to the system
    public void addProduct()
    {
        UserViewController viewController = new UserViewController();
        adminPanelController = new AdminPanelController();
        addProduct = this;
        stockController = new StockController();
        setContentPane(this.JPanelAddEdit);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        cmbProducts.setVisible(false);
        lblSelectProduct.setVisible(false);
        btnReturn.setVisible(false);
        lblHeader.setText("Add new product");
        btnApply.setText("Apply Changes");
        btnRemove.setVisible(false);
        textFields = new JTextField[6];
        textFields[0] = txtName;
        textFields[1] = txtCost;
        textFields[2] = txtSale;
        textFields[3] = txtStock;
        textFields[4] = txtMinimum;
        textFields[5] = txtProductCode;
        btnApply.setEnabled(true);
        pack();
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(addProduct, viewController.adminPage);
            }
        });
        btnApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPanelController.addProduct(textFields);
                stockController.saveStock();
            }
        });
    }

    //This methods constructs the view appropriately for editing an existing product in the system
    public void editProduct()
    {
        DecimalFormat pound = new DecimalFormat("#0.00");
        UserViewController viewController = new UserViewController();
        adminPanelController = new AdminPanelController();
        editProduct = this;
        stockController = new StockController();
        setContentPane(this.JPanelAddEdit);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        cmbProducts.setVisible(true);
        textFields = new JTextField[6];
        textFields[0] = txtName;
        textFields[1] = txtCost;
        textFields[2] = txtSale;
        textFields[3] = txtStock;
        textFields[4] = txtMinimum;
        textFields[5] = txtProductCode;
        lblSelectProduct.setVisible(true);
        pack();
        adminPanelController.loadProductsToEdit(cmbProducts);
        btnApply.setText("Update Product");
        btnReturn.setVisible(false);
        btnRemove.setVisible(false);

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
                adminPanelController.applyProductEdit(textFields, cmbProducts.getSelectedIndex());
                stockController.saveStock();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(editProduct, viewController.adminPage);
            }
        });

    }
    //This methods constructs the view appropriately for removing a product from the system
    public void removeProduct()
    {
        UserViewController viewController = new UserViewController();
        adminPanelController = new AdminPanelController();
        removeProduct = this;
        stockController = new StockController();
        setContentPane(this.JPanelAddEdit);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        cmbProducts.setVisible(true);
        lblSelectProduct.setVisible(true);
        txtName.setVisible(false);
        txtCost.setVisible(false);
        txtMinimum.setVisible(false);
        txtProductCode.setVisible(false);
        txtStock.setVisible(false);
        valuesPanel.setVisible(false);
        lblCostPerUnit.setVisible(false);
        lblMinimum.setVisible(false);
        lblName.setVisible(false);
        lblSalePrice.setVisible(false);
        lblStockLevel.setVisible(false);
        lblProductCode.setVisible(false);
        btnReturn.setVisible(true);
        lblSelectProduct.setText("Select product to remove.");
        pack();
        adminPanelController.loadProductsToEdit(cmbProducts);
        btnApply.setText("Remove Product");
        btnApply.setVisible(true);
        lblHeader.setText("Select product to remove.");
        cmbProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRemove.setEnabled(true);
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPanelController.removeItem(cmbProducts.getSelectedIndex());
                cmbProducts.removeAllItems();
                adminPanelController.loadProductsToEdit(cmbProducts);
                stockController.saveStock();
            }
        });
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(removeProduct, viewController.adminPage);
            }
        });

    }
}
