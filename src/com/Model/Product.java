package com.Model;
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
    private ArrayList<Product> barcodes;
    //By containing a list of it's own objects (the main product holding a list of individual objects that represent one unit of stock each),
    //the composite pattern is implemented as the group of objects (the one specific product i.e. apple) are all treated the same
    //DecimalFormat to ensure it prints correctly
    DecimalFormat pound = new DecimalFormat("#0.00");
    //Constructor for the base product type, has the ArrayList for storing each individual object of Stock for this product
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
    //This constructor is for an individual item of stock of the Product it is stored within.
    //E.g. these would be the individual tomatoes I have and they're held within the Tomato product type
    public Product(String name, double buyPrice, double salePrice, int stockLevel, int minimumOrderLevel, int productCode)
    {
        this.name = name;
        this.buyPrice = buyPrice;
        this.salePrice = salePrice;
        this.stockLevel = stockLevel;
        this.minimumOrderLevel = minimumOrderLevel;
        this.productCode = productCode;
    }
    // Getters/Setters
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
    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }
    public ArrayList<Product> getBarcodes() {
        return barcodes;
    }
    public void setBarcodes(ArrayList<Product> barcodes) {
        this.barcodes = barcodes;
    }
    //Generates a string of Available stock information (The Products name and price) Used for the till view display
    public String availableStockInfo()
    {
        return (name + " | Price: £" + pound.format(salePrice) + " | Available stock: " + stockLevel);
    }
    //Generates a string of the product in the basket (Name and Price) used for till view basket display
    public String inBasket()
    {
        return (name + " | Price £" + pound.format(salePrice));
    }
}
