package org.example;

import org.example.actors.Player;
import org.example.game.BattleShipGame;

public class Main {
    public static void main(String[] args) throws Exception {
        BattleShipGame game = initGame(6);
        try {
            game.AddShip(1, 2, 0,0,1,1);
        } catch (Exception e) {
            System.out.println("Invalid Ship details provided 1" + e.getMessage());
            return;
        }

        // Optional
        game.viewBattleField();
        try {
            game.AddShip(1, 2, 2,3, 3,4);
        } catch (Exception e) {
            System.out.println("Invalid Ship details provided 2:" + e.getMessage());
            return;
        }

        game.initGame();
        boolean isCompleted = false;
        do {
            isCompleted = game.fireMissile();
        } while (!isCompleted);

    }

    private static BattleShipGame initGame(int size) {
        Player player1 = new Player("PlayerA");
        Player player2 = new Player("PlayerB");
        return new BattleShipGame(player1, player2, size);
    }
}