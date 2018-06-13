package com.riccio.multithreading.producerConsumer;

import com.riccio.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_BLACK, bufferLock);
        MyConsumer consumer = new MyConsumer(buffer, ThreadColor.ANSI_RED, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);

        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.execute(consumer2);


        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_BLUE + " I'm being printed from callable class");
                return "This is the callable result";
            }
        });
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();
//        new Thread(producer).start();
//        new Thread(consumer).start();
//        new Thread(consumer2).start();
    }

}

class MyProducer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            try {

                System.out.println(color + "Adding ... " + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();

                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("producer was interrupted");
            }
        }
        System.out.println("Adding EOF and quit");
        bufferLock.lock();
        try {
            buffer.add(ProducerConsumer.EOF);
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true) {
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    } else if (buffer.get(0).equals(ProducerConsumer.EOF)) {
                        System.out.println(color + " Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            }
        }
    }
}
