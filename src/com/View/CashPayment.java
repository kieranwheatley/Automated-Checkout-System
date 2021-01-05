package com.View;

import com.Controller.PaymentController;
import com.Controller.UserViewController;
import com.Model.BasketDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CashPayment extends JFrame{
    private JPanel jPanelCash;
    private JLabel lblTotalToPay;
    private JLabel lblLeftToPay;
    private JLabel lblHasPaid;
    private JLabel lblCashAmount;
    private JButton btnPay;
    private JButton btnClear;
    private JTextField txtCashAmount;
    private CashPayment cashPayment;
    private PaymentController paymentController;

    public CashPayment()
    {
        UserViewController viewController = new UserViewController();
        DecimalFormat pound = new DecimalFormat("#0.00");
        cashPayment = this;
        paymentController = new PaymentController();
        setContentPane(jPanelCash);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 150));
        lblTotalToPay.setText("Total: £" + pound.format(BasketDatabase.getInstance().getTotalCost()));
        pack();

        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double paid = Double.parseDouble(txtCashAmount.getText());
                paymentController.checkPaidAmount(paid, cashPayment);
                lblHasPaid.setText("Total Paid: £" + pound.format(BasketDatabase.getInstance().getAmountPaid()));
                lblLeftToPay.setText("Remaining: £" + pound.format(BasketDatabase.getInstance().getLeftToPay()));
            }
        });
    }
}
