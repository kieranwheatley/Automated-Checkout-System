package com.Model;
import java.util.ArrayList;
import java.util.List;

public final class StockDatabase
{
    private static StockDatabase INSTANCE = null;
    public List<Product> stock = new ArrayList<Product>();
    public Integer holder = 0;

    public static StockDatabase getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new StockDatabase();
        }
        return INSTANCE;
    }
}
