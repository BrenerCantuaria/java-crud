package com.example.crud;

import Model.Pessoa;
import controller.AlteraPessoaController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AlteraPessoa extends Application {
    private static Stage stage;
    public Button btCancelar;
    public Button btAtualizar;
    public PasswordField psSenha;
    public TextField txEmail;


    public AlteraPessoa() {

    }

    public AlteraPessoa(Pessoa p1) {
        AlteraPessoaController.setPessoa2(p1);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("AlteraPessoa.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Alterar Pessoa");
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AlteraPessoa.stage = stage;
    }

    public void cancelarClicked(ActionEvent actionEvent) {

        stage.close();
    }

    public void atualizarClicked(ActionEvent actionEvent) {

        String email = txEmail.getText();
        String senha = psSenha.getText();


        stage.close();
    }
}