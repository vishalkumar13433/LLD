package org.example.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class BoundedBlockingQueue {
    final Queue<Integer> q;
    final int capacity;
    final Object lock;

    public BoundedBlockingQueue(int size) {
        this.capacity = size;
        this.lock = new Object();
        this.q = new LinkedList<>();
    }

    public void enqueue(int value) throws InterruptedException {
        synchronized(lock) {
            while(this.size() == capacity) {
                System.out.println("queue is full");
                lock.wait();
            }
            q.add(value);
            lock.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized(lock) {
            while(this.isEmpty()) {
                System.out.println(" queue is empty");
                lock.wait();
            }
           int val = q.poll();
            lock.notifyAll();
            return val;
        }
    }

    private boolean isEmpty() {
        synchronized (lock) {
            return this.q.isEmpty();
        }
    }

    private int size() {
        synchronized (lock) {
            return this.q.size();
        }
    }
}
