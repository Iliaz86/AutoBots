package com.autobots.java.lambda.bankAplication;

public interface Bank {

    double getBalance();
    void deposit(double amount);
    void withdraw(double amount);

    static void transferFunds(Bank sender, Bank receiver, double amount) {
        sender.withdraw(amount);
        receiver.deposit(amount);
    }

  }


