package org.example.game;

import org.example.actors.Player;
import org.example.strategies.IFiringStrategy;
import org.example.strategies.impl.RandomFireStrategy;

public class BattleShipGame {
    int size;
    Square[][] field;
    Player[] players;
    IFiringStrategy firingStrategy;


    int[] playerShips;

    Player currentPlayer;


    public BattleShipGame(Player p1, Player p2, int n) {
        this.size = n;
        field = new Square[n][n];
        players = new Player[2];
        players[0] = p1;
        players[1] = p2;

        for (int i=0; i< n;i++) {
            for(int j=0; j<n;j++) {
                Square sq = new Square(i,j);
                if (j<n/2) {
                    sq.setPlayer(p1);
                } else {
                    sq.setPlayer(p2);
                }
                field[i][j] = sq;
            }
        }
        playerShips = new int[2];

        firingStrategy = new RandomFireStrategy();
    }

    public void AddShip(int id, int shipSize,  int x1, int y1, int x2, int y2) throws Exception {
        if (shipSize <= 0) {
            throw new Exception("invalid ship size!");
        }
        if (x1 <0 || x2 <0 || y1<0 || y2 <0 || x1 >= size || x2 >= size || y1 >= size || y2 >= size) {
            throw new Exception("coordinates not in battle field!");
        }

        Player shipsPlayer = null;
        // size can be used to verify the coordinate range
        Ship ship = new Ship(id, this.size, shipSize, x1, x2, y1, y2);
        for(int i=x1; i<= x2;i++) {
            for (int j=y1; j<=y2; j++) {
                if (field[i][j].ship != null) {
                    throw new Exception("invalid coordinates.. ship overlapping!");
                }
                field[i][j].ship = ship;
                shipsPlayer = field[i][j].player;
            }
        }
        if (shipsPlayer != null) {
            if (shipsPlayer == players[0]) {
                playerShips[0]++;
            }else {
                playerShips[1]++;
            }
        }

    }

    public boolean fireMissile() throws Exception {
        if (isCompleted()) {
            throw new Exception("Game already finished"); // can add a status for game
        }

        // another firing strategy can be plugged here
        int[] firedCoordinates = this.firingStrategy.getFiredCordinates(size, players, currentPlayer);
        String output = "Missile fired at (" + firedCoordinates[0] + ", " +firedCoordinates[1] + ".";

        Square firedSpot = field[firedCoordinates[0]][firedCoordinates[1]];
        Ship ship = firedSpot.getShip();
        if(ship == null) {
            output = output+ "Miss";
        } else {
            output = output + "Hit." + firedSpot.getPlayer().name + "ship with id" + firedSpot.ship.id;
            removeShipFromBattle(firedSpot.ship, firedSpot.player);
        }

        System.out.println(output);
        if (isCompleted()) {
            return true;
        }
        changeTurn();
        return false;
    }

    private void removeShipFromBattle(Ship ship , Player player) {
        int[][] cord = ship.getShipCordinates();
        int x1 = cord[0][0], y1 = cord[0][1];
        int x2 = cord[1][0], y2 = cord[1][1];
        for (int i=x1;i<=x2;i++) {
            for( int j=y1; j<=y2;j++) {
                field[i][j].ship = null;
            }
        }

        if (player == players[0]) {
            playerShips[0] --;
        } else {
            playerShips[1] --;
        }
    }

    void changeTurn() {
        currentPlayer = currentPlayer == players[0] ? players[1]: players[0];
    }

    public void initGame() throws Exception {
        if (field == null || size == 0) {
            throw new Exception("Invalid battlefield");
        }
        currentPlayer = players[0];
    }

    public boolean isCompleted() {
        if (playerShips[0] == 0 &&  playerShips[1] == 0) {
            System.out.println("GameOver. Draw");
            return true;
        }

        if (playerShips[0] > 0 &&  playerShips[1] > 0) {
            return false;
        }

        String output = "GameOver";
        output = output + (playerShips[0] > 0 ? players[0].name : players[1].name);
        System.out.println(output);
        return true;
    }

    public void viewBattleField() {
    }
}
