package com.riccio.multithreading.messages;

import java.util.Random;

class Message {

    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) {

            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        return message;
    }


    public synchronized void write(String message) {
        while (!empty) {

            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();

    }
}

class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String messages[] = {
                "Humpty Dumpty sat on a wall",
                "Ciccio Pasticcio is on the table",
                "All the king's horses and all the king's men",
                "another 1 bites the dust"
        };
        Random randomDelay = new Random();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(randomDelay.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random randomDelay = new Random();
        for (String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(randomDelay.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }

    }
}