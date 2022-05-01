/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.Classe;
import entity.Professeur;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import services.Service;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ProfesseurController implements Initializable {
    private Service service=new Service();
    private ObservableList<Classe> obList;
    //Elle devient globale, accessible dans toutes les fonctions
    private Classe classeSelected;

    @FXML
    private Text lblError;
    @FXML
    private Text lblError1;
    @FXML
    private Text lblError2;
    @FXML
    private Text lblError3;
    
    @FXML
    private TableView<Professeur> tblvProfesseur;
    @FXML
    //TableColumn<objet, type de l'atrribut>
    private TableColumn<Classe, String> tblcNCI;
    @FXML
    private TableColumn<Classe, String> tblcNomComplet;
    @FXML
    private TableColumn<Classe, String> tblcGrade;
     @FXML
    private TableColumn<Classe, String> tblcStatus;
    @FXML
    private ComboBox<String> cboClasse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblError.setVisible(false);
        lblError1.setVisible(false);
        lblError2.setVisible(false);
        lblError3.setVisible(false);
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
        
        tblcNCI.setCellValueFactory(new PropertyValueFactory<> ("nci"));
        tblcNomComplet.setCellValueFactory(new PropertyValueFactory<> ("nomComplet"));
        tblcGrade.setCellValueFactory(new PropertyValueFactory<> ("grade"));
        tblcStatus.setCellValueFactory(new PropertyValueFactory<> ("status"));
        
       
    }    
    
}
