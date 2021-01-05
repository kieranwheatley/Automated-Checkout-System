package com.Controller;

import com.Model.BasketDatabase;

import javax.swing.*;
import java.text.DecimalFormat;

public class PaymentController {

    UserViewController viewController = new UserViewController();
    DecimalFormat pound = new DecimalFormat("#0.00");


    public String displayTotal() {
        StockController stock = new StockController();
        String total = String.valueOf(BasketDatabase.getInstance().getTotalCost());
        return total;
    }

    public void checkPaidAmount(double paidAmount, JFrame current) {
        double totalToPay = BasketDatabase.getInstance().getTotalCost();
        if (BasketDatabase.getInstance().getAmountPaid() == 0.00) {
            BasketDatabase.getInstance().setAmountPaid(paidAmount);
        } else if (BasketDatabase.getInstance().getAmountPaid() > 0.00) {
            BasketDatabase.getInstance().setAmountPaid(BasketDatabase.getInstance().getAmountPaid() + paidAmount);
        }
        BasketDatabase.getInstance().setLeftToPay(BasketDatabase.getInstance().getTotalCost() - BasketDatabase.getInstance().getAmountPaid());
        if (BasketDatabase.getInstance().getAmountPaid() >= totalToPay) {
            BasketDatabase.getInstance().setPaidFor(true);
            int yesNoReceipt = JOptionPane.showConfirmDialog(null, "Would you like a receipt?", "Payment Successful.", JOptionPane.YES_NO_OPTION);
            if (yesNoReceipt == JOptionPane.YES_OPTION) {
                viewController.loadGUI();
                viewController.changeView(current, viewController.receipt);
                viewController.cashPayment.setVisible(false);
            } else if (yesNoReceipt == JOptionPane.NO_OPTION) {
                viewController.loadGUI();
                viewController.changeView(current, viewController.till);
            } else {
                BasketDatabase.getInstance().setPaidFor(false);
            }
        }
    }
    public void verifyCard(JFrame current)
    {

    }
}
