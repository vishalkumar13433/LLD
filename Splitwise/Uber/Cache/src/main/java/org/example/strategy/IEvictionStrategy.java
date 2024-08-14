package org.example.strategy;

public interface IEvictionStrategy<K> {
    void keyAccessed(K k);

    K getKeyToEvict();
}
