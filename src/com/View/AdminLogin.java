package com.View;
import com.Controller.AdminLoginController;
import com.Controller.AdminPanelController;
import com.Controller.UserViewController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminLogin extends JFrame{
    private JPanel adminLoginPanel;
    private JLabel lblHeader;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JButton btnReturn;
    private JButton btnLogin;
    private JTextField txtPassword;
    private AdminLogin adminLoginView;
    private AdminPanelController adminController;
    private DefaultListModel<String> lowStock;

    //Constructor for the AdminLogin page
    public AdminLogin()
    {
        UserViewController viewController = new UserViewController();
        AdminLoginController loginController = new AdminLoginController();
        adminController = new AdminPanelController();
        adminLoginView = this;
        lowStock = new DefaultListModel<String>();
        setContentPane(adminLoginPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));
        loginController.loadAdmins();
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
                boolean canLogin;
                canLogin = loginController.checkAdmin(txtUsername.getText(), txtPassword.getText());
                if (canLogin)
                {
                    viewController.loadGUI();
                    viewController.changeView(adminLoginView, viewController.adminPage);
                    adminController.checkStockLevels(lowStock);
                }
                else {
                    JOptionPane.showMessageDialog(getFrames()[0], "Username and/or password are incorrect. Please try again.", "Login Failed.", JOptionPane.ERROR_MESSAGE);
                    txtUsername.setText("");
                    txtPassword.setText("");
                }
            }
        });
    }
}
