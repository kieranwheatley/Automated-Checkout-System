package com.Model;


import java.util.ArrayList;

public class Product
{
    private String name;

    private double buyPrice;

    private double salePrice;

    private int stockLevel;

    private int minimumOrderLevel;

    private int productCode;

    private ArrayList<Integer> barcodes;

    public Product(String name, double buyPrice, double salePrice, int stockLevel, int minimumOrderLevel, int productCode, ArrayList<Integer> barcodes)
    {
        this.name = name;
        this.buyPrice = buyPrice;
        this.salePrice = salePrice;
        this.stockLevel = stockLevel;
        this.minimumOrderLevel = minimumOrderLevel;
        this.productCode = productCode;
        this.barcodes = barcodes;
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

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public ArrayList<Integer> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(ArrayList<Integer> barcodes) {
        this.barcodes = barcodes;
    }

    public String availableStockInfo()
    {
        String available = (name + " | Price: £" + salePrice + " | Available stock: " + stockLevel);
        return available;
    }
    public String inBasket()
    {
        String inBasket = (name + " | Price £" + salePrice);
        return inBasket;
    }

}
