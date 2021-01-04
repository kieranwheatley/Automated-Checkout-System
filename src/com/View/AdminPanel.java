package com.View;
import com.Controller.UserViewController;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminPanel extends JFrame
{
    private AdminPanel adminView;
    private JPanel adminViewPanel;


    public AdminPanel()
    {
        UserViewController viewController = new UserViewController();
        adminView = this;
        setContentPane(adminViewPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        pack();
    }
}
