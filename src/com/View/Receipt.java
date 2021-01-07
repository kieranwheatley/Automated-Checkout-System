package com.View;

import com.Controller.AudioController;
import com.Controller.ReceiptController;
import com.Controller.UserViewController;
import com.Model.BasketDatabase;
import javafx.scene.media.AudioClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Receipt extends JFrame{
    private JPanel JPanelReceipt;
    private JTextArea txtReceiptArea;
    private JButton btnClose;
    private Receipt receipt;
    private UserViewController viewController;
    private BasketDatabase basketDatabase;
    private ReceiptController receiptController;
    private AudioController audioController;


    public Receipt()
    {
        receipt = this;
        viewController = new UserViewController();
        basketDatabase = new BasketDatabase();
        receiptController = new ReceiptController();
        audioController = new AudioController();


        //Frame-related
        setContentPane(this.JPanelReceipt);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 400));
        receiptController.printReceipt(txtReceiptArea);
        pack();

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BasketDatabase.getInstance().basket.clear();
                viewController.loadGUI();
                viewController.changeView(receipt, viewController.till);
            }
        });
    }
}
