package controller;

import DAO.EmpresaDao;
import DAO.PessoaDao;
import Model.Empresa;
import Model.Pessoa;
import com.example.crud.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaPrincipalController implements Initializable {

    @FXML private Button btCadastrarEmpresa;

    @FXML private Button btCadastrarPessoa;

    @FXML private Button btListarEmpresa;

    @FXML private Button btListarPessoa;

    public void initialize(URL url, ResourceBundle rb){
        //Empresa
          btCadastrarEmpresa.setOnMouseClicked((MouseEvent e)->{
              carregaCadastroDeEmpresa();
          });
          btCadastrarEmpresa.setOnKeyPressed((KeyEvent e)->{
              if(e.getCode() == KeyCode.ENTER){
                 carregaCadastroDeEmpresa();
              }
          });

          // Pessoa
        btCadastrarPessoa.setOnMouseClicked((MouseEvent e)->{
           carregaCadastroDePessoa();
        });
        btCadastrarPessoa.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                carregaCadastroDePessoa();
            }
        });

        //Listar Pessoas
        btListarPessoa.setOnMouseClicked((MouseEvent e) -> {
            carregaListarPessoas();
        });
        btListarPessoa.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                carregaListarPessoas();
            }
        });


        //Listar Empresa
        btListarEmpresa.setOnMouseClicked((MouseEvent e) -> {
            carregaListarEmpresas();
        });
        btListarEmpresa.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                carregaListarEmpresas();
            }
        });



    }

    public void carregaCadastroDePessoa(){
        CadastrarPessoa pss = new CadastrarPessoa();
        fechaJanela();
        try {
            pss.start(new Stage());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }}
    public void carregaCadastroDeEmpresa(){
        CadastrarEmpresa emp = new CadastrarEmpresa();
        fechaJanela();
        try {
            emp.start(new Stage());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void carregaListarPessoas() {


        ListarPessoas listarPessoas = new ListarPessoas();
        fechaJanela();
        try {
            listarPessoas.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE,null, ex);
        }

    }
    public void carregaListarEmpresas() {

        ListarEmpresas listarEmpresas = new ListarEmpresas();
        fechaJanela();
        try {
            listarEmpresas.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE,null, ex);
        }

    }

    public void fechaJanela(){
        TelaPrincipal.getStage().close();
    }

}
