package org.example;

import org.example.cache.Cache;

public class Main {
    public static void main(String[] args) {
        Cache<Integer, Integer> cache = new Cache<>(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Integer val = cache.get(1);
        if (val == null) {
            val = -1;
        }
        System.out.println(val);
        cache.put(3, 3);
        val = cache.get(2);
        if (val == null) {
            val = -1;
        }
        System.out.println(val);
        cache.put(4,4);
        val = cache.get(1);
        if (val == null) {
            val = -1;
        }
        System.out.println(val);
        val = cache.get(3);
        if (val == null) {
            val = -1;
        }
        System.out.println(val);
        val = cache.get(4);
        if (val == null) {
            val = -1;
        }
        System.out.println(val);

    }
}