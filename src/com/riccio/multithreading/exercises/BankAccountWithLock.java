package com.riccio.multithreading.exercises;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountWithLock {

    private String name;
    private double balance;
    private Lock opLock;

    public BankAccountWithLock(String name) {
        this.name = name;
        this.balance = 1000.00d;
        this.opLock = new ReentrantLock();
    }

    public double getBalance() {
        return balance;
    }

    public void performOperation(String personName, double operation) {
        boolean status = false;
            try {
                if (opLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    try {
                        if (operation < 0) {
                            System.out.format("%s is withdrawing %.2f from account\n", personName, Math.abs(operation));
                        } else {
                            System.out.format("%s is depositing %.2f into the account\n", personName, Math.abs(operation));
                        }
                        balance += operation;
                        status=true;
                        System.out.format("new balance is :%.2f \n", balance);
                        System.out.println("status is : "+status);
                    } finally {
                        opLock.unlock();
                    }
                }else{
                    System.out.println(personName+ " : could not get the lock");
                }
            } catch (InterruptedException e) {}
    }


    public static void main(String[] args) {
        BankAccountWithLock jointBankAccount = new BankAccountWithLock("riccio");
        Person p1 = new Person("eugenio riccio", jointBankAccount);
        Person p2 = new Person("nome cognome", jointBankAccount);
        new Thread(new Runnable() {
            @Override
            public void run() {
                p1.getBankAccount().performOperation(p1.getName(), 1000d);
                p1.getBankAccount().performOperation(p1.getName(), -300d);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                p2.getBankAccount().performOperation(p2.getName(), 203.75d);
                p2.getBankAccount().performOperation(p2.getName(), -100d);
            }
        }).start();
    }
}

class Person {
    private String name;
    private BankAccountWithLock bankAccount;

    public Person(String name, BankAccountWithLock bankAccount) {
        this.name = name;
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public BankAccountWithLock getBankAccount() {
        return bankAccount;
    }
}

