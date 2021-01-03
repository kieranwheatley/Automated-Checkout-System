package com.Controller;

import com.Model.Product;
import com.Model.StockDatabase;
import com.Model.BasketDatabase;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class StockController
{
    public void loadStock()
    {
        try
        {
            File inputData = new File("src/resources/stock.txt");
            Scanner filereader = new Scanner(inputData);
            while (filereader.hasNextLine())
            {
                String name = filereader.nextLine();
                double buyPrice = Double.parseDouble(filereader.nextLine());
                double salePrice = Double.parseDouble(filereader.nextLine());
                int stockLevel = Integer.parseInt(filereader.nextLine());
                int minimumOrderLevel = Integer.parseInt(filereader.nextLine());
                int productCode = Integer.parseInt(filereader.nextLine());
                Product tempProduct = new Product(name, buyPrice, salePrice, stockLevel, minimumOrderLevel, productCode);
                StockDatabase.getInstance().stock.add(tempProduct);
            }
            filereader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void displayStock(DefaultListModel<String> defaultListModel, JList jList)
    {
        defaultListModel.clear();
        for (int i = 0; i < StockDatabase.getInstance().stock.size(); i++)
        {
            defaultListModel.add(i,StockDatabase.getInstance().stock.get(i).availableStockInfo());

            if(StockDatabase.getInstance().stock.get(i).getStockLevel() < StockDatabase.getInstance().stock.get(i).getMinimumOrderLevel())
            {
                defaultListModel.add(i,StockDatabase.getInstance().stock.get(i).availableStockInfo() + " Low stock levels. Please replenish. ");
            }
        }

        jList.setModel(defaultListModel);
    }
    public void displayBasket(DefaultListModel<String> defaultListModel, JList jList)
    {
        defaultListModel.clear();
        for (int i = 0; i < BasketDatabase.getInstance().basket.size(); i++)
        {
            defaultListModel.add(i,BasketDatabase.getInstance().basket.get(i).inBasket());
        }

        jList.setModel(defaultListModel);
    }
    public void addProductToBasket(Integer item)
    {
        BasketDatabase.getInstance().basket.add(StockDatabase.getInstance().stock.get(item));

        //Bit hesitant about this lads
        BasketDatabase.getInstance().basket.get(item).setStockLevel(item - 1);
    }
    public void priceCalculation()
    {
        double itemPrice = 0.00;
        double totalPrice = 0.00;

        DecimalFormat pound = new DecimalFormat("##.00");
        for (int item = 0; item < BasketDatabase.getInstance().basket.size(); item++)
        {
            itemPrice = BasketDatabase.getInstance().basket.get(item).getSalePrice();
            totalPrice += Double.parseDouble(pound.format(itemPrice));
        }
        BasketDatabase.getInstance().setTotalCost(Double.parseDouble(pound.format(totalPrice)));
    }
}
