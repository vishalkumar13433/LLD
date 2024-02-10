package org.lld.models;

import org.lld.enums.PieceType;
import org.lld.strategy.PawnStrategy;

public class Pawn extends Piece{

    Pawn() {
        this.setKilled(false);
        this.setMovingStrategy(new PawnStrategy());
        this.setPieceType(PieceType.PAWN);
    }
}
