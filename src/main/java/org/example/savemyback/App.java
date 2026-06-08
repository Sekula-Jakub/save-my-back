package org.example.savemyback;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.application.Platform;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static FXMLLoader fxmlLoader;
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {

        mainStage = stage;
        User user;

        if(UserDataSetter.checkFile()) {
            user = UserDataSetter.retrieveUserData();
            loadUserView(user);
        } else {
            loadFirstHelloView();
        }

        stage.getIcons().add(new Image(App.class.getResourceAsStream("assets/icon2.png")));

        stage.setTitle("Save My Back");
        stage.setScene(scene);
        stage.setResizable(false);

        stage.setOnCloseRequest(windowEvent -> {
            if (java.awt.SystemTray.isSupported()) {
                java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();
                for (java.awt.TrayIcon icon : tray.getTrayIcons()) {
                    tray.remove(icon);
                }
            }
            Platform.exit();
            System.exit(0);
        });

        stage.show();
    }

    protected static void loadFirstHelloView() throws IOException {
        loadFXML("hello-view.fxml");
    }

    protected static void loadSecondHelloView() throws IOException {
        loadFXML("first_info.fxml");
    }

    protected static void loadFormView() throws IOException {
        loadFXML("form-view.fxml");
    }

    protected static void loadUserView(User user) throws IOException {
        loadFXML("userView.fxml");
        UserViewController userViewController = fxmlLoader.getController();
        userViewController.loadUserData(user);
    }

    protected static void loadTimeUpView(User user) throws IOException {
        loadFXML("timeUp-view.fxml");
        TimeUpController timeUpController = fxmlLoader.getController();
        timeUpController.loadUserData(user);
    }

    private static void loadFXML(String source) throws IOException {
        fxmlLoader = new FXMLLoader(App.class.getResource(source));
        scene = new Scene(fxmlLoader.load(), 640, 480);
        mainStage.setScene(scene);
    }
}
