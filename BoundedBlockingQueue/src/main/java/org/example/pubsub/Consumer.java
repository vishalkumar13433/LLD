package org.example.pubsub;

import org.example.queue.BoundedBlockingQueue;

public class Consumer implements Runnable{

    BoundedBlockingQueue queue;

    public Consumer(BoundedBlockingQueue q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                int item = queue.dequeue();
                System.out.println("Consumed: " + item);
                Thread.sleep(150); // Simulate some work
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
