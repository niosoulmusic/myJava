package com.riccio.bank;


import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches= new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName,String customerName,double initialAmount){
        Branch branch = findBranch(branchName);
        if (branch != null){
           branch.newCustomer(customerName,initialAmount);
        }
        return false;
    }
    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch b = findBranch(branchName);
        if (branchName!=null){
            return b.addCustomerTransaction(customerName,amount);
        }
        return false;
    }

    public Branch findBranch(String branchName){
        for (Branch b : branches ){
            if (b.getName().equalsIgnoreCase(branchName)) {
                return b;
            }
        }
        return null;
    }
    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if (branch!=null){
            System.out.println("Customer details for branch :"+branchName);
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (Customer c : branchCustomers){
                System.out.println("Customer Name : "+c.getName());
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = c.getTransactions();
                    int i = 1;
                    for (Double transaction : transactions) {
                        System.out.println("[" + i++ + "] with Amount " + transaction);
                    }
                }
            }
        return true;
        }
        return false;
    }
}
