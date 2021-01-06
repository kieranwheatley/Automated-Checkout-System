package com.View;
import com.Controller.StockController;
import com.Controller.UserViewController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminPanel extends JFrame
{
    private AdminPanel adminView;
    private StockController stockController;
    private JPanel adminViewPanel;
    private JLabel lblHeader;
    private JPanel pnlRightSide;
    private JLabel lblOptions;
    private JButton addProductButton;
    private JButton orderStockButton;
    private JButton updateProductButton;
    private JButton removeProductButton;
    private JButton processDeliveryButton;
    private JButton createAdminButton;
    private JButton btnReturn;
    private JLabel lblUser;
    private JButton btnReorder;
    private JLabel lblLowStock;
    private JList lstStock;
    private DefaultListModel<String> lowStockList;


    public AdminPanel()
    {
        UserViewController viewController = new UserViewController();
        adminView = this;
        stockController = new StockController();
        setContentPane(adminViewPanel);
        lowStockList = new DefaultListModel<String>();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(650, 400));
        stockController.displayLowStock(lowStockList, lstStock);
        pack();
        //Return button
        btnReturn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                viewController.loadGUI();
                viewController.changeView(adminView, viewController.till);
            }
        });
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(adminView, viewController.addProduct);
            }
        });
        updateProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(adminView, viewController.editProduct);
            }
        });
    }
}
