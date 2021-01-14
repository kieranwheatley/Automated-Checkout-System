package com.View;

import com.Controller.PaymentController;
import com.Controller.StockController;
import com.Controller.UserViewController;
import com.Model.BasketDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Payment extends JFrame{
    private JLabel lblOrderTotal;
    private JLabel lblPaymentMethod;
    private JButton btnCash;
    private JButton btnCard;
    private JPanel paymentPanel;
    private Payment payment;
    private UserViewController viewController;


    public Payment()
    {
        payment = this;
        viewController = new UserViewController();
        DecimalFormat pound = new DecimalFormat("#0.00");

        //Frame-related
        setContentPane(this.paymentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(350, 200));
        lblOrderTotal.setText("Total price: £" + pound.format(BasketDatabase.getInstance().getTotalCost()));
        pack();


        btnCash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(payment, viewController.cashPayment);
            }
        });
        btnCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.loadGUI();
                viewController.changeView(payment, viewController.cardPayment);
            }
        });
    }
}
