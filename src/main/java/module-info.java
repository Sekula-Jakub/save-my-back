module org.example.savemyback {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens org.example.savemyback to javafx.fxml;
    exports org.example.savemyback;
}