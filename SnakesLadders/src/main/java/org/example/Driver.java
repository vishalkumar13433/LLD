package org.example;

import org.example.enums.WinningTypes;
import org.example.game.SnakesAndladderGame;
import org.example.game.Ladder;
import org.example.models.Players;
import org.example.game.Snake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        int diceMax = 6;
        int boardSize = 10;
        WinningTypes winningType = WinningTypes.SINGLE;
//        WinningTypes winningType = WinningTypes.MULTI; // to allow multiple winners
        List<Players> players = new ArrayList<>();
        Players players1 = new Players(1, "Vishal");
        Players players2 = new Players(2, "ABVC");
        Players players3 = new Players(3, "DEF");
        Players players4 = new Players(4, "XYZ");

        players.add(players4);
        players.add(players3);
        players.add(players2);
        players.add(players1);


        SnakesAndladderGame snakesAndladderGame = SnakesAndladderGame.getInstance(players, boardSize , winningType, diceMax);
        Snake snake1 = new Snake(99, 10);
        Snake snake2 = new Snake(30, 12);
        Snake snake3 = new Snake(65, 23);

        Ladder ladder1 = new Ladder(11, 52);
        Ladder ladder2 = new Ladder(31, 42);
        Ladder ladder3 = new Ladder(55, 90);


        List<Snake> snakes = Arrays.asList(snake1, snake2, snake3);
        List<Ladder> ladders = Arrays.asList(ladder1, ladder2, ladder3);
        snakesAndladderGame.addSnakes(snakes);
        snakesAndladderGame.addLadders(ladders);

        snakesAndladderGame.startGame();
        boolean isFinished = false;
        while (!isFinished) {
            isFinished = snakesAndladderGame.move();
        }

    }
}
