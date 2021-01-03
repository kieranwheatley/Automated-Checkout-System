package com.Model;
import java.util.ArrayList;
import java.util.List;

public final class StockDatabase
{
    private static StockDatabase single_instance = null;
    public List<Product> stock = new ArrayList<Product>();
    public Integer holder = 0;

    public static StockDatabase getInstance()
    {
        if (single_instance == null)
        {
            single_instance = new StockDatabase();
        }
        return single_instance;
    }
}
