/**
  * @author rafael_ferraz
 */
package Aplicacao1;

import static javafx.application.Application.launch;
import java.lang.Exception;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacao extends Application {
   
    public static void main(String[] args) {
        launch (args);
         
    }
    
    @Override
    public void start(Stage stage) throws Exception  {
        URL Tela  =  getClass().getResource ("/telas/TelaInicial.fxml");
        Parent tela = FXMLLoader.load(Tela);
        Scene cena = new Scene (tela);
        stage.setScene (cena);
        stage.show();
    }
}