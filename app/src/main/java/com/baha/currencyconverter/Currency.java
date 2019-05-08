package com.baha.currencyconverter;

public class Currency {
    private String name;
    private int image;
    private double price;

    public Currency(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Currency(String name, double price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
