package com.server;

import com.Product;

import java.util.ArrayList;

public class InventoryManager {

    public InventoryManager() {


    }

    public ArrayList<Product> Add(Product p, ArrayList<Product> inventory) {

        inventory.add(p);

        return inventory;


    }

    public ArrayList<Product> Remove(String name, ArrayList<Product> inventory) {

        for (int i = 0; i < inventory.size(); i++){
            if (inventory.get(i).getName().equals(name)) {
                inventory.remove(i);
            }
        }

        return inventory;


    }

    public ArrayList<Product> Purchase(String name, ArrayList<Product> inventory) {

        for (int i = 0; i < inventory.size(); i++){
            if (inventory.get(i).getName().equals(name)) {
                inventory.get(i).removeStock();
            }
        }

        return inventory;
    }

    public ArrayList<Product> Update(String name, double newPrice, ArrayList<Product> inventory) {

        for (int i = 0; i < inventory.size(); i++){
            if (inventory.get(i).getName().equals(name)) {
                inventory.get(i).setPrice(newPrice);
            }
        }
        return inventory;

    }
}
