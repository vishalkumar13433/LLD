package org.example.strategies;

import org.example.actors.Player;

public interface IFiringStrategy {
    int[] getFiredCordinates(int size, Player[] players, Player currentPlayer);
}
