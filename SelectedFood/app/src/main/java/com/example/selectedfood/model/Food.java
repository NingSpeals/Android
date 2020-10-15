package com.example.selectedfood.model;

public class Food {
    private String name;
    private double price;
    private int picID;
    private boolean isHot;
    private boolean isSeaFood;
    private boolean isSour;

    // 构造方法
    public Food(String name, double price, int picID, boolean isHot, boolean isSeaFood, boolean isSour) {
        this.name = name;
        this.price = price;
        this.picID = picID;
        this.isHot = isHot;
        this.isSeaFood = isSeaFood;
        this.isSour = isSour;
    }

    public boolean isSeaFood() {
        return isSeaFood;
    }

    public void setSeaFood(boolean seaFood) {
        isSeaFood = seaFood;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isSour() {
        return isSour;
    }

    public void setSour(boolean sour) {
        isSour = sour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPicID() {
        return picID;
    }

    public void setPicID(int picID) {
        this.picID = picID;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", picID=" + picID +
                ", isHot=" + isHot +
                ", isSeaFood=" + isSeaFood +
                ", isSour=" + isSour +
                '}';
    }
}
