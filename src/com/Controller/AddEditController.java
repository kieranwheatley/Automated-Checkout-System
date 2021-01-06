package com.Controller;

import com.Model.Product;
import com.Model.StockDatabase;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddEditController {
    public void loadProductsToEdit(JComboBox comboBox)
    {
        for(int i = 0; i < StockDatabase.getInstance().stock.size(); i++)
        {
            comboBox.addItem(StockDatabase.getInstance().stock.get(i).getName());
        }

    }
    public void applyProductEdit(JTextField name, JTextField buyPrice, JTextField salePrice, JTextField stock,  JTextField minimumStock, JTextField productCode, int index)
    {
        String inputName = name.getText();
        double costPrice = Double.parseDouble(buyPrice.getText());
        double customerPrice = Double.parseDouble(salePrice.getText());
        int stockNum = Integer.parseInt(stock.getText());
        int minStock = Integer.parseInt(minimumStock.getText());
        int prodCode = Integer.parseInt(productCode.getText());

        StockDatabase.getInstance().stock.get(index).setName(inputName);
        StockDatabase.getInstance().stock.get(index).setBuyPrice(costPrice);
        StockDatabase.getInstance().stock.get(index).setSalePrice(customerPrice);
        StockDatabase.getInstance().stock.get(index).setStockLevel(stockNum);
        StockDatabase.getInstance().stock.get(index).setMinimumOrderLevel(minStock);
        StockDatabase.getInstance().stock.get(index).setProductCode(prodCode);
        ArrayList<Product> temp;
        temp = new ArrayList<Product>();
        Product individualProducts;

        for (int i = 1; i <= stockNum; i++)
        {
            Product tempProduct = new Product(inputName, costPrice, customerPrice, stockNum, minStock, prodCode);
            //For each item of stock we have for this product, set the product code to increase by one
            prodCode += i;
            //Then create another object, which will have a unique product code
            individualProducts = new Product(inputName, costPrice, customerPrice, stockNum, minStock, prodCode);
            //Store this in a new temporary ArrayList

            //Get the initial object's ArrayList and copy into the temp ArrayList
            temp = StockDatabase.getInstance().stock.get(index).getBarcodes();
            //Add the new individual item to the ArrayList
            temp.add(individualProducts);
            //Set the initial objects ArrayList to the temp one, which now contains the extra item
            tempProduct.setBarcodes(temp);
        }
        StockDatabase.getInstance().stock.get(index).setBarcodes(temp);
    }
}
