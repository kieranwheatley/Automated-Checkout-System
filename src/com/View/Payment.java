package com.View;

import com.Controller.PaymentController;
import com.Controller.StockController;
import com.Controller.UserViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame{
    private JLabel lblOrderTotal;
    private JLabel lblPaymentMethod;
    private JButton btnCash;
    private JButton btnCard;
    private JPanel paymentPanel;
    private Payment payment;
    private UserViewController viewController;
    private StockController stockControl;
    private PaymentController paymentController;


    public Payment()
    {
        payment = this;
        viewController = new UserViewController();
        stockControl = new StockController();
        paymentController = new PaymentController();

        //Frame-related
        setContentPane(this.paymentPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(350, 200));
        lblOrderTotal.setText("Total price: £" + paymentController.displayTotal());
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

    //Declarations

}
