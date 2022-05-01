/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AccueilController implements Initializable {

    @FXML
    private Button mnuDeconnexion;
    @FXML
    private Button menuClasse;
    @FXML
    private AnchorPane anchorContent;
    @FXML
    private Button menuInscription;
    @FXML
    private Button menuProfesseur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadViews("classe");
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
 }    

    @FXML
    private void handleDeconnexion(ActionEvent event) throws IOException {
          this.mnuDeconnexion.getScene().getWindow().hide();
            AnchorPane root;
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void handleClickMenuClasse(ActionEvent event) throws IOException {
        loadViews("classe");
    }
    
    private void loadViews(String view) throws IOException{
         AnchorPane root;
         root = FXMLLoader.load(getClass().getResource(view+".fxml"));
         anchorContent.getChildren().clear();
         anchorContent.getChildren().add(root);
    }

    @FXML
    private void handleInscription(ActionEvent event) throws IOException {
        loadViews("inscription");
    }

    @FXML
    private void handleIntProfesseur(ActionEvent event) throws IOException {
        loadViews("professeur");
    }
}
