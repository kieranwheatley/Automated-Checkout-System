package com.Controller;
import com.View.*;
import javax.swing.*;


public class UserViewController
{
    //Classes
    public TillView till;
    public AdminLoginView adminLogin;

    //Create new views
    public void loadGUI()
    {
        till = new TillView();
        adminLogin = new AdminLoginView();
    }
    //Method to change visible page to selected one
    public void changeView(JFrame currentView, JFrame newView)
    {
        loadGUI();
        currentView.setVisible(false);
        newView.setLocation(currentView.getLocation());
        newView.setSize(currentView.getSize());
        newView.setVisible(true);
    }
}
