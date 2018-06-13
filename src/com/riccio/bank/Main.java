package com.riccio.bank;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("bank of italy");
        bank.addBranch("catanzaro");
        bank.addCustomer("catanzaro","genio",1000);
        bank.addCustomer("catanzaro","luca",2000);
        bank.addCustomer("catanzaro","mario",3000);
        bank.addBranch("milano");
        bank.addCustomer("milano","giovanni",3000);
        bank.addCustomer("milano","antonio",3000);
        bank.addBranch("roma");
        bank.addCustomer("roma","pierone",3000);
        bank.addCustomerTransaction("roma","pierone",4000);
        bank.addCustomerTransaction("milano","antonio",-1000);
        bank.addCustomerTransaction("catanzaro","genio",4000);

        bank.listCustomers("catanzaro",true);
        bank.listCustomers("milano",true);





    }

}
