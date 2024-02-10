package org.lld.models;

import org.lld.enums.PieceType;
import org.lld.strategy.KnightStrategy;

public class Knight extends Piece{

    Knight() {
        this.setKilled(false);
        this.setMovingStrategy(new KnightStrategy());
        this.setPieceType(PieceType.KNIGHT);
    }
}
