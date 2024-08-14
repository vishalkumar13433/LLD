package org.example.pubsub;

import org.example.queue.BoundedBlockingQueue;

public class Publisher implements Runnable{
    BoundedBlockingQueue queue;

    public Publisher(BoundedBlockingQueue q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                queue.enqueue(i);
                System.out.println("Produced: " + i);
                Thread.sleep(20); // Simulate some work
                // we can increase the time to simulate that consumer is fast and producer is slow. Hence, consumer is waiting
                // we can decrease this to simulate the producer being fast and consumer is slow. Producer has to wait for consumer to process
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
