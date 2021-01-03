package com.Model;
import java.util.ArrayList;
import java.util.List;

public final class BasketDatabase
{
    private static BasketDatabase single_instance = null;
    public List<Product> basket = new ArrayList<Product>();
    public Integer holder = 0;
    private double totalCost = 0.0;

    public static BasketDatabase getInstance()
    {
        if (single_instance == null)
        {
            single_instance = new BasketDatabase();
        }
        return single_instance;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}