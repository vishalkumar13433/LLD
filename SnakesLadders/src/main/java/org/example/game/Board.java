package org.example.game;

import java.util.List;

public class Board {
    public Box[][] board;

    public List<Snake> snakes;
    public  List<Ladder> ladders;

    public Board(int size) {
        board = new Box[size][size];
        for (int i=0;i<size; i++) {
            for (int j=0; j< size;j++) {
                board[i][j] = new Box(1 + i * size + j);
            }
        }
    }

    public void addSnake(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public void addLadders(List<Ladder> ladders) {
        this.ladders = ladders;

    }

    public Box findNextBox(Box box, int number) {
        int newNumber = box.getNumber() + number;
        if (newNumber > 100) {
            return box;
        }

        Box newBox = getBox(newNumber);

        for (int i =0 ;i<snakes.size();i++) {
            if (snakes.get(i).mouth == newBox.number) {
                Box b =  getBox(snakes.get(i).tail);

                System.out.println("User bitten by snake .. next box:" + b.getNumber());
                return b;
            }
        }

        for (int i =0 ;i<ladders.size();i++) {
            if (ladders.get(i).bottom == newBox.number) {
                Box b = getBox(ladders.get(i).top);
                System.out.println("User used ladder .. next box:" + b.getNumber());
                return b;
            }
        }

        return newBox;
    }

    private Box getBox(int newNumber) {
        for (int i=0;i<board.length; i++) {
            for (int j=0; j< board[i].length;j++) {
                if (board[i][j].getNumber() == newNumber) {
                    return board[i][j];
                }
            }
        }

        return null;
    }
}
