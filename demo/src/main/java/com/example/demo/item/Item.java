package com.example.demo.item;

public abstract class Item {
    public String description;
    public int price;
    String getDescription(){
        return description;
    };
    abstract double price();
    public abstract double getPrice();
}
