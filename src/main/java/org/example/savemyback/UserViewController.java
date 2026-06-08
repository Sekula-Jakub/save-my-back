package org.example.savemyback;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;

public class UserViewController {

    private String userName;
    private int minutes;

    private int timeSeconds = 10;
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

    @FXML
    public void initialize() {
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
                        not.displayNotification("Czas na rozciąganie!", "Hej " + userName + ", wstań i zadbaj o swoje plecy!");
                    }
                }
            }
        };

        timer.start();
    }

    public void loadUserData(String userName, int minutes) {
        this.userName = userName;
        this.minutes = minutes;
        //this.timeSeconds = this.minutes * 60 + 1;

        userNameLabel.setText(userName);
        String minutesAsString = Integer.toString(minutes);
        timePeriodLabel.setText(minutesAsString);
    }

    private void updateLabel() {
        int minutes = timeSeconds / 60;
        int seconds = timeSeconds % 60;
        countingLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }
}
