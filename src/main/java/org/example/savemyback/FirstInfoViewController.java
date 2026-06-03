package org.example.savemyback;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class FirstInfoViewController {

    @FXML
    private Button secondHelloButton;

    @FXML
    private void handleSecondHelloButton(ActionEvent event) throws IOException {
        System.out.println("Kliknieto 2 przycisk.");
        App.loadFormView();
    }
}
