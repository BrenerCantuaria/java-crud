package controller;

import DAO.PessoaDao;
import Model.Pessoa;
import com.example.crud.ListarPessoas;
import com.example.crud.TelaPrincipal;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.example.crud.AlteraPessoa;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListarPessoasController implements Initializable {
    @FXML
    private Button btAlterar ;
    @FXML
    private Button btCancelar; // AQUI ESTÁ O BOTÃO SAIR
    @FXML
    private Button btDeletar;

    @FXML
    private TableColumn<Pessoa, String> columEmail;

    @FXML
    private TableColumn<Pessoa, Long> columId;

    @FXML
    private TableColumn<Pessoa, String> columNome;

    @FXML
    private TableView<Pessoa> tabela;

    @FXML
    private Pessoa selecionada;

    @FXML
    private Button btAtualizar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InseriDadosNaTabela();
        btCancelar.setOnMouseClicked((MouseEvent e) -> {
            carregaTelaPrincipal();
        });
        btCancelar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                carregaTelaPrincipal();
            }
        });

        btDeletar.setOnMouseClicked((MouseEvent e) -> {
            deleta();
        });


        btAlterar.setOnMouseClicked((MouseEvent e)->{
                tabela.setItems(atualizaDadosNaTabela());
        });




        tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable , Object oldValue ,Object newValue){
                selecionada=(Pessoa) newValue;
                mostraDetalhes();
            }

            private void mostraDetalhes() {
            }
        });

        btAlterar.setOnMouseClicked((MouseEvent e)->{

            AlteraPessoa alt = new AlteraPessoa();
            try{
                alt.start(new Stage());
            }catch (Exception ex){
                Logger.getLogger(ListarPessoasController.class.getName()).log(Level.SEVERE,null,ex);
            }
        });

    }



    public void InseriDadosNaTabela() {
        columId.setCellValueFactory(new PropertyValueFactory("id"));
        columNome.setCellValueFactory(new PropertyValueFactory("nome"));
        columEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tabela.setItems(atualizaDadosNaTabela());

    }

    public ObservableList<Pessoa> atualizaDadosNaTabela() {
        PessoaDao dao = new PessoaDao();
        return FXCollections.observableArrayList(dao.getList());
    }


    public void carregaTelaPrincipal() {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        fecha();
        try {
            telaPrincipal.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fecha() {
        ListarPessoas.getStage().close();
    }

    public void deleta() {

        if (selecionada != null) {
            PessoaDao dao = new PessoaDao();
            dao.delete(selecionada);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Usuario deletado com sucesso!");
            a.show();
            tabela.setItems(atualizaDadosNaTabela());
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Selecione uma pessoa!");
            a.show();

        }

    }

    private void handle(MouseEvent e) {
        if (selecionada != null) {
            AlteraPessoa alt = new AlteraPessoa(selecionada);
            try {
                alt.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(ListarPessoasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Selecione uma pessoa!");
            a.show();
        }
    }
}