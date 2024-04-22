package org.example;

import java.util.*;

public class Bag {
    private final Queue<Tile> tiles;
    private final int n;
    public boolean gameOver = false;

    public Bag(int n) {
        this.n = n;
        this.tiles = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    tiles.add(new Tile(i, j));
                }
            }
        }
        Collections.shuffle((List<?>) tiles);  // Amesteca jetoanele
    }
    public int getN() {  // Adaugă o metodă pentru a returna valoarea n
        return n;
    }

    public synchronized boolean isEmpty() {
        return tiles.isEmpty();
    }


    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            extracted.add(tiles.poll());
        }
        return extracted;
    }



}
