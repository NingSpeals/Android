package com.example.borrowbooks.model;

public class Book {
   private String name;
   private String type;
   private int age;
   private String time;
   private int picID;
   private boolean isHistory;
   private boolean isMystery;
   private boolean isLiterary;

    public Book(String name, String type, int age, int picID, boolean isHistory, boolean isMystery, boolean isLiterary, String time) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.picID = picID;
        this.isHistory = isHistory;
        this.isMystery = isMystery;
        this.isLiterary = isLiterary;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPicID() {
        return picID;
    }

    public void setPicID(int picID) {
        this.picID = picID;
    }

    public boolean isHistory() {
        return isHistory;
    }

    public void setHistory(boolean history) {
        isHistory = history;
    }

    public boolean isMystery() {
        return isMystery;
    }

    public void setMystery(boolean mystery) {
        isMystery = mystery;
    }

    public boolean isLiterary() {
        return isLiterary;
    }

    public void setLiterary(boolean literary) {
        isLiterary = literary;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
