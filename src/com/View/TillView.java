package com.View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.*;
import com.Controller.AudioController;
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
    private DefaultListModel<String> availableStockList;
    private DefaultListModel<String> basketList;
    private int selectedItemIndex;
    private TillView tillView;

    //Constructor for generating the Till View
    public TillView()
    {
        tillView = this;
        UserViewController viewController = new UserViewController();
        StockController stockControl = new StockController();
        DecimalFormat pound = new DecimalFormat("#0.00");
        availableStockList = new DefaultListModel<String>();
        basketList = new DefaultListModel<String>();
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
                    selectedItemIndex = JListAvailable.getSelectedIndex();
                    stockControl.addProductToBasket(selectedItemIndex);
                    stockControl.displayBasket(basketList, JListBasket);
                    stockControl.displayStock(availableStockList, JListAvailable);
                    stockControl.priceCalculation();
                    lblTotalCost.setText("Total Cost: £" + pound.format(BasketDatabase.getInstance().getTotalCost()));
                    btnPayment.setEnabled(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(tillView, viewController.paymentScreen);
            }
        });
        btnScanBarcode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockControl.barcodeScanner();
                stockControl.displayBasket(basketList, JListBasket);
                stockControl.displayStock(availableStockList, JListAvailable);
                stockControl.priceCalculation();
                lblTotalCost.setText("Total Cost: £" + pound.format(BasketDatabase.getInstance().getTotalCost()));
                btnPayment.setEnabled(true);
            }
        });
    }
}