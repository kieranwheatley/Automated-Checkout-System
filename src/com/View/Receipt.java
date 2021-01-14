package com.View;
import com.Controller.*;
import com.Model.BasketDatabase;
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
    private ReceiptController receiptController;
    //Constructor for creating the Receipt view
    public Receipt()
    {
        receipt = this;
        viewController = new UserViewController();
        receiptController = new ReceiptController();
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
