/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DaoMysql;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Utilisateur
 */
public class Main {
    private static String SQL_INSERT="INSERT INTO `classe` (`filiere`, `niveau`) VALUES (?,?);";
    private static String SQL_UPDATE="UPDATE `classe` SET `filiere` = ?, `niveau` = ? WHERE `classe`.`id_classe` = ?;";
    private static String SQL_SELECTALL="SELECT * FROM `classe`";
    private static String SQL_SELECTBYID="SELECT * FROM `classe` WHERE `id_classe` = ?";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        DaoMysql mysql= new DaoMysql();
        mysql.ouvrirConnexionBD();
        mysql.preparerRequete(SQL_INSERT);
        mysql.getPs().setString(1, "IAGE");
        mysql.getPs().setString(2,"L3");
        int id = mysql.executeMisAJour();
        ResultSet rs = mysql.getPs().getGeneratedKeys();//select max(id_classe) from classe
        if (rs.next()){
    
            System.out.println(rs.getInt(1));
        }
        //System.out.println(id);
        mysql.closeConnexion();
    }
    
}
