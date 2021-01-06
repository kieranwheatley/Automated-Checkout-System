package com.Model;


import sun.dc.pr.PRError;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product
{
    private String name;

    private double buyPrice;

    private double salePrice;

    private int stockLevel;

    private int minimumOrderLevel;

    private int productCode;

    //By containing a list of it's own objects (the main product holding a list of individual objects that represent one unit of stock each),
    //the composite pattern is implemented as the group of objects (the one specific product i.e. apple) are all treated the same
    private ArrayList<Product> barcodes;
    DecimalFormat pound = new DecimalFormat("#0.00");

    public Product(String name, double buyPrice, double salePrice, int stockLevel, int minimumOrderLevel, int productCode, ArrayList<Product> barcodes)
    {
        this.name = name;
        this.buyPrice = buyPrice;
        this.salePrice = salePrice;
        this.stockLevel = stockLevel;
        this.minimumOrderLevel = minimumOrderLevel;
        this.productCode = productCode;
        this.barcodes = barcodes;
    }
    public Product(String name, double buyPrice, double salePrice, int stockLevel, int minimumOrderLevel, int productCode)
    {
        this.name = name;
        this.buyPrice = buyPrice;
        this.salePrice = salePrice;
        this.stockLevel = stockLevel;
        this.minimumOrderLevel = minimumOrderLevel;
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public int getMinimumOrderLevel() {
        return minimumOrderLevel;
    }

    public void setMinimumOrderLevel(int minimumOrderLevel) {
        this.minimumOrderLevel = minimumOrderLevel;
    }

    public int getProductCode() {
        return productCode;
    }

    public Product getProduct()
    {
        return this;
    }

    public void addProduct(Product adding)
    {
        barcodes.add(adding);
    }
    public void removeProduct(Product removing)
    {
        barcodes.remove(removing);
    }
    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public ArrayList<Product> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(ArrayList<Product> barcodes) {
        this.barcodes = barcodes;
    }

    public String availableStockInfo()
    {
        String available = (name + " | Price: £" + pound.format(salePrice) + " | Available stock: " + stockLevel);
        return available;
    }
    public String inBasket()
    {
        String inBasket = (name + " | Price £" + pound.format(salePrice));
        return inBasket;
    }


    public void setBarcodes() {
    }
}
