package com.Controller;
import com.Model.StockDatabase;
import com.View.*;
import javax.swing.*;

//The UserViewController is an implementation of the facade pattern. It generates the different views needed and has methods for controlling them
//whilst hiding any complexities. When used in the code, it's simple to control the methods below without needing to see how it works.
public class UserViewController
{
    //Classes
    public TillView till;
    public AdminLogin adminLogin;
    public AdminPanel adminPage;
    public Payment paymentScreen;
    public CashPayment cashPayment;
    public CardPayment cardPayment;
    public Receipt receipt;
    //public AddEditProduct addEditProduct;
    public AddProduct addProduct;
    public EditProduct editProduct;
    public RemoveProduct removeProduct;

    //Create new views
    public void loadGUI()
    {
        StockController stockController = new StockController();
        if (StockDatabase.getInstance().stock.isEmpty())
        {
            stockController.loadStock();
        }
        till = new TillView();
        adminLogin = new AdminLogin();
        adminPage = new AdminPanel();
        paymentScreen = new Payment();
        cashPayment = new CashPayment();
        cardPayment = new CardPayment();
        receipt = new Receipt();
        //addEditProduct = new AddEditProduct();
        addProduct = new AddProduct();
        editProduct = new EditProduct();
        removeProduct = new RemoveProduct();

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