package com.server;

import com.Product;
import com.StoreInterface;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerStoreController extends UnicastRemoteObject implements StoreInterface {

    //public static final String MESSAGE = "Hello World";
    InventoryManager im;
    ArrayList<Product> inventory = new ArrayList<Product>();

    public ServerStoreController() throws RemoteException {

        super(0);

        //Create Model for Inventory Manipulation
        InventoryManager im = new InventoryManager();
        this.im = im;

    }

    public String Test(Product p) {

        return p.getName();

    }

    //Browse Command - User
    public ArrayList<Product> getInventory() {

        return inventory;

    }

    //Purchase Command - User
    public String Purchase(String name) {

        inventory = im.Purchase(name, inventory);
        String purchaseMessage = ("You have purchased: " + name);
        return purchaseMessage;

    }

    //Update Command - Admin
    public void Update(String name, double newPrice) {

        inventory = im.Update(name, newPrice, inventory);

    }

    //Add Command - Admin
    public void Add(Product p) {

        System.out.println("Test Add");
        im.Add(p, inventory);

    }

    //Remove Command - Admin
    public void Remove(String name) {

        inventory = im.Remove(name, inventory);

    }

    public static void main(String args[]) throws Exception {

        System.out.println("RMI server started");

        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("Java RMI registry created.");
        } catch (RemoteException e) {
            System.out.println("Java RMI Registry already exists.");
        }

        ServerStoreController sc = new ServerStoreController();

        Naming.rebind("//localhost/Server", sc);
        System.out.println("Bound in Registry");


    }

}
