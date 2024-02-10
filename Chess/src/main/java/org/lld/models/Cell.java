package org.lld.models;

import org.lld.enums.Color;

public class Cell {
    private int x;
    private int y;
    private Color color;

    private Piece currentPiece;

    public Cell(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.currentPiece = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }
}
