package org.lld.model;

import org.lld.enums.GameState;
import org.lld.enums.PlayerType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Game {
    Board board;
    Player playerX;
    Player playerO;

    Player currentPlayer;

    public Player winner;

    GameState state;

    int movesRemaining;

    Map<Integer, Character> boardCharMap;

    // pre calculate row/col/diagonal scores for 0(1) winning
    int[] rowScores;
    int[] colScores;
    int diagonalScore;
    int reverseDiagonalScore;

    public Game(int n) {
        board = new Board(n);
        playerX = new Player(PlayerType.X);
        playerO = new Player(PlayerType.O);
        boardCharMap = new HashMap<>();
        boardCharMap.put(0, '_');
        boardCharMap.put(playerO.playerType.getValue(), playerO.playerType.getKey().charAt(0));
        boardCharMap.put(playerX.playerType.getValue(), playerX.playerType.getKey().charAt(0));
        state = GameState.INITIATED;
        movesRemaining = n * n;

        // pre calculate row/col/diagonal scores for 0(1) winning
        rowScores = new int[n];
        colScores = new int[n];
        diagonalScore = 0;
        reverseDiagonalScore = 0;
    }

    public void doToss() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        if (randomNumber <= 50) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
        state = GameState.IN_PROGRESS;
    }

    private void changeTurn() {
        PlayerType playerType = this.currentPlayer.playerType;
        if (playerType == PlayerType.O) {
            currentPlayer = playerX;
        } else {
            currentPlayer = playerO;
        }
    }

    private void markAsDraw() {
        state = GameState.DRAW;
        System.out.println("---------------MATCH HAS ENDED AS A DRAW---------");
    }

    private void assignWinner() {
        winner = currentPlayer;
        state = GameState.WINNER_SELECTED;
        this.board.printBoard(boardCharMap);
        System.out.println("---------------MATCH HAS ENDED AND THE WINNER IS : =====>" + (currentPlayer.playerType.getKey()));
    }

    // TODO:: add winner implementation
    private boolean checkIfWinningMove(int row, int col, int playerMove) {
        // 0(n^2)
        int[][] mat =this.board.matrix;
        boolean hasWon = true;
        // check row win
        for (int i=0; i< mat[row].length;i++) {
            if (mat[row][i] != playerMove) {
                hasWon = false;
                break;
            }
        }
        if (hasWon) {
            return true;
        }

        hasWon = true;
        // check col win
        for (int i=0; i< mat.length;i++) {
            if (mat[i][col] != playerMove) {
                hasWon = false;
                break;
            }
        }
        if (hasWon) {
            return true;
        }

        // check diagonal/ reverse diagonal win
        if (row + col + 1 != mat.length) {
            return false;
        }

        hasWon = true;
        // check diagonal win
        for (int i=0;i < mat.length; i++) {
            if (mat[i][i] != playerMove) {
                hasWon = false;
                break;
            }
        }
        if (hasWon) {
            return true;
        }

        hasWon = true;
        // check reverse diagonal win
        for (int i=0;i < mat.length; i++) {
            if (mat[i][mat.length - i - 1] != playerMove) {
                hasWon = false;
                break;
            }

        }
        if (hasWon) {
            return true;
        }

        return false;
    }

    private boolean checkIfWinningMoveO1(int row, int col, int playerMove) {
        rowScores[row]  += playerMove;
        colScores[col] += playerMove;
        if (row == col) {
            diagonalScore += playerMove;
        }
        if (row == board.size - col - 1) {
            reverseDiagonalScore += playerMove;
        }

        int winValue = playerMove * board.size;
        return (rowScores[row] == winValue || colScores[col] == winValue
        || diagonalScore == winValue || reverseDiagonalScore == winValue);
    }


    public boolean nextMove(int row, int col) throws IllegalStateException{
        if (!state.equals(GameState.IN_PROGRESS)) {
            throw new IllegalStateException("Game is not in progress !!");
        }
        if (row < 0 || col < 0 || row >= board.size || col >= board.size) {
            throw new IllegalStateException("Trying to fill wrong cell in this move !!");
        }
        if (this.board.matrix[row][col] != 0) {
            throw new IllegalStateException("cell is already filled !!");
        }

        int playerMove = currentPlayer.playerType.getValue();
        this.board.matrix[row][col] = playerMove;

        if (checkIfWinningMoveO1(row, col, playerMove)) {
            assignWinner();
            return true;
        }
        movesRemaining--;
        if (movesRemaining <= 0) {
            markAsDraw();
            return true;
        }
        changeTurn();
        return false;
    }

    public void printBoard() {
        this.board.printBoard(boardCharMap);
    }
}
