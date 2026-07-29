package com.example.chattbank;

import java.util.ArrayList;

public class AccountList {

    private ArrayList<Account> accounts;
    private int count;

    public AccountList() {
        accounts = new ArrayList<>();
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void add(Account a1) {
        accounts.add(a1);
        count++;
    }

    public Account get(int index) {
        return accounts.get(index);
    }

    public void display() {
        System.out.println("AccountList (count = " + count + "):");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("---- Account " + (i + 1) + " ----");
            accounts.get(i).display();
        }
    }
}