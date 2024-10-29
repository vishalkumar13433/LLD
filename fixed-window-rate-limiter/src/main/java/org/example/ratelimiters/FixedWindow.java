package org.example.ratelimiters;

import org.example.entities.CustomerRequest;

import java.util.HashMap;
import java.util.Map;

public class FixedWindow implements IRateLimiter{
    long windowSize;
    int limit;
    Map<Integer, CustomerRequest> customerRequestMap;

    public FixedWindow(int limit, long windowSize) {
        customerRequestMap = new HashMap<>();
        this.windowSize = windowSize;
        this.limit = limit;
    }

    @Override
    public boolean rateLimit(int customerId) {
        long curTime = System.currentTimeMillis();
        CustomerRequest customerRequest = customerRequestMap.get(customerId);
        if (customerRequest == null) {
            customerRequestMap.put(customerId, new CustomerRequest(1, curTime));
            return true;
        }
        if (curTime - customerRequest.getWindowStart() > windowSize) {
            customerRequest.setWindowStart(curTime);
            customerRequest.setRequests(0);
        }
        customerRequest.setRequests(customerRequest.getRequests() + 1);
        return customerRequest.getRequests() <= limit;
    }
}
