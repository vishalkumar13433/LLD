package org.example.game;

import org.example.actors.Player;
import org.example.game.Ship;

public class Square {
    int row;
    int col;
    Player player;
    Ship ship;

    public Square() {
    }

    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        ship = null;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
