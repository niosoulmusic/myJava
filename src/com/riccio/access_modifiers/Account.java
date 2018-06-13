package com.riccio.access_modifiers;

import java.util.ArrayList;

public class Account {
    private String accountName;
    private int balance=0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions=new ArrayList<Integer>();
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void deposit(int amount){
        if (amount>0){
            transactions.add(amount);
            this.balance+=amount;
            System.out.println("recorded a deposit transaction with amount $ "+ amount);
        }else{
            System.out.println("cannot deposit negative amount");
        }
    }
    public void withdraw(int amount){
        int withdrawal= -amount;
        if (withdrawal<0){
            this.transactions.add(withdrawal);
            this.balance+=withdrawal;
            System.out.println("recorded a withdrawal transaction with amount $ "+amount);
        }else{
            System.out.println("cannot withdrawal a negative sum");
        }
    }
    public void calculateBalance(){
         this.balance=0;
         for (int transaction: transactions){
             this.balance+=transaction;
         }
    }
}
