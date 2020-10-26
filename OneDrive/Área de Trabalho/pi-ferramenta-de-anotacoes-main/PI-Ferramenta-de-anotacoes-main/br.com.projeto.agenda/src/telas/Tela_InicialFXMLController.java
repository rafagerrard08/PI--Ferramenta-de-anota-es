/**
 * @author rafael_ferraz, Thiago Gilabel de Souza
 */
package telas; 

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import registros.ItemAgenda;

public class Tela_InicialFXMLController implements Initializable {  //Rafael
 
    @FXML
    private AnchorPane editPesquisar;
    @FXML
    private TextField editNome;
    @FXML
    private TextField editTel;
    @FXML
    private TextField editCelular;
    @FXML
    private TextField editEnd;
    @FXML
    private TextField editEmail;
    @FXML
    private TextField editObs;
    @FXML
    private TextField editNomePesquisar;
    @FXML
    private TableView<ItemAgenda> tabela;
    @FXML
    private TableColumn<ItemAgenda, String> colunaNome;
    @FXML
    private TableColumn<ItemAgenda, String> colunaTel;
    @FXML
    private TableColumn<ItemAgenda, String> colunaCel;
    @FXML
    private TableColumn<ItemAgenda, String> colunaEmail;
    @FXML
    private TableColumn<ItemAgenda, String> colunaEndereco;
    @FXML
    private TableColumn<ItemAgenda, String> colunaObservacao;
    
    List<ItemAgenda> ListaAgenda = new ArrayList(); //Thiago
    int totalItens = 0;
    boolean modoEdicao = false;
    ItemAgenda itemAgendaEdicao = null;

    @Override  //Thiago
    public void initialize(URL url, ResourceBundle rb) {
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaTel.setCellValueFactory(new PropertyValueFactory("telefone"));
        colunaCel.setCellValueFactory(new PropertyValueFactory("celular"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory("endereco"));
        colunaObservacao.setCellValueFactory(new PropertyValueFactory("observacao"));
    }

    @FXML
    private void editSalvar(ActionEvent event) { //Rafael
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validação");
        alert.setHeaderText("");
        alert.setContentText("Salvo com sucesso!");
        alert.showAndWait();

        ItemAgenda item = new ItemAgenda(); //Thiago                
        int idItem = 1;
        if (idItem == 1) {
            idItem++;
        }
        item.id = idItem;
        item.nome = editNome.getText();
        item.telefone = editTel.getText();
        item.celular = editCelular.getText();
        item.email = editEmail.getText();
        item.observacao = editObs.getText();
        item.endereco = editEnd.getText();
        item.id = totalItens;
        
        totalItens++;

        ListaAgenda.add(item);
    }

    @FXML
    private void editLimpar(ActionEvent event) { //Rafael
    
        editNome.clear();
        editTel.clear();
        editCelular.clear();
        editEnd.clear();
        editEmail.clear();
        editObs.clear();
        
        Alert alert = new Alert(Alert.AlertType.WARNING); //Rafael
        alert.setTitle("Excluir");
        alert.setHeaderText("");
        alert.setContentText("Apagado com sucesso!");
        alert.showAndWait();
    }

    @FXML
    private void editPesquisar(ActionEvent event) {  //Thiago
          
        if ( tabela != ListaAgenda  ){

        Alert alert = new Alert(Alert.AlertType.WARNING);  //Rafael
        alert.setTitle("Verificando o armazenamento ...");
        alert.setHeaderText("");
        alert.setContentText("Aguarde um momento!");
        alert.showAndWait();
    tabela.setItems(FXCollections.observableArrayList(ListaAgenda));
          
        
        } else if ( ListaAgenda== tabela  ){
         Alert alert = new Alert(Alert.AlertType.INFORMATION); //Rafael
        alert.setTitle("Verificando o armazenamento ...");
        alert.setHeaderText("");
        alert.setContentText("Nome não encontrado!");
        alert.showAndWait();
        
        }

    }
    

    @FXML
    private void editEditar(ActionEvent event) { //Thiago
        ItemAgenda itemSelecionado = tabela.getSelectionModel().getSelectedItem();

        if (itemSelecionado != null) {

            modoEdicao = true;

            itemAgendaEdicao = itemSelecionado;

            editNome.setText(itemSelecionado.nome);
            editTel.setText(itemSelecionado.telefone);
            editCelular.setText(itemSelecionado.celular);
            editEnd.setText(itemSelecionado.endereco);
            editEmail.setText(itemSelecionado.email);
            editObs.setText(itemSelecionado.observacao);
    
        }
    }

    @FXML
    private void editExcluir(ActionEvent event) { //Thiago
            ItemAgenda itemSelecionado = tabela.getSelectionModel().getSelectedItem();
            
            for (int i = 0; i < ListaAgenda.size(); i++) {
            ItemAgenda itemLista = ListaAgenda.get(i);
            if (itemLista.id == itemSelecionado.id) {
                ListaAgenda.remove(i);
                break;
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //Rafael  
        alert.setTitle("Validação");
        alert.setHeaderText("Excluido com sucesso! ");
        alert.setContentText("Pesquise para confirmar a exclusão!");
        alert.showAndWait();
     
            }
        
        @FXML
    private void editSair(ActionEvent event) { //Rafael
        System.exit(0);
    }

}
