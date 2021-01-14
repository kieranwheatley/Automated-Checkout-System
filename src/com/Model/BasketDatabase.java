package com.Model;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//BasketDatabase stores items added to basket. Singleton pattern used
public final class BasketDatabase
{
    private static BasketDatabase INSTANCE = null;
    public final List<Product> basket = new ArrayList<Product>();
    private double totalCost = 0.00;
    private boolean paidWithCard = false;
    private double amountPaid = 0.00;
    private double leftToPay = 0.00;
    //DecimalFormat ensures that when the price is printed, it always sticks to the pattern of "£0.00" and doesn't gain or lose decimal places
    DecimalFormat pound = new DecimalFormat("#0.00");

    public static BasketDatabase getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new BasketDatabase();
        }
        return INSTANCE;
    }
    //Generates the header segment of the receipt. Used in the generateReceipt method
    public String generateHeader()
    {
        String dateTime = new Date().toString();
        return ("Food and Stuff Superstores\n1 Mutley Plain\n" + dateTime + "\n");
    }
    //Method for generating a receipt
    public DefaultListModel<String> generateReceipt()
    {
        DefaultListModel<String> receipt = new DefaultListModel<>();
        String header = generateHeader();
        String footer = generateFooter();
        receipt.addElement(header);
        //Adds the names and prices of each item in the BasketDatabase to the DefaultListModel
        for (int i = 1; i <= basket.size(); i++) {
            int index = i - 1;
            String itemInBasket = "\n" + basket.get(index).getName() + " | £" + pound.format(basket.get(index).getSalePrice());
            receipt.add(i, itemInBasket);
        }
        int index = basket.size();
        index++;
        receipt.add(index, footer);
        return receipt;

    }
    //Method for generating a footer for the receipt, changes to reflect card payment or cash (which requires amount paid and change given)
    //Called in generateReceipt methopd
    public String generateFooter()
    {
        //Math.abs makes what would be a negative value into a positive, for correctly displaying change given
        double change = Math.abs(totalCost - amountPaid);
        if (BasketDatabase.getInstance().isPaidWithCard())
        {
            return ("\n\nTotal: £" + totalCost + "\nPaid amount via Card.");
        }
        else if (!BasketDatabase.getInstance().isPaidWithCard())
        {
            return ("\n\nTotal: £" + pound.format(totalCost) + "\nCash Paid: £" + pound.format(amountPaid) + "\nChange Given: £" + pound.format(change));
        }

        return "footer";
    }

    //  Getters/Setters
    public double getAmountPaid() {
        return amountPaid;
    }
    public boolean isPaidWithCard() {
        return paidWithCard;
    }
    public void setPaidWithCard(boolean paidWithCard) {
        this.paidWithCard = paidWithCard;
    }
    public void setLeftToPay(double leftToPay) {
        this.leftToPay = leftToPay;
    }
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

}