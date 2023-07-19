module com.example.crud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens Model to javafx.base;
    opens com.example.crud to javafx.fxml;
    exports com.example.crud;
    exports controller;
    opens controller to javafx.fxml;
}