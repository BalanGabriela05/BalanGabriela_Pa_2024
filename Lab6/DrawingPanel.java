package org.example;

import org.w3c.dom.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    private Game game;
    int rows, cols;
    int canvasWidth = 700, canvasHeight = 500;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
        game = new Game(rows, cols);
        game.generateRandomSticks();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                // Calculate the cell in which the click occurred
                int cellX = Math.round((float) (x - padX) / cellWidth);
                int cellY = Math.round((float) (y - padY) / cellHeight);


                // Check if the cell is empty
                if (game.makeMove(cellY, cellX)) {
                    // If the move was valid, repaint the board
                    repaint();
                }
            }
        });

    }
    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        frame.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics); // This line clears everything before drawing
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        paintSticks(g);
        paintStones(g);
    }

    private void paintStones(Graphics2D g) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (game.board[i][j] != 0) {
                    if (game.board[i][j] == 1) {
                        g.setColor(Color.RED);
                    } else if (game.board[i][j] == 2) {
                        g.setColor(Color.BLUE);
                    }
                    int x = padX + j * cellWidth;
                    int y = padY + i * cellHeight;
                    g.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
                }
            }
        }
    }


    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }
    private void paintSticks(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(5)); // Setăm grosimea liniei la 3 pixeli (puteți ajusta valoarea după preferințe)

        // Parcurgem toate liniile și le desenăm doar dacă există o legătură între nodurile corespunzătoare
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                // Desenăm liniile orizontale
                if (i < rows && j < cols - 1 && game.sticks[i][j]) {
                    int x1 = padX + j * cellWidth;
                    int y1 = padY + i * cellHeight;
                    int x2 = padX + (j + 1) * cellWidth;
                    int y2 = y1;

                    g.drawLine(x1, y1, x2, y2);
                }

// Desenăm liniile verticale
                if (i < rows - 1 && j < cols && game.sticks[i][j]) {
                    int x1 = padX + j * cellWidth;
                    int y1 = padY + i * cellHeight;
                    int x2 = x1;
                    int y2 = padY + (i + 1) * cellHeight;

                    g.drawLine(x1, y1, x2, y2);
                }
            }
        }
    }
    public void updateBoard() {
        this.rows = frame.configPanel.getRows();
        this.cols = frame.configPanel.getCols();
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        game = new Game(rows, cols); // reinitialize the game with the new rows and cols
        game.generateRandomSticks(); // generate the sticks for the new game
        repaint(); // repaint the board
    }


}
