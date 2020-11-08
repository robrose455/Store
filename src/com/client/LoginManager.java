package com.client;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginManager {

    SimpleDB db = new SimpleDB();
    Scanner scanner = new Scanner(System.in);

    LoginManager() {

    }

    public void RegisterUserAccount() {

        System.out.println("REGISTER NEW ACCOUNT");
        System.out.println("NEW ACCOUNT USERNAME: ");
        String inputUser = scanner.nextLine();

        System.out.println("NEW ACCOUNT PASSWORD: ");
        String inputPass = scanner.nextLine();

        db.AddUser(inputUser,inputPass);
        System.out.println("Account Registered");


    }

    public void RegisterAdminAccount() {

        System.out.println("REGISTER NEW ACCOUNT");
        System.out.println("NEW ACCOUNT USERNAME: ");
        String inputUser = scanner.nextLine();

        System.out.println("NEW ACCOUNT PASSWORD: ");
        String inputPass = scanner.nextLine();

        db.AddAdmin(inputUser,inputPass);
        System.out.println("Account Registered");

    }

    public String Login() {

        System.out.println("Please Enter Username: ");
        String inputUser = scanner.nextLine();

        System.out.println("Please Enter Password: ");
        String inputPass = scanner.nextLine();

        String userType = CheckUserAndPass(inputUser,inputPass);

        if(userType.equals("user")) {

            System.out.println(inputUser + " is now logged in");

        } else if (userType.equals("admin")) {

            System.out.println(inputUser + " is now logged in");

        } else {

            System.out.println("Username or Password is incorrect");

        }

        return userType;

    }

    public String CheckUserAndPass(String u, String p) {

        String userType = "NULL";

        ArrayList<String> userUserList = db.getUserUser();
        ArrayList<String> userPassList = db.getUserPass();

        ArrayList<String> adminUserList = db.getAdminUser();
        ArrayList<String> adminPassList = db.getAdminPass();

        int userIndex = -1;
        int passIndex = -1;

        if (userUserList.contains(u) && userPassList.contains(p)) {

            userIndex = userUserList.indexOf(u);
            passIndex = userPassList.indexOf(p);

            if (userIndex == passIndex) {
                userType = "user";
            }

        } else if (adminUserList.contains(u) && adminPassList.contains(p)) {

            userIndex = adminUserList.indexOf(u);
            passIndex = adminPassList.indexOf(p);

            if (userIndex == passIndex) {
                userType = "admin";
            }

        }

        return userType;

    }
}
