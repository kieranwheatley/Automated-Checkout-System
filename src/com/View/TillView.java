package com.View;

//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import com.Controller.StockController;
import com.Controller.UserViewController;
import com.Model.BasketDatabase;

public class TillView extends JFrame
{
    private JPanel JPanelBackground;
    private JButton btnAdmin;
    private JLabel lblHeader;
    private JLabel lblStock;
    private JLabel lblBasket;
    private JButton btnManualSelect;
    private JButton btnScanBarcode;
    private JButton btnPayment;
    private JLabel lblTotalCost;
    private JList JListAvailable;
    private JList JListBasket;
    private JLabel lblDateTime;
    private JTextField textField1;
    private JScrollPane scroll;
    private JScrollPane JScrollAvailableStock;
    private AdminLogin adminLogin;
    private DefaultListModel<String> availableStockList;
    private DefaultListModel<String> basketList;
    private int selectedItem;
    private TillView tillView;


    public TillView()
    {
        //Declarations
        tillView = this;
        UserViewController viewController = new UserViewController();
        StockController stockControl = new StockController();
        stockControl.loadStock();

        availableStockList = new DefaultListModel<String>();
        basketList = new DefaultListModel<String>();


        //Frame-related
        setContentPane(JPanelBackground);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(650, 600));
        stockControl.displayStock(availableStockList, JListAvailable);
        lblDateTime.setText(new Date().toString());
        pack();


        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(tillView, viewController.adminLogin);
                tillView.setVisible(false);
            }
        });
        btnManualSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    selectedItem = JListAvailable.getSelectedIndex();
                    stockControl.addProductToBasket(selectedItem);
                    stockControl.displayBasket(basketList, JListBasket);
                    stockControl.displayStock(availableStockList, JListAvailable);
                    stockControl.priceCalculation();
                    lblTotalCost.setText("Total Cost: £" + String.valueOf(BasketDatabase.getInstance().getTotalCost()));
                    btnPayment.setEnabled(true);
                }
                catch (Exception e1){}
            }
        });
        btnPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(tillView, viewController.paymentScreen);
            }
        });
    }
}
