module org.example.savemyback {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.savemyback to javafx.fxml;
    exports org.example.savemyback;
}