package org.example.ratelimiters;

public class TokenBucket {
    private int bucketSize;
    private int refillRate;

    private int maxSize;

    private long lastRefillTime;

    TokenBucket(int bucketSize, int refillRate) {
        this.maxSize = bucketSize;
        this.bucketSize = bucketSize;
        this.refillRate = refillRate;
        this.lastRefillTime = System.currentTimeMillis();
    }

    // can be scheduled method
    private void refillBucket() {
        long currentTime = System.currentTimeMillis();
        int tokensToAdd = (int) (refillRate * (currentTime - lastRefillTime)/1000);
        this.bucketSize = Math.max(maxSize, this.bucketSize + tokensToAdd);
        lastRefillTime = currentTime;
    }

    public boolean allowRequest() {
        if (this.bucketSize <= 0) {
            return false;
        }
        synchronized (TokenBucket.class) {
            this.bucketSize --;
        }
        return this.bucketSize <= 0;
    }

    public int getBucketSize() {
        return bucketSize;
    }

    public void setBucketSize(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    public int getRefillRate() {
        return refillRate;
    }

    public void setRefillRate(int refillRate) {
        this.refillRate = refillRate;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
