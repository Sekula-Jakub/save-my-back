package org.example.savemyback;

public class TimeMeasurerThread extends Thread {
    int minutes;
    long timeinMills;

    public TimeMeasurerThread(int minutes) {
        this.minutes = minutes;
        timeinMills = minutes * 60 * 1000;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        System.out.println("Rozpoczeto watek");
        try {
            Thread.sleep(timeinMills);
            System.out.println("Czas minął!");
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void stopThread() {
        this.interrupt();
        System.out.println("Zakonczono watek.");
    }
}
