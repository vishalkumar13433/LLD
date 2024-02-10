package org.lld.model;

import org.lld.enums.GameState;

import java.util.Arrays;
import java.util.Map;

public class Board {
    int[][] matrix;
    int size;

    public Board(int n) {
        size = n;
        matrix = new int[size][size];
        for (int i=0; i<size; i++) {
            Arrays.fill(matrix[i], 0);
        }
    }

    public void printBoard(Map<Integer, Character> numberToCharMap) {
        int[][] mat = this.matrix;
        System.out.println("---------------");
        for (int i=0; i< mat.length; i++) {
            for (int j=0; j< mat[i].length; j++) {
                char charTOPrint = numberToCharMap.get(mat[i][j]);
                System.out.print( charTOPrint + " ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}
