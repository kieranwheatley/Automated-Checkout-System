package com.Controller;

import com.Model.Product;
import com.Model.StockDatabase;
import com.View.AdminLogin;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class AdminPanelController
{
    public void checkStockLevels(DefaultListModel<String> defaultListModel)
    {
        defaultListModel.clear();
        for (int product = 0; product < StockDatabase.getInstance().stock.size(); product++)
        {
            if (StockDatabase.getInstance().stock.get(product).getStockLevel() <= StockDatabase.getInstance().stock.get(product).getMinimumOrderLevel())
            {
                defaultListModel.add(product, StockDatabase.getInstance().stock.get(product).getName());
            }
            else
            {
                break;
            }
        }
        if(!defaultListModel.isEmpty())
        {
            JOptionPane.showMessageDialog(AdminLogin.getFrames()[0], defaultListModel, "Low stock levels! Please re-order.", JOptionPane.PLAIN_MESSAGE);
        }

    }
    public void removeItem(int index)
    {
        StockDatabase.getInstance().stock.remove(index);

    }
    public void loadProductsToEdit(JComboBox comboBox)
    {
        for(int i = 0; i < StockDatabase.getInstance().stock.size(); i++)
        {
            comboBox.addItem(StockDatabase.getInstance().stock.get(i).getName());
        }

    }
    public void applyProductEdit(JTextField[] allTextFields, int index)
    {
        String inputName = allTextFields[0].getText();
        double costPrice = Double.parseDouble(allTextFields[1].getText());
        double customerPrice = Double.parseDouble(allTextFields[2].getText());
        int stockNum = Integer.parseInt(allTextFields[3].getText());
        int minStock = Integer.parseInt(allTextFields[4].getText());
        int prodCode = Integer.parseInt(allTextFields[5].getText());

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
    public void addProduct(JTextField[] allTextFields)
    {
        String name = allTextFields[0].getText();
        double buyPrice = Double.parseDouble(allTextFields[1].getText());
        double salePrice = Double.parseDouble(allTextFields[2].getText());
        int stockLevel = Integer.parseInt(allTextFields[3].getText());
        int minimumStockLevel = Integer.parseInt(allTextFields[4].getText());
        int productCode = Integer.parseInt(allTextFields[5].getText());
        ArrayList<Product> barcodes = new ArrayList<>();
        Product newProduct = new Product(name, buyPrice, salePrice, stockLevel, minimumStockLevel, productCode, barcodes);
        for (int i = 0; i <= stockLevel; i++)
        {
            productCode = productCode + 1;
            Product individualProduct = new Product(name, buyPrice, salePrice, stockLevel, minimumStockLevel, productCode);
            ArrayList<Product> temp = new ArrayList<Product>();
            temp = newProduct.getBarcodes();
            temp.add(individualProduct);
            individualProduct.setBarcodes(temp);
        }
        StockDatabase.getInstance().stock.add(newProduct);
    }
}
