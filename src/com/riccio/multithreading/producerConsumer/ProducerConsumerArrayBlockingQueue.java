package com.riccio.multithreading.producerConsumer;

import com.riccio.ThreadColor;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.riccio.multithreading.producerConsumer.ProducerConsumer.EOF;

public class ProducerConsumerArrayBlockingQueue {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);
        ReentrantLock bufferLock = new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducerBlockingQueue producer = new MyProducerBlockingQueue(buffer, ThreadColor.ANSI_BLACK);
        MyConsumerBlockingQueue consumer = new MyConsumerBlockingQueue(buffer, ThreadColor.ANSI_RED);
        MyConsumerBlockingQueue consumer2 = new MyConsumerBlockingQueue(buffer, ThreadColor.ANSI_PURPLE);

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

class MyProducerBlockingQueue implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducerBlockingQueue(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            try {
                System.out.println(color + "Adding ... " + num);
                buffer.add(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("producer was interrupted");
            }
        }
        System.out.println("Adding EOF and quit");
        try {
            buffer.put(EOF);
        } catch (InterruptedException e) {

        }
    }
}

class MyConsumerBlockingQueue implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumerBlockingQueue(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    } else if (buffer.peek().equals(EOF)) {
                        System.out.println(color + " Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
