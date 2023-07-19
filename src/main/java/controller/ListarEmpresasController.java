package controller;

import DAO.EmpresaDao;
import DAO.PessoaDao;
import Model.Empresa;
import Model.Pessoa;
import com.example.crud.ListarEmpresas;
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
import FactoryMethod.EmpresaDeletionFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListarEmpresasController implements Initializable {

    @FXML private Button btSair;

    @FXML private Button btAtualizar;

    @FXML private Button btDeletar;

    @FXML private TableColumn<Empresa, String> columCidade;

    @FXML private TableColumn<Empresa, String> columCnpj;

    @FXML private TableColumn<Empresa, String> columEndereco;

    @FXML private TableColumn<Empresa, String> columEstado;

    @FXML private TableColumn<Empresa, Long> columId;

    @FXML private TableColumn<Empresa, String> columNome;

    @FXML private TableView<Empresa> table;

    private Empresa selecionada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InseriDadosNaTabela();
        btSair.setOnMouseClicked((MouseEvent e)-> {
            carregaTelaPrincipal();
        });
        btSair.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER){
                carregaTelaPrincipal();
            }
        });


        btAtualizar.setOnMouseClicked((MouseEvent e)->{
            table.setItems(atualizaDadosNaTabela());
        });

        btDeletar.setOnMouseClicked((MouseEvent e)->{
               delete();
        });



        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Empresa>() {
            @Override
            public void changed(ObservableValue<? extends Empresa> observableValue, Empresa empresa, Empresa t1) {
                selecionada = t1;
            }
        });



    };
    @FXML
    public void delete() {
        if (selecionada != null) {
            boolean deleted = EmpresaDeletionFactory.deleteEmpresa(selecionada);
            if (deleted) {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Empresa deletada com sucesso!");
                a.show();
                table.setItems(atualizaDadosNaTabela());
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Erro ao deletar a empresa.");
                a.show();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Selecione uma empresa!");
            a.show();
        }
    }

    public void carregaTelaPrincipal() {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        fecha();
        try {
            telaPrincipal.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE,null, ex);
        }
    }


    public void InseriDadosNaTabela(){
        columId.setCellValueFactory(new PropertyValueFactory("id"));
        columNome.setCellValueFactory(new PropertyValueFactory("nome"));
        columCnpj.setCellValueFactory(new PropertyValueFactory("cnpj"));
        columEndereco.setCellValueFactory(new PropertyValueFactory("endereco"));
        columCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
        columEstado.setCellValueFactory(new PropertyValueFactory("estado"));


        table.setItems(atualizaDadosNaTabela());

    }


    public ObservableList<Empresa> atualizaDadosNaTabela(){
        EmpresaDao dao = new EmpresaDao();
        return FXCollections.observableArrayList(dao.getList());
    }


    public void fecha(){
        ListarEmpresas.getStage().close();
    }
}


