package org.example.savemyback;

import java.awt.*;
import java.net.URL;

public class Notification {
    private TrayIcon trayIcon;

    public Notification() {
        if(SystemTray.isSupported()) {
            try {
                SystemTray tray = SystemTray.getSystemTray();

                URL imageURL = App.class.getResource("assets/icon2.png");

                if(imageURL != null) {
                    Image image = Toolkit.getDefaultToolkit().createImage(imageURL);
                    this.trayIcon = new TrayIcon(image, "SaveMyBack");
                    this.trayIcon.setImageAutoSize(true);
                    this.trayIcon.setToolTip("SaveMyBack reminder");
                    tray.add(this.trayIcon);
                }
            } catch (AWTException e) {
                System.out.println("Connot inicialize system tray.");
            }
        }
    }

    public void displayNotification(String title, String message) {
        if(trayIcon != null) {
            DisplayNotificationThread disNotThread = new DisplayNotificationThread(trayIcon, title, message);
            disNotThread.thrd.start();
        }
    }

}
