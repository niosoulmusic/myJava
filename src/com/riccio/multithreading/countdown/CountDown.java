package com.riccio.multithreading.countdown;


import com.riccio.ThreadColor;

class Countdown {

    // heap (shared by all thread es. shared object like this i) stack (private for each thread)
    // threads go in racing conditions doing interference each other
    //Also note that private variables references gets copied in the stack for each thread
    // so not use local variables for sinchronizations and not use primitive types
    private int i;

    public void doCountDown() {
        String color;
        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;

            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }
        // prevents race conditions and interference
        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ":i =" + i);
            }
        }

    }

    public static void main(String[] args) {

        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");
        t1.start();
        t2.start();

    }
}


class CountdownThread extends Thread {

    private Countdown threadCountDown;

    public CountdownThread(Countdown countdown) {
        threadCountDown = countdown;
    }

    public void run() {
        threadCountDown.doCountDown();

    }

}
