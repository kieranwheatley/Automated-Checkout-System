package com.View;

import com.Controller.UserViewController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminLoginView extends JFrame{
    private JPanel adminLoginPanel;
    private JLabel lblHeader;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JPasswordField pwfPassword;
    private JTextField textField1;
    private JButton btnReturn;
    private JButton btnLogin;
    private AdminLoginView adminLoginView;

    public AdminLoginView()
    {
        UserViewController viewController = new UserViewController();
        adminLoginView = this;
        setContentPane(adminLoginPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        pack();

        btnReturn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                viewController.loadGUI();
                viewController.changeView(adminLoginView, viewController.till);
            }
        });
    }
}
