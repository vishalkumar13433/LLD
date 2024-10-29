package org.example.games;

import org.example.entities.Pair;
import org.example.entities.Snake;

public class SnakeGame implements ISnakeGame{
    Snake snake;
    int boardHeight = 0;
    int boardWidth = 0;
    boolean isFinished = false;

    int moveCount = 1;

    public SnakeGame(int height, int width) {
        this.boardHeight = height;
        this.boardWidth = width;
        snake = new Snake();
        this.moveCount = 1;
    }

    @Override
    public int moveSnake(String snakeDirection) {
        if (isFinished) {
            return -1;
        }
        Pair head = snake.body.peekFirst();
        int curRow = head.getVal1();
        int curCol = head.getVal2();
        switch(snakeDirection) {
            // handle for < 0 cases as well
            case "R": curCol = (curCol + 1)%boardWidth;
                break;
            case "L":curCol = (curCol - 1)% boardWidth;
                break;
            case "U":curRow = (curRow -1)%boardHeight;
                break;
            case "D":curRow = (curRow +1)%boardHeight;
                break;
        }


        Pair nextHead=new Pair(curRow,curCol);
        snake.appendAtFirst(nextHead);
        Pair tail = snake.removeFromLast();
        // bites itself
        if (snake.bodyParts.contains(head)) {
            isFinished = true;
            return -1;
        } else if (moveCount % 3 == 0) {
            moveCount++;
            snake.appendAtLast(tail);
        }
        return snake.body.size();
    }

    @Override
    public boolean isGameOver() {
        return isFinished;
    }
}
