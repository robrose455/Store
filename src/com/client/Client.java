package com.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import static java.lang.System.exit;

public class Client {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {


        ClientStoreController ssc = new ClientStoreController();
        ssc.Init();

        System.out.println("Thank you come again!");
        exit(0);
    }
}
