package org.lld.models;

import org.lld.enums.PieceType;
import org.lld.strategy.RookStrategy;

public class Rook extends Piece{

    Rook() {
        this.setKilled(false);
        this.setMovingStrategy(new RookStrategy());
        this.setPieceType(PieceType.ROOK);
    }
}
