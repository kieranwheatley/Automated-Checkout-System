package com.View;
import com.Controller.AdminLoginController;
import com.Controller.UserViewController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminLogin extends JFrame{
    private JPanel adminLoginPanel;
    private JLabel lblHeader;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JPasswordField pwfPassword;
    private JTextField txtUsername;
    private JButton btnReturn;
    private JButton btnLogin;
    private JTextField txtPassword;
    private AdminLogin adminLoginView;

    public AdminLogin()
    {
        UserViewController viewController = new UserViewController();
        AdminLoginController loginController = new AdminLoginController();
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
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                if(loginController.checkAdmin(username, password))
                {
                    viewController.loadGUI();
                    viewController.changeView(adminLoginView, viewController.adminPage);
                }
            }
        });
    }
}
