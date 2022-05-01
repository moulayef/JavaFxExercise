/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Admin;
import entity.Classe;
import entity.Professeur;
import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public interface IService {
    //Use case gérer classe
    //Ajouter une nouvelle classe
    boolean ajoutClasse(Classe classe);
    boolean modifierClasse(Classe classe);
    boolean supprimerClasse(int id);
    ArrayList<Classe> listerClasse();
    
    //Use case affecter classe
    boolean ajouterProfesseur(Professeur professeur);
    boolean affecterClasse(Professeur professeur, ArrayList<Professeur>classes);
    
    //Use case lister les professeurs
    ArrayList<Professeur> listerProfesseur();
    ArrayList<Classe>filtrerClasseProfesseur(Professeur professeur);
    
        Admin seConnecter(String login, String password);
}
