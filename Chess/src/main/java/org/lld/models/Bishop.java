package org.lld.models;

import org.lld.enums.PieceType;
import org.lld.strategy.BishopStrategy;

public class Bishop extends Piece{

    public Bishop() {
        this.setKilled(false);
        this.setMovingStrategy(new BishopStrategy());
        this.setPieceType(PieceType.BISHOP);
    }
}
