package com.autobots.java.bankApp;

import java.net.IDN;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankProApp {
    static Scanner scanner = new Scanner(System.in);
    private static final Map<String, Client> clients = new HashMap<>();

    public static void main(String[] args) {


        Client asan = new Client("Asan Uson", "123");

        DepositAccount asanDepositAccount = new DepositAccount(asan, Currency.USD);
        CreditAccount asanCreditAccount = new CreditAccount(asan, Currency.EUR);

        asan.addAccount(asanDepositAccount);
        asan.addAccount(asanCreditAccount);
        System.out.println(asan.getClientID());

        clients.put(asan.getClientID(), asan);

        System.out.println("======Welcome to MBank=======");
        System.out.print(" Please enter client ID: ");
        String clientID = scanner.nextLine();
        Client client = clients.get(clientID);
        if (client == null) {
            System.out.println("Client not found.");
            return;
        }
        System.out.print("Enter PIN: ");
        String pinCode = scanner.nextLine();
        if (!client.authenticate(pinCode)) {
            System.out.println("Yuo entered wrong pin code! ");
            return;
        }
        System.out.println(client.getFullname() + " welcome to MBank");

        while (true) {
            System.out.println("1. Посмотреть счета");
            System.out.println("2. Перевести между счетами");
            System.out.println("3. Показать чек");
            System.out.println("0. Выход из системы");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    for (BankAccount bankAccount : client.getAccounts()) {
                        System.out.printf("%s | %s | Баланс: %.2f %s\n",
                                bankAccount.getClass().getSimpleName(),
                                bankAccount.getAccountNumber(),
                                bankAccount.getBalance(),
                                bankAccount.getCurrency());
                    }
                    break;
                case "2":
                    System.out.println("Введите номер счета отправителя ");
                    String fromID = scanner.nextLine();
                    System.out.println("Введите номер счета получателя ");
                    String toID = scanner.nextLine();
                    System.out.println("Введите сумму перевода: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    BankAccount fromAccount = findAccount(fromID);
                    BankAccount toAccount = findAccount(toID);
                    if (fromAccount != null && toAccount != null) {
                        boolean result = BankService.transfer(fromAccount, toAccount, amount);
                        System.out.println(result ? "Операция прошла успешно" : "Ошибка перевода");
                    } else {
                        System.out.println("Счет не найден");
                    }
                    break;
                case "3":
                    for (BankAccount bankAccount : client.getAccounts()) {
                        System.out.println("\n == чек по счету " + bankAccount.getAccountNumber());
                        for (Transaction transaction : bankAccount.getTransactions()) {
                            System.out.println(transaction);
                        }

                    }
                    break;
                case "0":
                    System.out.println("Выход из системы");
                    return;

                default:
                    System.out.println("Неверный выбор");
            }
        }


    }

    private static BankAccount findAccount(String accountNumber) {
        for (Client client : clients.values()) {
            for (BankAccount bankAccount : client.getAccounts()) {
                if (bankAccount.getAccountNumber().equals(accountNumber)) {
                    return bankAccount;
                }
            }
        }
        return null;
    }

}
