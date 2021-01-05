package com.Model;
import java.util.ArrayList;
import java.util.List;

public final class BasketDatabase
{
    private static BasketDatabase INSTANCE = null;
    public List<Product> basket = new ArrayList<Product>();
    public Integer holder = 0;
    private double totalCost = 0.00;
    private boolean paidFor = false;
    private double amountPaid = 0.00;
    private double leftToPay = 0.00;

    public static BasketDatabase getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new BasketDatabase();
        }
        return INSTANCE;
    }

    public double getAmountPaid() {
        return amountPaid;
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
}