package org.lld.models;

import org.lld.enums.PieceType;
import org.lld.strategy.QueenStrategy;

public class Queen extends Piece{
    Queen() {
        this.setKilled(false);
        this.setPieceType(PieceType.QUEEN);
        this.setMovingStrategy(new QueenStrategy());
    }
}
