package com.riccio.abstraction;

public abstract class Animal {

    private String name ;

    public abstract void eat();

    public abstract void breathe();

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

