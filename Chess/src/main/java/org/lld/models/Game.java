package org.lld.models;

import org.lld.enums.GameState;

import java.util.List;

public class Game {
    Board board;
    Player[] players;
    Player currentPlayer;

    GameState state;

    Player winner;

    void move(Piece piece, Cell source, Cell destination) throws IllegalStateException{
        if (!GameState.IN_PROGRESS.equals(state)) {
            throw new IllegalStateException("Game is not active !!!");
        }
        if (source.getCurrentPiece() != piece) {
            throw new IllegalStateException("Piece was not present in source cell !!");
        }

        List<Cell> cells = piece.getMovingStrategy().findNextPossibleMoves();
        if (!cells.contains(destination)) {
            throw new IllegalStateException("Cannot move there !!!");
        }

        destination.setCurrentPiece(piece);
        if (checkIfWinningMove()) {
            winner = currentPlayer;
            state = GameState.WINNER_DECIDED;
            return;
        }
        if (checkIfStaleMate()) {
            state = GameState.STALE_MATE;
            return;
        }

        changeTurn();
    }

    private boolean checkIfWinningMove() {
        return false;
    }

    private boolean checkIfStaleMate() {
        return false;
    }

    void changeTurn() {
        if (currentPlayer == players[0]) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];
        }
    }
}
