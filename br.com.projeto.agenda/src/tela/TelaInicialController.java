/**
 * @author rafael_ferraz
 */
package tela;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TelaInicialController implements Initializable {

    private String nome;
    private String telefone;
    private String celular;
    private String email;
    private String observacao;
    private String endereco;

    @FXML
    private TextField editNome;
    @FXML
    private TextField editTel;
    @FXML
    private TextField editEnd;
    @FXML
    private AnchorPane editPesquisar;
    @FXML
    private TextField editNomePesquisar;
    @FXML
    private TextField editCelular;
    @FXML
    private TextField editEmail;
    @FXML
    private TextField editObs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void editLimpar(ActionEvent event) {
        editNome.setText("");
        editTel.setText("");
        editCelular.setText("");
        editEnd.setText("");
        editEmail.setText("");
        editObs.setText("");
    }

    @FXML
    private void editPesquisar(ActionEvent event) {
    }

    @FXML
    private void edirEditar(ActionEvent event) {
    }

    @FXML
    private void editExcluir(ActionEvent event) {
    }

    @FXML
    private void editSair(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    private void editSalvar(ActionEvent event) {
        nome = editNome.getText();
        telefone = editTel.getText();
        celular = editCelular.getText();
        email = editEmail.getText();
        observacao = editObs.getText();
        endereco = editEnd.getText();
  
    }

}
