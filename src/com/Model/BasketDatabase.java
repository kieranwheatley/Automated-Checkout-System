package com.Model;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class BasketDatabase
{
    private static BasketDatabase INSTANCE = null;
    public List<Product> basket = new ArrayList<Product>();
    public Integer holder = 0;
    private double totalCost = 0.00;
    private boolean paidFor = false;
    private boolean paidWithCard = false;
    private double amountPaid = 0.00;
    private double leftToPay = 0.00;
    private boolean basketPaidFor = false;

    DecimalFormat pound = new DecimalFormat("#0.00");

    public static BasketDatabase getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new BasketDatabase();
        }
        return INSTANCE;
    }
    public String generateHeader()
    {
        String dateTime = new Date().toString();
        String receiptHeader = ("Food and Stuff Superstores\n1 Mutley Plain\n" + dateTime);
        return receiptHeader;

    }
    public DefaultListModel<String> generateReceipt()
    {
        DefaultListModel<String> receipt = new DefaultListModel<>();
        String header = generateHeader();
        String footer = generateFooter();
        receipt.add(0, header);
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

    public String generateFooter()
    {
        //Math.abs makes what would be a negative value into a positive, for correctly displaying change given
        double change = Math.abs(totalCost - amountPaid);
        String footer;

        if (BasketDatabase.getInstance().isPaidWithCard() == true)
        {
            return ("\n\nTotal: £" + totalCost + "\nPaid amount via Card.");
        }
        else if (BasketDatabase.getInstance().isPaidWithCard() == false)
        {
            return ("\n\nTotal: £" + pound.format(totalCost) + "\nCash Paid: £" + pound.format(amountPaid) + "\nChange Given: £" + pound.format(change));
        }

        return "footer";
    }
    public double getAmountPaid() {
        return amountPaid;
    }

    public boolean isPaidWithCard() {
        return paidWithCard;
    }

    public void setPaidWithCard(boolean paidWithCard) {
        this.paidWithCard = paidWithCard;
    }

    public double getLeftToPay() {
        return leftToPay;
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

    public boolean isPaidFor() {
        return paidFor;
    }

    public void setPaidFor(boolean paidFor) {
        this.paidFor = paidFor;
    }

    public boolean isBasketPaidFor() {
        return basketPaidFor;
    }

    public void setBasketPaidFor(boolean basketPaidFor) {
        this.basketPaidFor = basketPaidFor;
    }
}