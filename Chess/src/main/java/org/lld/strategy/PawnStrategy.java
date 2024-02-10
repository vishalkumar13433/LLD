package org.lld.strategy;

import org.lld.models.Cell;

import java.util.List;

public class PawnStrategy implements MovingStrategy{
    @Override
    public boolean canMove(Cell source, Cell destination) {
        return false;
    }

    @Override
    public List<Cell> findNextPossibleMoves() {
        return null;
    }
}
