package com;

import java.io.Serializable;
import java.rmi.Remote;

public class Product implements Serializable {

    String name;
    double price;
    int stock;
    private static final long serialVersionUID = 1L;

    public Product(String name, double price, int initStock) {

        this.name = name;
        this.price = price;
        this.stock = initStock;


    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    public int getStock() {
        return this.stock;
    }

    public void addStock() {
        this.stock++;
    }

    public void removeStock() {
        this.stock--;
    }

}
