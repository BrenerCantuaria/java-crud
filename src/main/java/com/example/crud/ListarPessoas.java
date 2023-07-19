package com.example.crud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ListarPessoas extends Application {
    private static Stage stage;




    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ListarPessoas.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Listar Pessoas");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }


    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ListarPessoas.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
