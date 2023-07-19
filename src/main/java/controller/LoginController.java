package controller;

import com.example.crud.Main;
import com.example.crud.TelaPrincipal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PipedReader;
import java.net.URL;
import java.util.PrimitiveIterator;
import java.util.ResourceBundle;

public class  LoginController implements Initializable {
    @FXML private Button btEntrar;

    @FXML private Button btSair;

    @FXML private TextField txEmail;

    @FXML private PasswordField txSenha;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btEntrar.setOnMouseClicked((MouseEvent e) -> {
            entrar();
        });

        btEntrar.setOnKeyPressed((KeyEvent e) ->{
            if(e.getCode() == KeyCode.ENTER){
                entrar();
            }
        });


        btSair.setOnMouseClicked((MouseEvent e ) -> {
           fecharJanela();
        });

        btSair.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                fecharJanela();
            }
        });

        txSenha.setOnKeyPressed((KeyEvent e) ->{
            if(e.getCode() == KeyCode.ENTER){
                entrar();
            }
        });
    }


    // Métodos
    public void fecharJanela(){
        Main.getStage().close();
    }

    public void entrar(){
        if(txEmail.getText().equals("Admin") && txSenha.getText().equals("admin")){
            // Cria um objeto de TelaPrincipal e em p
            TelaPrincipal p = new TelaPrincipal();
            fecharJanela();
            // O try catch é usa caso ocorra um erro ao carregar a janela.
            try {
                p.start(new Stage());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao acessar a tela principal");
            alert.setContentText("Usuário inválido");
            alert.show();
        }
    }

}
