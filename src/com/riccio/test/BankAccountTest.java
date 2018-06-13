package com.riccio.test;

import static org.junit.Assert.*;

public class BankAccountTest {


    private BankAccount bankAccount;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("this executes before any test cases. count = "+count++);
    }

    @org.junit.Before
    public void setup(){
        bankAccount = new BankAccount("Euge","Riccio",1000.00,BankAccount.CHECKING);
        System.out.println("Running tst on new bank account");

    }
    @org.junit.Test
    public void deposit() {
        double balance = bankAccount.deposit(200.00,true);
        assertEquals(1200,balance,0);
        assertEquals(1200.00,bankAccount.getBalance(),0);

    }

    @org.junit.Test
    public void withdraw_branch() {
       double balance = bankAccount.withdraw(600,true);
       assertEquals(400.00,balance,0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_noBranch() throws Exception{
          bankAccount.withdraw(600,false);
          fail("should have thrown IllegalArgumentException");
    }

    @org.junit.Test
    public void getBalance_deposit() {
        double balance = bankAccount.deposit(200.00,true);
        assertEquals(1200,balance,0);
        assertEquals(1200.00,bankAccount.getBalance(),0);

    }

    @org.junit.Test
    public void getBalance_withdrawal() {
        BankAccount bankAccount = new BankAccount("Eugenio","Riccio",1000.00,BankAccount.CHECKING);
        double balance = bankAccount.withdraw(200.00,true);
        assertEquals(800,balance,0);
        assertEquals(800,bankAccount.getBalance(),0);

    }

    @org.junit.Test
    public void isChecking_true(){
        BankAccount account = new BankAccount("Eugenio","Riccio",1000.00,BankAccount.CHECKING);
        assertTrue("The account is not a checking account",account.isChecking());

    }

    @org.junit.After
    public void tearDown(){
        System.out.println("count = "+count++);
    }
    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("this executes after any test cases. Count ="+count++);
    }

}