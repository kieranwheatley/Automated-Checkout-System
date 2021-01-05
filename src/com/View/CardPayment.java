package com.View;

import com.Controller.UserViewController;
import com.Model.BasketDatabase;

import javax.swing.*;
import java.awt.*;

public class CardPayment extends JFrame{
    private JPanel JPanelCard;
    private JButton btnAccept;
    private JButton btnDecline;
    private JLabel lblAcceptDecline;
    private CardPayment cardPayment;
    private UserViewController viewController;



    public CardPayment()
    {
        cardPayment = this;
        viewController = new UserViewController();
        setContentPane(this.JPanelCard);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 150));
        pack();
    }
}
