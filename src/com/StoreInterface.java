package com;

import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface StoreInterface extends Remote {

    String Test(Product p) throws RemoteException;

    ArrayList<Product> getInventory() throws RemoteException;

    String Purchase(String name) throws RemoteException;

    void Update(String name, double newPrice) throws RemoteException;

    void Remove(String name) throws RemoteException;

    void Add(Product p) throws RemoteException;

}
