package com.Controller;
import com.View.*;
import javax.swing.*;


public class UserViewController
{
    //Classes
    public TillView till;
    public AdminLogin adminLogin;
    public AdminPanel adminPage;

    //Create new views
    public void loadGUI()
    {
        till = new TillView();
        adminLogin = new AdminLogin();
        adminPage = new AdminPanel();
    }
    //Method to change visible page to selected one
    public void changeView(JFrame currentView, JFrame newView)
    {
        loadGUI();
        newView.setVisible(true);
        currentView.setVisible(false);
        newView.setLocation(currentView.getLocation());
        newView.setVisible(true);
    }
}
