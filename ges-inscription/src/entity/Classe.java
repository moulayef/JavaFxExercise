/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public class Classe {
    private int id;
    private String libelle;

    private String filiere;
    private String niveau;

   private ArrayList<Professeur> professeurs=new ArrayList();

    public ArrayList<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(ArrayList<Professeur> professeurs) {
        this.professeurs = professeurs;
    }
   
    public Classe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setClasse(String classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
