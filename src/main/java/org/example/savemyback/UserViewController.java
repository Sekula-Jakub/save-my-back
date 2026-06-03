package org.example.savemyback;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class UserViewController {

    private String userName;
    private int minutes;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label timePeriodLabel;

    @FXML
    private void handleChangeSettingsButton(ActionEvent event) throws IOException {
        App.loadFormView();
    }

    public void loadUserData(String userName, int minutes) {
        this.userName = userName;
        this.minutes = minutes;

        userNameLabel.setText(userName);
        String minutesAsString = Integer.toString(minutes);
        timePeriodLabel.setText(minutesAsString);
    }
}
