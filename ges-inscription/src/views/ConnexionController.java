/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.Admin;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.Service;

/**
 *
 * @author Utilisateur
 */
public class ConnexionController implements Initializable {
    private Service service = new Service();
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Text lblError;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblError.setVisible(false);
        
    }    

    @FXML
    private void handleConnexion(ActionEvent event) throws IOException {
        String login = txtLogin.getText().trim();//.trim supprime les espaces
        String password = txtPassword.getText().trim();
        if(login.isEmpty()||password.isEmpty()){
        lblError.setText("Login ou mot de passe obligatoire");
        lblError.setVisible(true);
        }else{
            Admin admin =service.seConnecter(login, password);
            if(admin == null){
                lblError.setText("Login ou mot de passe incorret");
                lblError.setVisible(true);
            }else{
               this.lblError.getScene().getWindow().hide();
               AnchorPane root;
               root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
            }
            
        }
    }
    
}
