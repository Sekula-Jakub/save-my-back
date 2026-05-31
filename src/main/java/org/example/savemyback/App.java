package org.example.savemyback;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static FXMLLoader fxmlLoader;
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {

        mainStage = stage;

        loadFirstHelloView();

        if(SerializationChecker.checkFolder()) {
            //fxmlLoader = new FXMLLoader(App.class.getResource("inny_view"));
        }

        stage.setTitle("Save My Back");
        stage.setScene(scene);
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
}
