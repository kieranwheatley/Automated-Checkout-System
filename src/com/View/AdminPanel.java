package com.View;
import com.Controller.AdminLoginController;
import com.Controller.AdminPanelController;
import com.Controller.UserViewController;
import jdk.nashorn.internal.ir.BlockStatement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminPanel extends JFrame
{
    private AdminPanel adminView;
    private JPanel adminViewPanel;
    private JLabel lblHeader;
    private JList lstStock;
    private JPanel pnlRightSide;
    private JLabel lblOptions;
    private JLabel lblAddProduct;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JLabel lblOrder;
    private JLabel lblEditProduct;
    private JLabel lblRemoveProduct;
    private JLabel lblAcceptDelivery;
    private JLabel lblAddAdmin;
    private JButton btnReturn;
    private JLabel lblUser;
    private JButton button7;


    public AdminPanel()
    {
        UserViewController viewController = new UserViewController();
        adminView = this;
        setContentPane(adminViewPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 350));
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
    }
}
