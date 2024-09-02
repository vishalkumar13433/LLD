package org.example.strategies;

import org.example.models.Players;

import java.util.List;

public interface IWinningStrategy {
    public boolean getGameStatus(List<Players> winners, int totalPlayers);
}
