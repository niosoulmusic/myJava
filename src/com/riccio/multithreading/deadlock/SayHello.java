package com.riccio.multithreading.deadlock;

public class SayHello {

    public static void main(String[] args) {

        final PolitePerson jane = new PolitePerson("Jane");
        final PolitePerson gege = new PolitePerson("gege");
        new Thread(new Runnable() {
            @Override
            public void run() {
                jane.sayHello(gege);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                gege.sayHello(jane);

            }
        }).start();

    }

    static class PolitePerson {
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }


        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }
    }
}
