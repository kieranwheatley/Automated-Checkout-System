package com.Model;


public class Product
{
    private String name;

    private double buyPrice;

    private double salePrice;

    private int stockLevel;

    private int minimumOrderLevel;

    private int productCode;

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

    public void setProductCode(int productCode) {
        this.productCode = productCode;
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
