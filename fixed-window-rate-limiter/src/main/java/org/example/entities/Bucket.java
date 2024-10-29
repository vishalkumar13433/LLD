package org.example.entities;

public class Bucket {
    int size;
    long lastRefillTime;

    public Bucket(int size, long lastRefillTime) {
        this.size = size;
        this.lastRefillTime = lastRefillTime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getLastRefillTime() {
        return lastRefillTime;
    }

    public void setLastRefillTime(long lastRefillTime) {
        this.lastRefillTime = lastRefillTime;
    }
}
