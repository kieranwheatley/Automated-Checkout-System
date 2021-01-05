package com.Controller;

import com.Model.BasketDatabase;

import javax.swing.*;

public class ReceiptController {
    private PaymentController paymentController;
    public void printReceipt(JTextArea receiptDisplay){
        paymentController = new PaymentController();
        ThreadLocal<String> receiptThread = new ThreadLocal<>();
        DefaultListModel<String> receipt = BasketDatabase.getInstance().generateReceipt();
        receiptThread.set(receipt.toString());
        receiptDisplay.setText(receiptThread.get());
    }
}
