package org.example.ratelimiters;

import org.example.entities.Bucket;

import java.util.HashMap;
import java.util.Map;

public class TokenBucket implements IRateLimiter{
    int maxtokens;
    int refillRate;
    Map<Integer, Bucket> customerBuckets;

    public TokenBucket(int maxTokens, int refillRate) {
        customerBuckets = new HashMap<>();
        this.maxtokens = maxTokens;
        this.refillRate = refillRate;
    }

    @Override
    public boolean rateLimit(int customerId) {
        long curTime = System.currentTimeMillis();
        customerBuckets.putIfAbsent(customerId, new Bucket(maxtokens, curTime));
        Bucket customerBucket = customerBuckets.get(customerId);
        refillBucket(customerBucket, curTime);

        if (customerBucket.getSize() > 0) {
            customerBucket.setSize(customerBucket.getSize() - 1);
            return true;
        }
        return false;
    }

    private void refillBucket(Bucket customerBucket, long curTime) {
        int tokensToAdd = (int)(curTime - customerBucket.getLastRefillTime())  / 1000 * refillRate;

        System.out.print(tokensToAdd + "->" );
        int size = Math.min(maxtokens, customerBucket.getSize() + tokensToAdd);
        customerBucket.setSize(size);
        customerBucket.setLastRefillTime(curTime);
    }
}
