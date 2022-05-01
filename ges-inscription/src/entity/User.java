/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Utilisateur
 */
public class User {
    protected int id;
    protected String nomComplet;
    protected String role="ROLE_USER";

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    //méthodes
    //constructeur public porte le meme nom que la classe
    
    public User(){
    }
    
    //Getters
    public int getId(){
        return this.id;    
    }
    public String getNomComplet(){
        return this.nomComplet;
    }
    //Setters
    public void setId(int id){
        this.id=id;
    }
    public void setNomComplet(String nomComplet){
        this.nomComplet=nomComplet;
    }
}
