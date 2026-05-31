module org.example.savemyback {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.savemyback to javafx.fxml;
    exports org.example.savemyback;
}