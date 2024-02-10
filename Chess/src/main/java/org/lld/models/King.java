package org.lld.models;

import org.lld.enums.PieceType;
import org.lld.strategy.KingStrategy;

public class King extends Piece{
    public King() {
        this.setPieceType(PieceType.KING);
        this.setKilled(false);
        this.setMovingStrategy(new KingStrategy());
    }
}
