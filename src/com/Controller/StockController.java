package com.Controller;
import com.Model.Product;
import com.Model.StockDatabase;
import com.Model.BasketDatabase;
import com.View.TillView;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class StockController
{
    //Method for loading in the products list from stock.txt file
    public void loadStock()
    {
        try {
            //Setting up the filepath and input stream
            File inputData = new File("src/resources/stock.txt");
            Scanner filereader = new Scanner(inputData);
            //Keep running until the file is empty
            while (filereader.hasNextLine()) {
                //Read each line in and assign them to a variables
                String name = filereader.nextLine();
                double buyPrice = Double.parseDouble(filereader.nextLine());
                double salePrice = Double.parseDouble(filereader.nextLine());
                int stockLevel = Integer.parseInt(filereader.nextLine());
                int minimumOrderLevel = Integer.parseInt(filereader.nextLine());
                int productCode = Integer.parseInt(filereader.nextLine());
                int barcode;
                ArrayList<Integer> barcodes = new ArrayList<Integer>();
                //Create a barcode for EACH of the product in stock. Take the product code and add it's index to create a unique barcode for individual products.
                for (int codes = 1; codes <= stockLevel; codes++)
                {
                    barcode = productCode + codes;
                    barcodes.add(barcode);
                }
                //Once all data for a product is read in and barcodes are generated, create a Product object
                Product tempProduct = new Product(name, buyPrice, salePrice, stockLevel, minimumOrderLevel, productCode, barcodes);
                //Add the newly created Product object to the Stock Database for access within the till
                StockDatabase.getInstance().stock.add(tempProduct);
            }
            //Close the filereader once all items have been read in (to prevent problems)
            filereader.close();
        }
        //Catch the file not being found.
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(TillView.getFrames()[0], "Error: Stock cannot be loaded in. Please seek assistance.", "Error: File Exception.", JOptionPane.ERROR_MESSAGE);
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //Displaying the product available on the TillView form for manual selection of items.
    public void displayStock(DefaultListModel<String> defaultListModel, JList jList) {
        defaultListModel.clear();
        for (int i = 0; i < StockDatabase.getInstance().stock.size(); i++)
        {
            defaultListModel.add(i, StockDatabase.getInstance().stock.get(i).availableStockInfo());
        }
        jList.setModel(defaultListModel);
    }
    //Displaying the products in the basket before checking out
    public void displayBasket(DefaultListModel<String> defaultListModel, JList jList)
    {
        defaultListModel.clear();
        for (int i = 0; i < BasketDatabase.getInstance().basket.size(); i++) {
            defaultListModel.add(i, BasketDatabase.getInstance().basket.get(i).inBasket());
        }

        jList.setModel(defaultListModel);
    }
    //Add the selected item manually to the basket
    public void addProductToBasket(Integer item)
    {
        if (StockDatabase.getInstance().stock.get(item).getStockLevel() > 0)
        {
            BasketDatabase.getInstance().basket.add(StockDatabase.getInstance().stock.get(item));
            BasketDatabase.getInstance().basket.remove(item);
            BasketDatabase.getInstance().basket.get(item).setStockLevel(BasketDatabase.getInstance().basket.get(item).getStockLevel() - 1);
        }
        else
            {
            JOptionPane.showMessageDialog(TillView.getFrames()[0], "This item is unavailable and cannot be added to the order.");
        }
    }
    //Generate the prices for the basket
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
