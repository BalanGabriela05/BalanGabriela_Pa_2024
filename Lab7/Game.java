package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Game implements TurnTaker {
    private final Bag bag;
    private final List<Player> players = new ArrayList<>();

    private final AtomicInteger turn = new AtomicInteger(0);
    private final AtomicInteger round = new AtomicInteger(1);
    public Game(int n) {
        this.bag = new Bag(n);

    }

    public void addPlayer(String name) {
        Player player = new Player(name, bag, this);
        players.add(player);
    }

    public void play() {
        List<Thread> threads = new ArrayList<>();
        for (Player player : players) {
            player.setTurn(players.indexOf(player));
            Thread thread = new Thread(player);
            thread.start();
            threads.add(thread);
        }

        // Creează și pornește firul de execuție timekeeper
        long timeLimit = 60000; // 60 de secunde
        TimeKeeper timekeeper = new TimeKeeper(timeLimit);
        Thread timekeeperThread = new Thread(timekeeper);
        timekeeperThread.setDaemon(true); // Fir daemon
        timekeeperThread.start();

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Afiseaza jetoanele extrase de fiecare jucator
        System.out.println();
        System.out.println("---jetoanele valide extrase de fiecare jucator---");
       for (Player player : players) {
            System.out.println(player.getExtractedTiles());
       }
        printWinners();
    }


    public static void main(String[] args) {
        Game game = new Game(10);
        game.addPlayer("Player 1");
        game.addPlayer("Player 2");
        game.addPlayer("Player 3");
        game.play();
    }
    public void printWinners() {
        int maxPoints = 0;
        List<Player> winners = new ArrayList<>();

        for (Player player : players) {
            int points = player.getLongestValidSequence().size();
            if (points > maxPoints) {
                maxPoints = points;
                winners.clear();
                winners.add(player);
            } else if (points == maxPoints) {
                winners.add(player);
            }
        }

        System.out.println();
        System.out.println("Jocul s-a terminat!");
        if (winners.size() == 1 && maxPoints!=0) {
            System.out.println("Câștigătorul este " + winners.getFirst().getName() + " cu " + maxPoints + " puncte.");
        } else if (winners.size() > 1 && maxPoints!=0)  {
            System.out.print("Câștigătorii sunt ");
            for (int i = 0; i < winners.size(); i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(winners.get(i).getName());
            }
            System.out.println(" cu " + maxPoints + " puncte fiecare.");
        }
    }


    @Override
    public int getTurn() {
        return turn.get();
    }

    @Override
    public int getNumberOfPlayers() {
        return players.size();
    }

    @Override
    public synchronized void incrementTurn() {
        turn.incrementAndGet();
        if (turn.get() % players.size() == 0) {  // Dacă toți jucătorii și-au luat rândul
            round.incrementAndGet();  // Trec la următoarea rundă
        }
    }

    public int getRound() {
        return round.get();
    }
}
