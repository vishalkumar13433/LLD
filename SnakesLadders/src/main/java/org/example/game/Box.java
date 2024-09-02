package org.example.game;

import org.example.models.Players;

import java.util.ArrayList;
import java.util.List;

public class Box {
    int number;
    List<Players> players;

    public Box(int number) {
        this.number = number;
        this.players =  new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }
}
