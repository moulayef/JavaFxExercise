/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Classe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilisateur
 */
public class DaoClasse implements IDao<Classe> {
    private String SQL_INSERT="INSERT INTO `classe` (`filiere`, `niveau`) VALUES (?,?);";
    private String SQL_UPDATE="UPDATE `classe` SET `filiere` = ?, `niveau` = ? WHERE `classe`.`id_classe` = ?;";
    private String SQL_SELECTALL="SELECT * FROM `classe`";
    private String SQL_SELECTBYID="SELECT * FROM `classe` WHERE `id_classe` = ?";
    private String SQL_DELETE="DELETE FROM `classe` WHERE `id_classe` = ?";
    public ArrayList<Classe> selectClasseByProfesseur(int id){
        return null;
    }

    @Override
    public int insert(Classe obj) {
        int id=0;
       DaoMysql mysql= new DaoMysql();
        mysql.ouvrirConnexionBD();
        mysql.preparerRequete(SQL_INSERT);
        try {
            mysql.getPs().setString(1, obj.getFiliere());
        } catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            mysql.getPs().setString(2,obj.getNiveau());
        } catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        mysql.executeMisAJour();
        ResultSet rs = null;
        try {
            rs = mysql.getPs().getGeneratedKeys(); //select max(id_classe) from classe
        } catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()){               
               id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(id);
        mysql.closeConnexion();
        return id;
    }

    @Override
    public int update(Classe obj) {
        int id=0;
        DaoMysql mysql= new DaoMysql();
        mysql.ouvrirConnexionBD();
        mysql.preparerRequete(SQL_UPDATE);
        try {
            mysql.getPs().setString(1, obj.getFiliere());
        } catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            mysql.getPs().setString(2,obj.getNiveau());
        } catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            mysql.getPs().setInt(3, obj.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        id = mysql.executeMisAJour();
        mysql.closeConnexion();
        return id;
    }

    @Override
    public int delete(int id) {
        int nbreLigneAff=0;
        DaoMysql mysql= new DaoMysql();
        mysql.ouvrirConnexionBD();
        mysql.preparerRequete(SQL_DELETE);
        try {
            mysql.getPs().setInt(1, id);
           nbreLigneAff= mysql.executeMisAJour();
        } catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        mysql.closeConnexion();
        return nbreLigneAff;
       
    }

    @Override
    public ArrayList<Classe> selectAll() {
        ArrayList<Classe> classes = new ArrayList();
        DaoMysql mysql = new DaoMysql();
        mysql.ouvrirConnexionBD();
        mysql.preparerRequete(SQL_SELECTALL);
       
        ResultSet rs = mysql.executeSelect();
        try {
            while (rs.next()){
                Classe cl = new Classe();
                cl.setId(rs.getInt("id_classe"));
                cl.setFiliere(rs.getString("filiere"));
                cl.setNiveau(rs.getString("niveau"));
                cl.setLibelle(rs.getString("niveau")+rs.getString("filiere"));
                classes.add(cl);
            }} catch (SQLException ex) {
            Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        mysql.closeConnexion();
        return classes;
    }

    @Override
    public Classe selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
