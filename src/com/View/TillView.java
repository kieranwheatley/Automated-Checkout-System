package com.View;

//Imports
import java.awt.*;
import java.awt.event.*;
import java.rmi.server.ExportException;
import javax.swing.*;

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
    private JScrollPane JScrollAvailableStock;
    private AdminLoginView adminLogin;
    private DefaultListModel<String> list;
    private DefaultListModel<String> basketList;
    private int selectedItem;


    public TillView()
    {
        list = new DefaultListModel<String>();
        basketList = new DefaultListModel<String>();
        UserViewController viewController = new UserViewController();
        StockController stockControl = new StockController();
        setContentPane(JPanelBackground);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        stockControl.loadStock();
        stockControl.displayStock(list, JListAvailable);
        pack();

        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.clear();
                viewController.loadGUI();
                viewController.changeView(viewController.till,viewController.adminLogin);
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
                    stockControl.displayStock(list, JListAvailable);
                    stockControl.priceCalculation();
                    lblTotalCost.setText("Total Cost: £" + String.valueOf(BasketDatabase.getInstance().getTotalCost()));
                }
                catch (Exception e1){}
            }
        });
    }
}
