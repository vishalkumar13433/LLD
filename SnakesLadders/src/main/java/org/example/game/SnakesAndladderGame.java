package org.example.game;

import org.example.enums.GameStatus;
import org.example.enums.WinningTypes;
import org.example.models.*;
import org.example.strategies.IWinningStrategy;
import org.example.strategies.MultiWinnerStrategy;
import org.example.strategies.SingleWinningStrategy;

import java.util.*;

public class SnakesAndladderGame {
    IWinningStrategy winningStrategegy;// single winner / multi winner
    Deque<Players> players;
    GameStatus status;
    List<Players> winners;
    Dice dice;
    Board board;

    Players currentPlayer;
    int playerCount;


    public static SnakesAndladderGame instance;

    private SnakesAndladderGame(List<Players> players, int size, WinningTypes winningType, int diceMax) {
        if (players == null) {
            players = new LinkedList<>();
        }
        playerCount = players.size();
        this.players = new LinkedList<>();
        for (Players player: players) {
            this.players.offer(player);
        }
        this.board = new Board(size);
        this.dice = new Dice(1, diceMax);
        this.status = GameStatus.CREATED;

        // move this to factory
        if (winningType.equals(WinningTypes.SINGLE)) {
            winningStrategegy = new SingleWinningStrategy();
        } else if (winningType.equals(WinningTypes.MULTI)) {
            winningStrategegy = new MultiWinnerStrategy();
        }
        winners = new ArrayList<>();

        for (Players players1 : players) {
            players1.setCurrentBox(board.board[0][0]);
        }
    }

    public static SnakesAndladderGame getInstance(List<Players> players, int n, WinningTypes winningTypes, int diceMax) {
        if (instance == null) {
            synchronized (SnakesAndladderGame.class) {
                instance = new SnakesAndladderGame(players, n, winningTypes, diceMax);
            }
        }
        return instance;
    }

    public void startGame() {
        this.status = GameStatus.IN_PROGRESS;
        this.currentPlayer = this.players.peek();
    }

    public boolean move() {
        int number = this.dice.rollDice();
        Box box =  this.currentPlayer.getCurrentBox();
        Box newBox = board.findNextBox(box, number);
        currentPlayer.setPlayerBox(newBox);
        System.out.println("Player" + currentPlayer.getName() + " moved from :" + box.getNumber() + "to :" + newBox.getNumber());
        changeMove();
        if (isCompleted()) {
            return true;
        }
        return false;
    }


    private boolean isCompleted() {
        return GameStatus.COMPLETED == status;
    }
    private void changeMove() {
        if (isCompleted()) {
            throw new IllegalStateException("game already finished");
        }

        if (isWinningMove()) {
            Players winner =  this.players.pollFirst();
            winners.add(winner);
            if (this.winningStrategegy.getGameStatus(winners, playerCount) ) {
                status = GameStatus.COMPLETED;
                System.out.println("Winner is : " + getWinnerString());
            }

            currentPlayer = this.players.peekFirst();
        } else {
            Players player = this.players.pollFirst();
            currentPlayer = this.players.peekFirst();
            this.players.offerLast(player);
        }

    }

    private boolean isWinningMove() {
        if (currentPlayer.getCurrentBox() != null && currentPlayer.getCurrentBox().getNumber() == 100) {
            return true;
        }
        return false;
    }


    public void addSnakes(List<Snake> snakes) {
        board.addSnake(snakes);
    }

    public void addLadders(List<Ladder> ladders) {
        board.addLadders(ladders);
    }

    private String getWinnerString() {
        String ans = "";
        for (Players players1 : winners) {
            ans = ans + "," + players1.getName();
        }
        return ans;
    }
}
