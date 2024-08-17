package org.example.strategies.impl;

import org.example.actors.Player;
import org.example.strategies.IFiringStrategy;

public class RandomFireStrategy implements IFiringStrategy {
    @Override
    public int[] getFiredCordinates(int size, Player[] players, Player currentPlayer) {
        int rowStart = currentPlayer == players[0] ? 0: (size/2)-1;

        int randRow = getRandomNumber(rowStart, rowStart + (size/2) -1);
        int randCol = getRandomNumber(0, size-1);

        return new int[]{randRow, randCol};
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
