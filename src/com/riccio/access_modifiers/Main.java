package com.riccio.access_modifiers;

public class Main {

    public static void main(String[] args) {

        Account gegeAccount = new Account("gege");
        gegeAccount.deposit(1000);
        gegeAccount.withdraw(100);
        gegeAccount.withdraw(-100);
        gegeAccount.deposit(200);
        gegeAccount.withdraw(100);
        gegeAccount.calculateBalance();
        System.out.println("Balance on "+gegeAccount.getAccountName()+"'s bank account is : "+gegeAccount.getBalance());
    }
}
