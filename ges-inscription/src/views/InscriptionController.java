/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.Classe;
import entity.Inscription;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import services.Service;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class InscriptionController implements Initializable {
    private Service service=new Service();
    private ObservableList<Classe> obList;
    //Elle devient globale, accessible dans toutes les fonctions
    private Classe classeSelected;

    @FXML
    private TextField txtMatricule;
    @FXML
    private TextField txtNomComplet;
    @FXML
    private TextField txtTuteur;
    @FXML
    private ComboBox<String> cboClasse;
    
   @FXML
    private TableView<Inscription> tblvInscription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cboClasse.getItems().add("IAGE");
        cboClasse.getItems().add("TTl");
        cboClasse.getItems().add("MAE");
        cboClasse.getItems().add("ETSE");
        cboClasse.getItems().add("CPD");
        
        //Observe les données à convertir
        ArrayList<Classe> listClasse = service.listerClasse();
        //Convertir cette liste en ObservableList
        obList=FXCollections.observableArrayList(listClasse);
        
    
    }    

    @FXML
    private void HandleCancel(ActionEvent event) {
        
        
    }

    @FXML
    private void handleSave(ActionEvent event) {
        //Récupération des valeurs sélectionnés
        String classe=cboClasse.getSelectionModel().getSelectedItem();
        
        //Créer un objet de type classes
        Classe classes= new Classe();
        //Hydrater la classe
        classes.setClasse(classe);
        //Ajouter la classe
        boolean result= service.ajoutClasse(classe);
        if(result == true){
           Alert alert= new Alert(AlertType.INFORMATION);
           alert.setContentText("La classe a été enregistrée avec succés");
           alert.show();
           obList.add(classes);
        }else{
            Alert alert= new Alert(AlertType.ERROR);
           alert.setContentText("Probléme détecté, veuillez contacter votre admin au 778889908");
           alert.show();
        }
    }

    private void loadViews(String inscription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
