package org.example.ratelimiters;

public interface IRateLimiter {
    boolean rateLimit(int customerId);
}
