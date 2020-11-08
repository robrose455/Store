package com.client;

import com.Product;
import com.StoreInterface;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientStoreController implements Serializable {

    boolean keepGoing = true;
    boolean isLoggedIn = false;
    Scanner scanner = new Scanner(System.in);

    //Controller Tracks Inventory and Processes Commands
    //Rmi Server Class
    //StoreController s = new StoreController();

    StoreInterface sc = (StoreInterface)Naming.lookup("//localhost/Server");

    LoginManager lm = new LoginManager();
    ViewManager vm = new ViewManager();

    //Testing Block
    Product b = new Product("Bananas",1.99,10);
    Product a = new Product("Apples",2.99,3);
    Product o = new Product("Oranges",3.09,18);

    String user = "NULL";

    public ClientStoreController() throws RemoteException, MalformedURLException, NotBoundException {

    }

    public void Init() throws RemoteException {

        while(keepGoing) {

            while (!isLoggedIn) {

                System.out.println("Welcome, please login or register...");

                System.out.println("(1) Login");
                System.out.println("(2) Register");
                System.out.println("(3) Exit");

                System.out.println("(A) TESTING ONLY: Bypass Login (Default User)");
                System.out.println("(B) TESTING ONLY: Bypass Login (Default Admin)");

                String input = scanner.nextLine();

                if (input.equals("1")) {

                    //Login
                    user = lm.Login();

                    //Check to see if logged in as either user or admin if not, try again
                    if (user.equals("user") || user.equals("admin")) {
                        isLoggedIn = true;
                    }

                } else if (input.equals("2")) {

                    //Register
                    boolean loop = true;

                    while (loop) {

                        System.out.println("Register as (A)dmin or (U)ser: ");
                        String registerSelection = scanner.nextLine();

                        if (registerSelection.equals("A")) {

                            lm.RegisterAdminAccount();
                            loop = false;

                        } else if (registerSelection.equals("U")) {

                            lm.RegisterUserAccount();
                            loop = false;

                        } else {
                            System.out.println("Invalid Selection");
                        }
                    }

                } else if (input.equals("3")) {

                    //Exit
                    keepGoing = false;
                    break;

                } else if (input.equals("A")) {

                    //Bypass Login as User
                    isLoggedIn = true;
                    user = "user";

                } else if (input.equals("B")) {

                    //Bypass Login as Admin
                    isLoggedIn = true;
                    user = "admin";

                } else {
                    System.out.println("Invalid Selection, Try Again");
                }
            }

            if (user.equals("user")) {

                ArrayList<Product> inventory = sc.getInventory();
                int selection = Shop(inventory);
                if (selection != -1) {

                    Product p = inventory.get(selection - 1);
                    String pm = sc.Purchase(p.getName());
                    System.out.println(pm);

                } else {

                    keepGoing = false;
                }

            } else if (user.equals("admin")) {

                System.out.println("Admin Panel:");
                System.out.println("(1) Add Product");
                System.out.println("(2) Remove Product");
                System.out.println("(3) Update Product");
                System.out.println("(4) Exit");
                System.out.println("(5) Logout");

                String adminInput = scanner.nextLine();

                if (adminInput.equals("1")) {

                    String name;
                    double price;
                    int stock;

                    System.out.println("Name of Product: ");
                    name = scanner.nextLine();

                    System.out.println("Price of Product: ");
                    String priceStr = scanner.nextLine();
                    price = Double.parseDouble(priceStr);

                    System.out.println("Quantity of Product: ");
                    String stockStr = scanner.nextLine();
                    stock = Integer.parseInt(stockStr);

                    Product p = new Product(name,price,stock);
                    sc.Add(p);
                    //Add Product

                } else if (adminInput.equals("2")) {

                    //Remove Product
                    System.out.println("Name of Product to be Removed: ");
                    String name = scanner.nextLine();

                    sc.Remove(name);

                } else if (adminInput.equals("3")) {

                    //Update Product
                    System.out.println("Name of Product to be Updated: ");
                    String name = scanner.nextLine();

                    System.out.println("New Price of '" + name + "'");
                    String priceStr = scanner.nextLine();
                    double price = Double.parseDouble(priceStr);

                    sc.Update(name,price);

                } else if (adminInput.equals("4")) {

                    keepGoing = false;
                    break;

                } else if (adminInput.equals("5")) {

                    isLoggedIn = false;

                } else {

                    System.out.println("Invalid Selection, Try Again");
                }

            } else {

            }
        }
    }

    public int Shop(ArrayList<Product> inventory) {

        vm.ListProducts(inventory);
        int selectionNum;
        String selection = scanner.nextLine();

        if (selection.equals("E")) {

            selectionNum = -1;

        } else {

            selectionNum = Integer.parseInt(selection);

        }

        return selectionNum;

    }
}

