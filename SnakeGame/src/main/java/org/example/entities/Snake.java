package org.example.entities;

import java.util.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Snake {
    public Deque<Pair> body;
    public Set<Pair> bodyParts;

    public Snake() {
        body = new LinkedList<>();
        bodyParts = new HashSet<>();
        Pair pair = new Pair(0,0);
        body.offerFirst(pair);
        bodyParts.add(pair);
    }

    public Pair removeFromLast() {
        Pair last = body.pollLast();
        bodyParts.remove(last);
        return last;
    }

    public Pair removeFromFirst() {
        Pair first = body.pollFirst();
        bodyParts.remove(first);
        return first;
    }

    public void appendAtFirst(Pair pair) {
        body.offerFirst(pair);
        bodyParts.add(pair);
    }

    public void appendAtLast(Pair pair) {
        body.offerLast(pair);
        bodyParts.add(pair);
    }
}
