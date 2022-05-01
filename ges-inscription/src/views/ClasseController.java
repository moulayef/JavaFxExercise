/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.Classe;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.Service;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ClasseController implements Initializable {
    private Service service=new Service();
    private ObservableList<Classe> obList;
    //Elle devient globale, accessible dans toutes les fonctions
    private Classe classeSelected;
    int posSelected;
    
    @FXML
    private ComboBox<String> cboNiveau;
    @FXML
    private ComboBox<String> cboFiliere;
    @FXML
    private TableView<Classe> tblvClasse;
    @FXML
    //TableColumn<objet, type de l'atrribut>
    private TableColumn<Classe, String> tblcLibelle;
    @FXML
    private TableColumn<Classe, String> tblcFiliere;
    @FXML
    private TableColumn<Classe, String> tblcNiveau;

    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        cboNiveau.getItems().add("L1");
        cboNiveau.getItems().add("L2");
        cboNiveau.getItems().add("L3");
        cboNiveau.getItems().add("M1");
        cboNiveau.getItems().add("M2");
        
        
        List<String> filieres;
        String filiere[]=new String[]{"IAGE", "MAE", "TTL", "CPD", "ETSE", "GLRS"}; 
        filieres = Arrays.asList(filiere);
        cboFiliere.getItems().addAll(filieres);
        
        //Observe les données à convertir
        ArrayList<Classe> listClasse = service.listerClasse();
        //Convertir cette liste en ObservableList
        obList=FXCollections.observableArrayList(listClasse);
        
        tblcLibelle.setCellValueFactory(new PropertyValueFactory<> ("libelle"));
        tblcFiliere.setCellValueFactory(new PropertyValueFactory<> ("filiere"));
        tblcNiveau.setCellValueFactory(new PropertyValueFactory<> ("niveau"));
        
        //Souscire
        tblvClasse.setItems(obList);
        
    }    

    @FXML
    private void handleAddClasse(ActionEvent event) {
        //Récupération des valeurs sélectionnés
        String niveau=cboNiveau.getSelectionModel().getSelectedItem();
        String filiere=cboFiliere.getSelectionModel().getSelectedItem();
        //Créer un objet de type classe
        Classe classe= new Classe();
        //Hydrater la classe
        classe.setFiliere(filiere);
        classe.setNiveau(niveau);
        classe.setLibelle(niveau+filiere);
        //Ajouter la classe
        boolean result= service.ajoutClasse(classe);
        if(result == true){
           Alert alert= new Alert(AlertType.INFORMATION);
           alert.setContentText("La classe a été enregistrée avec succés");
           alert.show();
           obList.add(classe);
        }else{
            Alert alert= new Alert(AlertType.ERROR);
           alert.setContentText("Probléme détecté, veuillez contacter votre admin au 778889908");
           alert.show();
        }
    }

    @FXML
    //Réagit à la classe sélectionné
    private void handleEditClasse(MouseEvent event) {
        classeSelected=tblvClasse.getSelectionModel().getSelectedItem();
        posSelected = obList.indexOf(classeSelected);
        System.out.println(posSelected);
    }

    @FXML
    //Réagit au bouton de modifier
    private void handleModiferClasse(ActionEvent event) {
        //Récupération des valeurs sélectionnés 
        String niveau=cboNiveau.getSelectionModel().getSelectedItem();
        String filiere=cboFiliere.getSelectionModel().getSelectedItem();
        //Hydrater la classe
        classeSelected.setFiliere(filiere);
        classeSelected.setNiveau(niveau);
        classeSelected.setLibelle(niveau+filiere);
        //Ajouter la classe
        boolean result= service.modifierClasse(classeSelected);
        if(result == true){
           Alert alert= new Alert(AlertType.INFORMATION);
           alert.setContentText("La classe a été modifiée avec succés");
           alert.show();
           obList.set(posSelected, classeSelected);
        }else{
            Alert alert= new Alert(AlertType.ERROR);
           alert.setContentText("Probléme détecté, veuillez contacter votre admin au 778889908");
           alert.show();
        }
    }
    
    

    @FXML
    private void handleSupprimerClasse(ActionEvent event) {
        //Récupération des valeurs sélectionnés 
        String niveau=cboNiveau.getSelectionModel().getSelectedItem();
        String filiere=cboFiliere.getSelectionModel().getSelectedItem();
        //Hydrater la classe
        classeSelected.setFiliere(filiere);
        classeSelected.setNiveau(niveau);
        classeSelected.setLibelle(niveau+filiere);
        int intSelected = 1;
        //Supprimer la classe
        boolean result = service.supprimerClasse(intSelected);
        if(result == true){
            Alert alert= new Alert(AlertType.INFORMATION);
           alert.setContentText("La classe a été supprimée avec succés");
           alert.show();
           obList.set(posSelected, classeSelected);
        
        }else{
            Alert alert= new Alert(AlertType.ERROR);
           alert.setContentText("Probléme détecté, veuillez contacter votre admin au 776598423");
           alert.show();
        }
    }
    
}
