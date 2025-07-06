package com.autobots.java.bankApp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private final String fullname;
    private final String clientID;
    private final String pin;
    private final List<BankAccount> accounts = new ArrayList<>();

    public Client(String fullname, String pin) {
        this.fullname = fullname;
        this.pin = pin;
        this.clientID = String.valueOf(UUID.randomUUID());
    }

    public boolean authenticate(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }
    public String getFullname() {
        return fullname;
    }

    public String getClientID() {
        return clientID;
    }


    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
