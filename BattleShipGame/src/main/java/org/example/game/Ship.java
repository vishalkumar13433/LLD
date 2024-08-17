package org.example.game;

public class Ship {
    int size;
    int x1;
    int y1;

    int x2;
    int y2;

    int id;

    boolean isDestroyed;

    Ship(int id, int n, int size, int x1, int x2, int y1, int y2) throws Exception {
        this.id = id;
        this.size = size;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        if (!validate(x1, y1, x2, y2, n)) {
            throw new Exception("invalid ship params");
        }

    }

    private boolean validate(int x1, int y1, int x2, int y2, int n) {
        // can add validation for coordinates
        return true;
    }

    public int[][] getShipCordinates() {
        int[][] cord = new int[2][2];
        cord[0][0] = x1;
        cord[0][1] = y1;
        cord[1][0] = x2;
        cord[1][0] = y2;

        return  cord;
    }

}
