package controller;

import DAO.PessoaDao;
import Model.Pessoa;
import com.example.crud.CadastrarEmpresa;
import com.example.crud.CadastrarPessoa;
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
import java.net.URL;
import java.util.ResourceBundle;

public class CadastrarPessoaController implements Initializable {
    @FXML private Button btCadastrar;

    @FXML private Button btCancelar;

    @FXML private PasswordField psSenha;

    @FXML private TextField txEmail;

    @FXML private TextField txNome;

    @FXML private TextField psConfirmarSenha;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Cancela
        btCancelar.setOnMouseClicked((MouseEvent e)->{
                carregaTelaPrincipal();
        });
        btCancelar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER) {
                carregaTelaPrincipal();
            }
        });


        // Cadastra
        btCadastrar.setOnMouseClicked((MouseEvent e)->{
                cadastraPessoa();
        });
        btCadastrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER) {
                cadastraPessoa();
            }
        });
    }

    private void cadastraPessoa(){
        String  nome = txNome.getText(),
                email = txEmail.getText(),
                senha = psSenha.getText(),
                confirmacao = psConfirmarSenha.getText();

        if(senha.equals(confirmacao)){
                Pessoa pessoa = new Pessoa(nome,email,senha);
                PessoaDao dao = new PessoaDao();
                if(dao.create(pessoa)){
                    mensagemSucess();

                }else{
                   mensagemError();
                }
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Senha não são iguais");
            a.show();
        }
    }



    public void mensagemSucess(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Cadastro realizado com sucesso");
        carregaTelaPrincipal();
        fecharJanela();
        alert.show();
    }
    public void mensagemError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Não foi possível realizar o cadastro");
        alert.show();
    }

    public void fecharJanela(){
        CadastrarPessoa.getStage().close();
    }

    public void carregaTelaPrincipal(){
        TelaPrincipal p = new TelaPrincipal();
        fecharJanela();
        try {
            p.start(new Stage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
