package org.example.savemyback;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FormViewController {

    @FXML
    private Button submitFormButton;

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> timePeriodField;

    @FXML
    private CheckBox space4WalkField;

    @FXML
    private void handleSubmitFormButton(ActionEvent event) throws IOException {
        System.out.println("Kliknieto submit.");

        String enteredName = nameField.getText();
        String enteredTime = timePeriodField.getValue();
        if(enteredTime != null) {
            enteredTime = enteredTime.substring(0, 2);
        }
        boolean enteredWalk = space4WalkField.isSelected();
        System.out.println("User entered name: " + enteredName);
        System.out.println("User entered time: " + enteredTime);
        System.out.println("User entered walk: " + enteredWalk);

        if(dataValid(enteredName, enteredTime)) {
            User newUser = new User(enteredName, TimePeriods.parseToTimePeriods(enteredTime), enteredWalk);
            UserDataSetter.saveUserData(newUser);
            App.loadUserView(newUser);
        }
    }

    private boolean dataValid(String enteredName, String enteredTime) {
        if(!enteredName.isEmpty() && !enteredTime.isEmpty()) {
            return true;
        }
        return false;
    }
}
