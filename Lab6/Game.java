package org.example;

import java.io.Serializable;
import java.util.Random;

public class Game implements Serializable {
    boolean[][] sticks;
    int[][] board; // 0 = empty, 1 = red, 2 = blue
    int currentPlayer; // 1 = red, 2 = blue
    int rows, cols;

    Game(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.sticks = new boolean[rows][cols];
        this.board = new int[rows][cols];
        this.currentPlayer = 1; // Red starts
    }

    void generateRandomSticks() {
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sticks[i][j] = rand.nextBoolean(); // Randomly assign true or false
            }
        }

    }

    boolean makeMove(int row, int col) {
        // Check if the cell is empty and no neighboring stick is thick
        if (board[row][col] == 0 && !hasThickStick(row, col)) {
            // The cell is not empty or a neighboring stick is thick, the move is invalid
            return false;
        } else {
            // Place a stone of the current player's color
            board[row][col] = currentPlayer;

            // Switch the current player
            currentPlayer = 3 - currentPlayer;

            return true;
        }
    }


    boolean hasThickStick(int row, int col) {
        // Verificăm fiecare vecin în parte
        if (row > 0 && sticks[row - 1][col]) return true; // Sus
        if (row < rows - 1 && sticks[row][col]) return true; // Jos
        if (col > 0 && sticks[row][col - 1]) return true; // Stânga
        if (col < cols - 1 && sticks[row][col]) return true; // Dreapta


        // Dacă niciunul dintre vecini nu are un băț gros, returnăm false
        return false;
    }


}
