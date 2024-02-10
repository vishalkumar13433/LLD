package org.lld;

import org.lld.model.Board;
import org.lld.model.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------TIC TAC TOE ----------");
        Game game = new Game(3); //3 X 3
        game.doToss();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("give matrix coordination of the move");
            game.printBoard();
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            try {
                boolean isFinished = game.nextMove(row, col);
                if (isFinished) {
                    break;
                }
            } catch (Exception e){
                System.out.println("Exceptiom:" + e.getLocalizedMessage() + ".. Try again");
            }

        }
    }
}