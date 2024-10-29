package org.example;

import org.example.ratelimiters.FixedWindow;
import org.example.ratelimiters.IRateLimiter;
import org.example.ratelimiters.SlidingWindow;
import org.example.ratelimiters.TokenBucket;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        IRateLimiter rateLimiter = new FixedWindow(2, 1000);
//        IRateLimiter rateLimiter = new SlidingWindow(2, 1000);
        IRateLimiter rateLimiter = new TokenBucket(2, 2);
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(2));
        System.out.println(rateLimiter.rateLimit(2));
        System.out.println(rateLimiter.rateLimit(2));
        Thread.sleep(1000);
        System.out.println(rateLimiter.rateLimit(2));
    }
}