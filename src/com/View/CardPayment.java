package com.View;

import com.Controller.PaymentController;
import com.Controller.UserViewController;
import com.Model.BasketDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardPayment extends JFrame{
    private JPanel JPanelCard;
    private JButton btnAccept;
    private JButton btnDecline;
    private JLabel lblAcceptDecline;
    private CardPayment cardPayment;
    private PaymentController paymentController;

    //Constructor for the Card Payment view
    public CardPayment()
    {
        cardPayment = this;
        paymentController = new PaymentController();
        setContentPane(this.JPanelCard);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 150));
        setTitle("Card Payment");
        pack();
        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentController.verifyCard(cardPayment);
            }
        });
        btnDecline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentController.cardDeclined(cardPayment);
            }
        });
    }
}
