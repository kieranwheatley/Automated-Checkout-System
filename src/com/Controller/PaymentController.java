package com.Controller;
import com.Model.BasketDatabase;
import javax.swing.*;
import java.text.DecimalFormat;

public class PaymentController {

    UserViewController viewController = new UserViewController();
    DecimalFormat pound = new DecimalFormat("#0.00");
    StockController stockController = new StockController();


    public String displayTotal() {
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
            int yesNoReceipt = JOptionPane.showConfirmDialog(null, "Would you like a receipt?", "Payment Successful.", JOptionPane.YES_NO_OPTION);
            if (yesNoReceipt == JOptionPane.YES_OPTION) {
                viewController.loadGUI();
                viewController.changeView(current, viewController.receipt);
            } else if (yesNoReceipt == JOptionPane.NO_OPTION) {
                viewController.loadGUI();
                viewController.changeView(current, viewController.till);
            }
        }
    }
    public void verifyCard(JFrame current) {
        BasketDatabase.getInstance().setPaidWithCard(true);
        int yesNoReceipt = JOptionPane.showConfirmDialog(null, "Would you like a receipt?", "Card authorised, payment successful!.", JOptionPane.YES_NO_OPTION);
        if (yesNoReceipt == JOptionPane.YES_OPTION) {
            BasketDatabase.getInstance().setAmountPaid(BasketDatabase.getInstance().getTotalCost());
            stockController.saveStock();
            viewController.loadGUI();
            viewController.changeView(current, viewController.receipt);

        }
        else if(yesNoReceipt == JOptionPane.NO_OPTION){
            viewController.loadGUI();
            viewController.changeView(current, viewController.till);
        }
    }
    public void cardDeclined(JFrame current)
    {
        Object[] options = {"Retry", "Cancel"};
        int retry = JOptionPane.showOptionDialog(null, "Card was not accepted. Would you like to retry?", "Authorisation Failed.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (retry == JOptionPane.YES_OPTION)
        {
            JOptionPane.showMessageDialog(null, "Please insert new card and wait for approval.", "Card Payment.", JOptionPane.PLAIN_MESSAGE);
        }
        else if(retry == JOptionPane.NO_OPTION)
        {
            viewController.loadGUI();
            viewController.changeView(current, viewController.till);
        }
    }
}