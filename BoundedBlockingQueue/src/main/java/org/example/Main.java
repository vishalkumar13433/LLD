package org.example;

import org.example.pubsub.Consumer;
import org.example.pubsub.Publisher;
import org.example.queue.BoundedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BoundedBlockingQueue queue = new BoundedBlockingQueue(5);

        Thread producerThread = new Thread(new Publisher(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

//        FOLLOW UPS:
//        1. Use semaphore
//        2. Add multiple consumer
//        3. add shutdown mechanism: we can use private final ShutdownSignal;
//        4. can we use executor service
    }
}