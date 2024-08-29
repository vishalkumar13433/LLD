package org.example.strategy;

import org.example.model.LRUNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionStrategy<K> implements IEvictionStrategy<K>{
    private LRUNode<K> head;
    private LRUNode<K> tail;

    private Map<K, LRUNode<K>> nodeMap;

    private int capacity;

    public LRUEvictionStrategy(int capacity) {
        this.nodeMap = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    @Override
    public void keyAccessed(K k) {
        LRUNode<K> node = nodeMap.computeIfAbsent(k, LRUNode::new);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        if (head != node) {
            // remove
            if (node == tail) {
                tail = tail.getPrev();
            }
            LRUNode<K> prev = node.getPrev();
            if (prev != null) {
                prev.setNext(node.getNext());
            }
            LRUNode<K> next = node.getNext();
            if (next != null) {
                next.setPrev(prev);
            }
            // set
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
    }

    @Override
    public K getKeyToEvict() {
        if (tail == null) {
            return null;
        }
        if (nodeMap.size() > capacity) {
            LRUNode<K> prev = tail.getPrev();
            if (prev != null) {
                prev.setNext(tail.getNext());
            }
            K key = tail.getKey();
            tail = prev;
            return key;
        }
        return null;
    }

    public LRUNode<K> getHead() {
        return head;
    }

    public void setHead(LRUNode<K> head) {
        this.head = head;
    }

    public LRUNode<K> getTail() {
        return tail;
    }

    public void setTail(LRUNode<K> tail) {
        this.tail = tail;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
