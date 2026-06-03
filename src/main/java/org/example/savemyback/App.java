package org.example.savemyback;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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

        stage.getIcons().add(new Image(App.class.getResourceAsStream("assets/icon.png")));

        stage.setTitle("Save My Back");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    protected static void loadFirstHelloView() throws IOException {
        fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 640, 480);
        mainStage.setScene(scene);
    }

    protected static void loadSecondHelloView() throws IOException {
        fxmlLoader = new FXMLLoader(App.class.getResource("first_info.fxml"));
        scene = new Scene(fxmlLoader.load(), 640, 480);
        mainStage.setScene(scene);
    }

    protected static void loadFormView() throws IOException {
        fxmlLoader = new FXMLLoader(App.class.getResource("form-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 640, 480);
        mainStage.setScene(scene);
    }

    protected static void loadUserView(User user) throws IOException {
        fxmlLoader = new FXMLLoader(App.class.getResource("userView.fxml"));
        scene = new Scene(fxmlLoader.load(), 640, 480);
        UserViewController userViewController = fxmlLoader.getController();
        userViewController.loadUserData(user.getName(), user.getTimePeriod().getMinutes());
        mainStage.setScene(scene);
    }
}
