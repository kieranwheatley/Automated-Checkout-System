package com.View;

import com.Controller.PaymentController;
import com.Controller.StockController;
import com.Controller.UserViewController;
import com.Model.BasketDatabase;

import javax.swing.*;
import java.awt.*;

public class Receipt extends JFrame{
    private JPanel JPanelReceipt;
    private Receipt receipt;
    private UserViewController viewController;
    private BasketDatabase basketDatabase;


    public Receipt()
    {
        receipt = this;
        viewController = new UserViewController();
        basketDatabase = new BasketDatabase();


        //Frame-related
        setContentPane(this.JPanelReceipt);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(350, 200));
        pack();
    }
}
