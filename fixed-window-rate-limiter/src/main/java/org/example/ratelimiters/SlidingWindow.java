package org.example.ratelimiters;

import org.example.entities.CustomerRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SlidingWindow implements IRateLimiter{
    long windowSize;
    int limit;
    Map<Integer, Deque<Long>> customerRequestsMap;

    public SlidingWindow(int limit,long windowSize) {
        this.windowSize = windowSize;
        this.limit = limit;
        customerRequestsMap = new HashMap<>();
    }


    @Override
    public boolean rateLimit(int customerId) {
        long curTime = System.currentTimeMillis();
        customerRequestsMap.putIfAbsent(customerId, new LinkedList<>());
        Deque<Long> reqTimestamps = customerRequestsMap.get(customerId);
        while(!reqTimestamps.isEmpty() && reqTimestamps.peekFirst() < curTime - windowSize) {
            reqTimestamps.pollFirst();
        }

        reqTimestamps.offerLast(curTime);
        if (reqTimestamps.size() > limit) {
            return false;
        }
        return true;
    }
}
