package com.example.crud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastrarPessoa extends Application {
    private static Stage stage;




    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cadastrarPessoa.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Cadastrar Pessoa");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }


    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        CadastrarPessoa.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
