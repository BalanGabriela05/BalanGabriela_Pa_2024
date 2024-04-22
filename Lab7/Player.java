package org.example;

import java.util.ArrayList;
import java.util.List;


public class Player implements Runnable {
    private final String name;
    private final Bag bag;
    private int myTurn;
    private final TurnTaker turnTaker;

    private final List<Tile> myTiles = new ArrayList<>();
    private List<Tile> longestValidSequence = new ArrayList<>();

   

    public Player(String name, Bag bag, TurnTaker turnTaker) {
        this.name = name;
        this.bag = bag;
        this.turnTaker = turnTaker;

    }
    public void setTurn(int turn) {
        this.myTurn = turn;
    }
    public List<Tile> getLongestValidSequence() {
        return longestValidSequence;
    }

    public String getName() {
        return name;
    }

    //Validarea secventei
    public String getExtractedTiles() {
        int[] frequency = new int[bag.getN() + 1];

        for (Tile tile : myTiles) {
            List<Tile> currentSequence = new ArrayList<>();
            currentSequence.add(tile);
            frequency[tile.num1()]++;
            frequency[tile.num2()]++;

            for (Tile otherTile : myTiles) {
                if (otherTile != tile && otherTile.num1() == currentSequence.get(currentSequence.size() - 1).num2() &&
                        frequency[otherTile.num1()] < 2 && frequency[otherTile.num2()] < 2) {
                    currentSequence.add(otherTile);
                    frequency[otherTile.num1()]++;
                    frequency[otherTile.num2()]++;
                }
            }

            if (currentSequence.get(0).num1() == currentSequence.get(currentSequence.size() - 1).num2() &&
                    currentSequence.size() > longestValidSequence.size()) {
                longestValidSequence = currentSequence;
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" a extras secvență validă: ");
        for (Tile tile : longestValidSequence) {
            sb.append(tile).append(", ");
        }
        if (!longestValidSequence.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" -----> ").append(longestValidSequence.size()).append(" puncte");
        return sb.toString();
    }

    //run
    @Override
    public void run() {

        while (!bag.isEmpty() && !bag.gameOver) {
            synchronized (turnTaker) {  // Sincronizare pe obiectul de monitorizare
                while (!bag.isEmpty() && !bag.gameOver && turnTaker.getTurn() % turnTaker.getNumberOfPlayers() != myTurn) {
                    try {
                        turnTaker.wait();  // Așteptați până când este rândul acestui jucător
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (bag.isEmpty()) {
                    turnTaker.notifyAll();  // Notificați toate celelalte fire de execuție
                    return;  // Încheie jocul dacă jocul s-a încheiat
                }
                if (myTurn == 0) {
                    System.out.println("------ RUNDA: " + turnTaker.getRound() + " ------");
                }

                // Acum este rândul acestui jucător
                List<Tile> tiles = bag.extractTiles(1);
                if (!tiles.isEmpty()) {
                    Tile tile = tiles.getFirst();
                    System.out.println(name + " a extras: " + tile);  // Afiseaza jetonul extras
                        myTiles.add(tile);
                        updateSequence(tile);

                    // Verifica daca exista o secventa valida dupa extragerea noului jeton
                    String sequence = getExtractedTiles();
                    if (longestValidSequence.size() == bag.getN()) {

                        bag.gameOver = true;  // Setează variabila de stare gameOver la true
                        turnTaker.notifyAll();  // Notificați toate celelalte fire de execuție
                        return;  // Încheie jocul dacă jocul s-a încheiat
                    }
                }


                turnTaker.incrementTurn();  // Treci la următorul rând
                turnTaker.notifyAll();  // Notificați toate celelalte fire de execuție
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
