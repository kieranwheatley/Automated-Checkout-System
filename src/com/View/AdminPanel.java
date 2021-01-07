package com.View;
import com.Controller.AdminPanelController;
import com.Controller.StockController;
import com.Controller.UserViewController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
    private JButton updateProductButton;
    private JButton removeProductButton;
    private JButton createAdminButton;
    private JButton btnReturn;
    private JLabel lblUser;
    private JLabel lblLowStock;
    private JList lstStock;
    private JButton orderStockButton;
    private DefaultListModel<String> lowStockList;
    private AdminPanelController adminPanelController;


    public AdminPanel()
    {
        UserViewController viewController = new UserViewController();
        adminView = this;
        adminPanelController = new AdminPanelController();
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
        removeProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(adminView, viewController.removeProduct);
            }
        });

        orderStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPanelController.sendStockInvoice();
            }
        });
    }
}
