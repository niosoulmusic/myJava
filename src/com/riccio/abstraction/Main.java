package com.riccio.abstraction;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Andrea ");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Tommy");
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("paolo");
        penguin.fly();
    }
}
