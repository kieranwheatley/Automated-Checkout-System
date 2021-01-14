package com.Controller;
import com.Model.BasketDatabase;
import javax.swing.*;

public class PaymentController {

    UserViewController viewController = new UserViewController();
    StockController stockController = new StockController();
    AudioController audioController = new AudioController();

    //Method for checking if the paid total is greater than the total amount owed, if it isn't then it keeps accepting input
    //When it is equal to or greater than the total due, it will open the Dialog box asking whether or not they would like a receipt
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
                audioController = new AudioController();
                audioController.receiptPrinting();
            } else if (yesNoReceipt == JOptionPane.NO_OPTION) {
                viewController.loadGUI();
                viewController.changeView(current, viewController.till);
            }
        }
    }
    //Method for accepting the card provided. Creates a dialog box asking if the user would like a receipt. If yes it takes them to the receipt view,
    //if not, they return to the till.
    public void verifyCard(JFrame current) {
        BasketDatabase.getInstance().setPaidWithCard(true);
        int yesNoReceipt = JOptionPane.showConfirmDialog(null, "Would you like a receipt?", "Card authorised, payment successful!.", JOptionPane.YES_NO_OPTION);
        if (yesNoReceipt == JOptionPane.YES_OPTION) {
            BasketDatabase.getInstance().setAmountPaid(BasketDatabase.getInstance().getTotalCost());
            stockController.saveStock();
            viewController.loadGUI();
            viewController.changeView(current, viewController.receipt);
            audioController = new AudioController();
            audioController.receiptPrinting();

        }
        else if(yesNoReceipt == JOptionPane.NO_OPTION){
            viewController.loadGUI();
            viewController.changeView(current, viewController.till);
        }
    }
    //Method for handling declined card payments. Custom Dialog box asks the user to retry or not. If they retry it opens a new dialog box telling them to insert
    //a new card. If not, they return to the till.
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