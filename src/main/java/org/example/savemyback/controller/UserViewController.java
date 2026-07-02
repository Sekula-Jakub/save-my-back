package org.example.savemyback.controller;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.savemyback.app.App;
import org.example.savemyback.notification.Notification;
import org.example.savemyback.model.User;

import java.io.IOException;

public class UserViewController {

    private User user;
    private String userName;
    private int minutes;

    private int timeSeconds;
    private long lastUpdate = 0;

    private final Notification not = new Notification();

    @FXML
    private Label userNameLabel;

    @FXML
    private Label timePeriodLabel;

    @FXML
    private Label countingLabel;

    @FXML
    private void handleChangeSettingsButton(ActionEvent event) throws IOException {
        App.loadFormView();
    }

    public void loadUserData(User user) {
        this.user = user;
        this.userName = user.getName();
        this.minutes = user.getTimePeriod().getMinutes();
        this.timeSeconds = this.minutes * 60 + 1;
        //this.timeSeconds = 10;

        userNameLabel.setText(userName);
        String minutesAsString = Integer.toString(minutes);
        timePeriodLabel.setText(minutesAsString);

        updateLabel();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(now - lastUpdate >= 1_000_000_000 ) {
                    timeSeconds--;
                    updateLabel();

                    lastUpdate = now;

                    if(timeSeconds <= 0) {
                        stop();
                        countingLabel.setText("Time for a walk!");
                        not.displayNotification("Time for a quick reset!", "Hey " + userName + ", step away from the screen and stretch those legs!");
                        try {
                            App.loadTimeUpView(user);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                        App.showWindowOnTop();
                    }
                }
            }
        };

        timer.start();
    }

    private void updateLabel() {
        int minutes = timeSeconds / 60;
        int seconds = timeSeconds % 60;
        countingLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }
}
