package org.example.savemyback;

public class TimeMeasurerThread implements Runnable {
    private Thread timeThrd;
    private int minutes;
    private long mileseconds;

    public TimeMeasurerThread(String name, int minutes) {
        this.timeThrd = new Thread(this, name);
        this.minutes = minutes;
        this.mileseconds = minutes * 60 * 1000;
    }

    public static TimeMeasurerThread createAndStart(int minutes) {
        TimeMeasurerThread timeMeasurerThread = new TimeMeasurerThread("countingThread", minutes);
        timeMeasurerThread.timeThrd.start();
        return timeMeasurerThread;
    }

    public void interruptCountingThread() {
        this.timeThrd.interrupt();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(mileseconds);
        } catch (InterruptedException e) {
            System.out.println("Przerwano watek " + timeThrd.getName());
        }
    }
}