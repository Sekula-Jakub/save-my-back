package org.example.savemyback;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HelloViewController {

    @FXML
    private Button firstHelloButton;

    @FXML
    private void handleFirstButton(ActionEvent event) throws IOException {
        System.out.println("Kliknieto 1 przycisk.");
        App.loadSecondHelloView();
    }


}
