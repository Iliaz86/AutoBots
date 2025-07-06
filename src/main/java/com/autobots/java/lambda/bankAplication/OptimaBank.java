package com.autobots.java.lambda.bankAplication;

public class OptimaBank extends BankBase {
    private double balance = 0;

    public OptimaBank(long accountNumber, long routingNumber) throws Exception {
        super(accountNumber, routingNumber);
        addAllBankRecords(this);
    }


    @Override
    public double getBalance() {
        return balance;
    }


    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount >= 300000) {
            throw new IllegalArgumentException("Invalid amount can not be deposit");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0 || amount > 250000) {
            throw new IllegalArgumentException("Invalid amount can not be withdraw");
        } else {
            if (balance < amount) {
                throw new IllegalArgumentException("Insufficient balance");
            } else {
                balance -= amount;
            }
        }
    }
}
