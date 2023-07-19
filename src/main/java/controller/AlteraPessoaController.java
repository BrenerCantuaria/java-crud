package controller;

import DAO.PessoaDao;
import Model.Pessoa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class AlteraPessoaController implements Initializable {

    @FXML
    private Button btAtualizar;

    @FXML
    private Button btCancelar;

    @FXML
    private Label lbid;

    @FXML
    private PasswordField psConfirmarSenha;

    @FXML
    private PasswordField psSenha;

    @FXML
    private TextField txEmail;

    @FXML
    private TextField txNome;

    @FXML
    void atualizarClicked(ActionEvent event) {

    }
    @FXML
    void cancelarClicked(ActionEvent event) {

    }



    public AlteraPessoaController(Button btAlterar, Button btCancelar, Label lbid, PasswordField psConfirmarSenha, PasswordField psSenha, TextField txEmail, TextField txNome) {
        this.btAtualizar = btAlterar;
        this.btCancelar = btCancelar;
        this.lbid = lbid;
        this.psConfirmarSenha = psConfirmarSenha;
        this.psSenha = psSenha;
        this.txEmail = txEmail;
        this.txNome = txNome;
    }


    private static Pessoa pessoa2;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initPerson();
        btCancelar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                fecha();
            }
        });

        btAtualizar.setOnMouseClicked((MouseEvent e) -> {
            atualiza();
        });
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initPerson() {
        txNome.setText(pessoa2.getNome());
        txEmail.setText(pessoa2.getEmail());
        psSenha.setText(pessoa2.getSenha());
        psConfirmarSenha.setText(pessoa2.getSenha());
    }

    public static Pessoa getPessoa2() {
        return pessoa2;
    }

    public static void setPessoa2(Pessoa pessoa1) {
        AlteraPessoaController.pessoa2 = pessoa1;
    }

    public void fecha() {
        stage.close();
    }

    public void atualiza() {
        Long id = Long.parseLong(lbid.getText());
        String nome = txNome.getText();
        String email = txEmail.getText();
        String senha = psSenha.getText();
        String confSenha = psConfirmarSenha.getText();

        if (senha.equals(confSenha)) {
            PessoaDao dao = new PessoaDao();
            Pessoa p = new Pessoa(id, nome, email, senha);
            if (dao.update(p)) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Concluído");
                a.setContentText("Dados atualizados com sucesso!");
                a.showAndWait();
                fecha();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Erro!");
                a.setContentText("Ocorreu um erro ao atualizar os dados.");
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("As senhas não são iguais");
            a.showAndWait();
        }
    }
}