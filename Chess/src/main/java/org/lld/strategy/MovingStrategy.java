package org.lld.strategy;

import org.lld.models.Cell;

import java.util.List;

public interface MovingStrategy {
    boolean canMove(Cell source, Cell destination);

    List<Cell> findNextPossibleMoves();
}
