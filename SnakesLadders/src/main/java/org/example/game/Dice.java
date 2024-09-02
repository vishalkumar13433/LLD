package org.example.game;

import java.util.Random;

public class Dice {
    int start;
    int end;

    public Dice(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int rollDice() {
        // TODO:: check
        return start + new Random().nextInt(this.end);
    }

}
