package com.Controller;

import com.Model.BasketDatabase;
import com.Model.StockDatabase;
import javafx.scene.media.AudioClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class ReceiptController {
    private PaymentController paymentController;
    private AudioController audioController;

    public void printReceipt(JTextArea receiptDisplay){
        paymentController = new PaymentController();
        audioController = new AudioController();
        ThreadLocal<String> receiptThread = new ThreadLocal<>();
        DefaultListModel<String> receipt = BasketDatabase.getInstance().generateReceipt();
        receiptThread.set(receipt.toString());
        receiptDisplay.setText(receiptThread.get().substring(1, receiptThread.get().length() - 1));

    }
}
