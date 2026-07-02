module org.example.savemyback {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens org.example.savemyback to javafx.fxml;
    exports org.example.savemyback.controller;
    opens org.example.savemyback.controller to javafx.fxml;
    exports org.example.savemyback.app;
    opens org.example.savemyback.app to javafx.fxml;
    exports org.example.savemyback.model;
    opens org.example.savemyback.model to javafx.fxml;
    exports org.example.savemyback.notification;
    opens org.example.savemyback.notification to javafx.fxml;
}