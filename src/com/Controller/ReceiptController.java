package com.Controller;
import com.Model.BasketDatabase;
import javax.swing.*;

public class ReceiptController {

    //Method for printing the receipt. Takes in the JTextArea where the receipt is displayed.
    //Creates a ThreadLocal string type and a DefaultListModel. The DefaultListModel is then set to match the receipt
    //generated by the BasketDatabase methods. The ThreadLocal is then set to the receipt text and then the JTextArea is set to the threads value,
    //passed back into the View with the data displaying
    public void printReceipt(JTextArea receiptDisplay){
        ThreadLocal<String> receiptThread = new ThreadLocal<>();
        DefaultListModel<String> receipt = BasketDatabase.getInstance().generateReceipt();
        receiptThread.set(receipt.toString());
        //The substring method is used for removing the square brackets generated in the DefaultListModel when creating the receipt
        receiptDisplay.setText(receiptThread.get().substring(1, receiptThread.get().length() - 1));

    }
}
