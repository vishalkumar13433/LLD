package org.example;

import org.example.games.ISnakeGame;
import org.example.games.SnakeGame;

public class Main {
    public static void main(String[] args) {
        ISnakeGame snakeGame = new SnakeGame(3,3);
        System.out.println(snakeGame.moveSnake("D"));
        System.out.println(snakeGame.isGameOver());
        System.out.println( snakeGame.moveSnake("D"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("R"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("U"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("U"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("L"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("D"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("R"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("R"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("U"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("L"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("D"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("U"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("L"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("D"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("U"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("L"));
        System.out.println(snakeGame.isGameOver());
        System.out.println(snakeGame.moveSnake("D"));
        System.out.println(snakeGame.isGameOver());
    }
}