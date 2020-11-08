package com.client;

import com.Product;

import java.util.ArrayList;

public class ViewManager {

    ViewManager() {

    }

    public void ListProducts(ArrayList<Product> inventory) {

        System.out.println("CURRENT SELECTION: ");
        for (int i = 0; i < inventory.size(); i++) {

            System.out.println("(" + (i + 1) + ") " + inventory.get(i).getName() + " --- " + inventory.get(i).getPrice() + " --- Current Stock: " + inventory.get(i).getStock());

        }

        System.out.println("(E) Exit");
    }
}
