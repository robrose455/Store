package com.client;

import java.util.ArrayList;

public class SimpleDB {

    ArrayList<String> userUserList = new ArrayList<String>();
    ArrayList<String> userPassList = new ArrayList<String>();

    ArrayList<String> adminUserList = new ArrayList<String>();
    ArrayList<String> adminPassList = new ArrayList<String>();

    public SimpleDB() {

    }

    public ArrayList<String> getAdminUser() {
        return adminUserList;
    }

    public ArrayList<String> getAdminPass() {
        return adminPassList;
    }

    public ArrayList<String> getUserUser() {
        return userUserList;
    }

    public ArrayList<String> getUserPass() {
        return userPassList;
    }

    public void AddUser(String u, String p) {

        userUserList.add(u);
        userPassList.add(p);

    }

    public void AddAdmin(String u, String p) {

        adminUserList.add(u);
        adminPassList.add(p);

    }
}
