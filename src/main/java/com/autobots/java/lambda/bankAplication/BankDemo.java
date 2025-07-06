package com.autobots.java.lambda.bankAplication;

public class BankDemo {
    public static void main(String[] args) throws Exception {

        MBank iliazMBank = new MBank(123456789111L, 123456789);
        iliazMBank.deposit(100000);

        OptimaBank emirOptimaBank = new OptimaBank(123456789112L, 123456779);
        Bank.transferFunds(iliazMBank, emirOptimaBank, 1000);

        DemirBank mirgulDemirBank = new DemirBank(123456789113L, 124456789);
        System.out.println(mirgulDemirBank.getBalance());

        BankBase.allBankRecords.stream().filter(bank -> bank.getBalance() > 100).forEach(System.out::println);

        double allSumofBanks = BankBase.allBankRecords.stream().mapToDouble(BankBase::getBalance).sum();
        System.out.println(allSumofBanks);
    }
}
