package org.example.savemyback;

import java.awt.*;

public class DisplayNotificationThread implements Runnable {
    Thread thrd;
    private TrayIcon trayIcon;
    private String title;
    private String message;

    public DisplayNotificationThread(TrayIcon trayIcon, String title, String message) {
        this.trayIcon = trayIcon;
        this.title = title;
        this.message = message;
        thrd = new Thread(this);
    }

    @Override
    public void run() {
        trayIcon.displayMessage(title, message, TrayIcon.MessageType.NONE);
    }
}
