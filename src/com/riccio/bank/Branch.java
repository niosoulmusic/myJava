package com.riccio.bank;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public boolean newCustomer (String name, double initialAmount){
        if (findCustomer(name) == null){
            this.customers.add(new Customer(name,initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        Customer existingCustomer  = findCustomer(customerName);
        if (existingCustomer!=null){
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName){
        for (Customer c : customers){
            if (c.getName().equalsIgnoreCase(customerName)){
                return c;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
