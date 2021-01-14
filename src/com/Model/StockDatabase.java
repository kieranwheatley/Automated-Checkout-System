package com.Model;
import java.util.ArrayList;
import java.util.List;

//Stock database used for storing all products. Singleton has been implemented here to ensure only one instance of the stock exists.
//This means that multiple users will only access this one database and stock will always be accurate
public final class StockDatabase
{
    private static StockDatabase INSTANCE = null;
    public final List<Product> stock = new ArrayList<Product>();

    public static StockDatabase getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new StockDatabase();
        }
        return INSTANCE;
    }
}
