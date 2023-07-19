package controller;

import DAO.EmpresaDao;
import Model.Empresa;
import com.example.crud.CadastrarEmpresa;
import com.example.crud.TelaPrincipal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastrarEmpresaController implements Initializable {
    @FXML private Button btCadastrar;

    @FXML private Button btCancelar;

    @FXML private TextField txCNPJ;

    @FXML private TextField txNome;

    @FXML private TextField txCidade;

    @FXML private TextField txEndereco;

    @FXML private TextField txEstado;

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
            cadastrarEmpresa();
        });
        btCadastrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER) {
                cadastrarEmpresa();
            }
        });
    }

    public void fecharJanela(){
        CadastrarEmpresa.getStage().close();
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

    public void cadastrarEmpresa(){
        String  nome = txNome.getText(),
                cnpj = txCNPJ.getText(),
                endereco = txEndereco.getText(),
                cidade = txCidade.getText(),
                estado = txEstado.getText();

        Empresa empresa = new Empresa(nome,cnpj,endereco,cidade,estado);

        EmpresaDao dao = new EmpresaDao();

        if (dao.create(empresa)){
            mensagemSucess();
        }else{
            mensagemError();
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

}
