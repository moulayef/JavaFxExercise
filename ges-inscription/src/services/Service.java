/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DaoAdmin;
import dao.DaoClasse;
import dao.DaoClasseProfesseur;
import dao.DaoProfesseur;
import entity.Admin;
import entity.Classe;
import entity.Professeur;
import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public class Service implements IService{
    private DaoClasse daoClasse=new DaoClasse();
    private DaoProfesseur daoProfesseur=new DaoProfesseur();
    private DaoClasseProfesseur daoClasseProfesseur=new DaoClasseProfesseur();
    private DaoAdmin daoAdmin=new DaoAdmin();

    @Override
    public boolean ajoutClasse(Classe classe) {
        return daoClasse.insert(classe)!=0;
    }

    @Override
    public boolean modifierClasse(Classe classe) {
         return daoClasse.update(classe)!=0;
    }

    @Override
    public boolean supprimerClasse(int id) {
        return daoClasse.delete(id)!=0;
    }

    @Override
    public ArrayList<Classe> listerClasse() {
        return daoClasse.selectAll();
    }
    
    @Override
    public boolean ajouterProfesseur(Professeur professeur) {
        return daoProfesseur.insert(professeur)!=0;
    }

    @Override
    public boolean affecterClasse(Professeur professeur, ArrayList<Professeur> classes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Professeur> listerProfesseur() {
        return daoProfesseur.selectAll();
    }

    @Override
    public ArrayList<Classe> filtrerClasseProfesseur(Professeur professeur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin seConnecter(String login, String password) {
        return daoAdmin.selectAdminByLoginAndPassword(login,password);
    }

    public boolean supprimerClasse(Classe intSelected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean ajoutClasse(String classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
