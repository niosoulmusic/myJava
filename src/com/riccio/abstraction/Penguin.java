package com.riccio.abstraction;

public class Penguin extends Bird {

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName()+" is not good at flying..better swimming");
    }
}
