package com.company.TShirtController;

public class TShirt {
    private int id;
    private String color;
    private int stockCount;
    private  boolean isAvailable;

    // Empty Constructor 2
    public TShirt(){}

    // Constructor 1
    public TShirt(int id, String color, int stockCount, boolean isAvailable){
        this.id=id;
        this.color=color;
        this.stockCount = stockCount;
        this.isAvailable = isAvailable;
    }

    // setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
