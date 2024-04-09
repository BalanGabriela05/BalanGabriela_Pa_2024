package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private final String name;
    private final Bag bag;

    private final List<Tile> myTiles = new ArrayList<>();

        public Player(String name, Bag bag) {
            this.name = name;
            this.bag = bag;
        }
    private boolean canFormSequence(Tile tile) {
        if (myTiles.isEmpty()) {
            return true;
        }

        for (Tile myTile : myTiles) {
            if (myTile.num2() == tile.num1() || myTile.num1() == tile.num2()) {
                return true;
            }
        }

        return false;
    }


    @Override
    public void run() {
        List<Tile> tiles;
        while (!(tiles = bag.extractTiles(1)).isEmpty()) {
            Tile tile = tiles.getFirst();
            if (canFormSequence(tile)) {
                myTiles.add(tile);
                System.out.println(name + " a extras: " + tile);
                updateSequence(tile);
            }
            if (myTiles.size() == bag.getSize()) {
                break;
            }
        }
    }

    private void updateSequence(Tile newTile) {
        if (myTiles.isEmpty()) {
            myTiles.add(newTile);
            return;
        }

        // Find the position to insert the new tile
        for (int i = 0; i < myTiles.size(); i++) {
            Tile currentTile = myTiles.get(i);
            if (currentTile.num2() == newTile.num1()) {
                myTiles.add(i + 1, newTile);
                return;
            } else if (currentTile.num1() == newTile.num2()) {
                myTiles.add(i, newTile);
                return;
            }
        }

    }



}
