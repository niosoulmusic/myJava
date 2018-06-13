package com.riccio.test;

public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;
    public static final int CHECKING = 1;
    public static final int SAVINGS = 1;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }

    //The branch arguemnt is true if the customer is performing the transaction at a branch , with a teller.
    //it is false if the customer is performing the transaction on ATM
    public double deposit(double amount,boolean branch){
        balance +=amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch){
        balance -=amount;
        if ((amount > 500.00) & !branch) {
            throw new IllegalArgumentException();
        }
        return balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking() {
        return accountType== CHECKING;
    }
}
