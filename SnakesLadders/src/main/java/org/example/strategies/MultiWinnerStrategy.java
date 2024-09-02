package org.example.strategies;

import org.example.models.Players;

import java.util.List;

public class MultiWinnerStrategy implements IWinningStrategy{
    @Override
    public boolean getGameStatus(List<Players> winners, int totalPlayers) {
        return winners.size() == totalPlayers-1;
    }
}
