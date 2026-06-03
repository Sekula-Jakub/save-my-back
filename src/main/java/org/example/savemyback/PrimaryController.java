package org.example.savemyback;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class PrimaryController {

    @FXML
    private void handleFirstButton(ActionEvent event) throws IOException {
        System.out.println("Kliknieto 1 przycisk.");
        App.loadSecondHelloView();
    }

    @FXML
    private void handleSecondHelloButton(ActionEvent event) throws IOException {
        System.out.println("Kliknieto 2 przycisk.");
        App.loadFormView();
    }

    @FXML
    private void handleSubmitFormButton(ActionEvent event) throws IOException {
        System.out.println("Kliknieto submit.");

    }
}
