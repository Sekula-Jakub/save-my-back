package org.example.savemyback;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class TimeUpController {
    private User user;
    private String userName;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleImDoneButton(ActionEvent event) throws IOException {
        App.loadUserView(user);
    }

    public void loadUserData(User user) {
        this.user = user;
        this.userName = user.getName();
        userNameLabel.setText(userName);

        App.addToMinutesPassed(user.getTimePeriod().getMinutes());
        int currMinPass = App.getMinutesPassed();
        setMessage(currMinPass);
    }

    public void setMessage(int minutes) {
        messageLabel.setText(MessagesLoader.getCorrespondingMessge(minutes));
    }

}
