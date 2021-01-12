package com.Controller;
import com.Model.Product;
import com.Model.StockDatabase;
import com.Model.BasketDatabase;
import com.View.TillView;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StockController
{
    public AudioController audioController;
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
                ArrayList<Product> barcodes = new ArrayList<Product>();
                //Create a temporary product class, this is the MAIN object
                Product tempProduct = new Product(name, buyPrice, salePrice, stockLevel, minimumOrderLevel, productCode, barcodes);
                //Create a barcode for EACH of the product in stock. Take the product code and add it's index to create a unique barcode for individual products.
                for (int i = 1; i <= stockLevel; i++)
                {
                    //For each item of stock we have for this product, set the product code to increase by one
                    productCode = productCode + i;
                    //Then create another object, which will have a unique product code
                    Product individualProducts = new Product(name, buyPrice, salePrice, stockLevel, minimumOrderLevel, productCode);
                    //Store this in a new temporary ArrayList
                    ArrayList<Product> temp = new ArrayList<Product>();
                    //Get the initial object's ArrayList and copy into the temp ArrayList
                    temp = tempProduct.getBarcodes();
                    //Add the new individual item to the ArrayList
                    temp.add(individualProducts);
                    //Set the initial objects ArrayList to the temp one, which now contains the extra item
                    tempProduct.setBarcodes(temp);
                }
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
    public void saveStock()
    {
        try{
            //Setting up the filepath and input stream
            File outputData = new File("src/resources/stock.txt");
            PrintWriter dataWriter = new PrintWriter(outputData);
            for (Product product: StockDatabase.getInstance().stock) {
                dataWriter.println(product.getName());
                dataWriter.println(String.valueOf(product.getBuyPrice()));
                dataWriter.println(String.valueOf(product.getSalePrice()));
                dataWriter.println(String.valueOf(product.getStockLevel()));
                dataWriter.println(String.valueOf(product.getMinimumOrderLevel()));
                dataWriter.println(String.valueOf(product.getProductCode()));
            }
            dataWriter.close();
        } catch (FileNotFoundException e){
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
    public void displayLowStock(DefaultListModel<String> lowStockList, JList stockView)
    {
        int lowItemAmount = 0;
        lowStockList.clear();
        for (Product product : StockDatabase.getInstance().stock) {
            if (product.getStockLevel() < product.getMinimumOrderLevel())
            {
                lowStockList.add(lowStockList.size(), "Product: " + product.getName() + " | Stock Remaining: " + product.getStockLevel() );
            }
        }
        stockView.setModel(lowStockList);
    }
    //Add the selected item manually to the basket
    public void addProductToBasket(Integer item){
        if (StockDatabase.getInstance().stock.get(item).getStockLevel() > 0)
        {
            audioController = new AudioController();
            audioController.barcodeBeep();
            // !--- NEED TO CHANGE THIS - DO NOT REMOVE FROM DATABASE UNTIL PURCHASED ---!
            //!!______ NEED TO CHANGE, TAKE ITEM FROM BARCODE ARRAYLIST, NOT PRODUCT DATABASE!!!_________!!
            int lastIndex = StockDatabase.getInstance().stock.get(item).getStockLevel() - 1;
            ArrayList<Product> temp = StockDatabase.getInstance().stock.get(item).getBarcodes();
            Product tempProduct = temp.get(lastIndex);
            temp.remove(item);
            StockDatabase.getInstance().stock.get(item).setBarcodes(temp);
            BasketDatabase.getInstance().basket.add(tempProduct);
            StockDatabase.getInstance().stock.get(item).setStockLevel(lastIndex);

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
        DecimalFormat pound = new DecimalFormat("#0.00");
        for (int item = 0; item < BasketDatabase.getInstance().basket.size(); item++)
        {
            itemPrice = BasketDatabase.getInstance().basket.get(item).getSalePrice();
            totalPrice += Double.parseDouble(pound.format(itemPrice));
        }
        BasketDatabase.getInstance().setTotalCost(Double.parseDouble(pound.format(totalPrice)));
    }
    public void barcodeScanner()
    {
        Random randomInt = new Random();
        int size = StockDatabase.getInstance().stock.size();
        int randomBarcode = randomInt.nextInt(size);
        addProductToBasket(randomBarcode);



    }
}
