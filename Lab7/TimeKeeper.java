package org.example;

public class TimeKeeper implements Runnable {
    private long startTime;
    private long timeLimit;

    public TimeKeeper(long timeLimit) {
        this.startTime = System.currentTimeMillis();
        this.timeLimit = timeLimit;
    }

    @Override
    public void run() {
        while (true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;

            if (elapsedTime > timeLimit) {
                System.out.println("Timpul de joc a depășit limita de timp.");
                System.exit(0);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
