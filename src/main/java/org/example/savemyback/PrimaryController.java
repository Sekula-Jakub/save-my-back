package org.example.savemyback;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class PrimaryController {

    private App mainApp;

    public void setApp(App mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleFirstButton(ActionEvent event) throws IOException {
        System.out.println("Kliknieto 1 przycisk.");
        App.loadSecondHelloView();
    }
}
