package org.example.cache;

import org.example.strategy.IEvictionStrategy;
import org.example.strategy.LRUEvictionStrategy;

import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {
    private final Map<K, V> map;
    private final IEvictionStrategy<K> strategy;

    public Cache(int capacity) {
        map = new HashMap<>();
        strategy = new LRUEvictionStrategy<>(capacity);
    }

    public V get(K k) {
        strategy.keyAccessed(k);
        return map.get(k);
    }

    public void put(K k, V v) {
        map.put(k, v);
        strategy.keyAccessed(k);
        K key = strategy.getKeyToEvict();
        if (key != null) {
            map.remove(key);
        }
    }
}
