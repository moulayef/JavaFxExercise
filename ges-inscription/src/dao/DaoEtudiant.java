/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Etudiant;
import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public class DaoEtudiant implements IDao<Etudiant>{
    
    private String SQL_CONNECT="SELECT * FROM user WHERE login=? and password=?";
    private String SQL_INSERT="INSERT INTO `classe` (`filiere`, `niveau`) VALUES (?,?);";
    private String SQL_UPDATE="UPDATE `classe` SET `filiere` = ?, `niveau` = ? WHERE `classe`.`id_classe` = ?;";
    private String SQL_SELECTALL="SELECT * FROM `classe`";
    private String SQL_SELECTBYID="SELECT * FROM `classe` WHERE `id_classe` = ?";
    private String SQL_DELETE="DELETE * FROM `classe` WHERE `id_classe` = ?";

    @Override
    public int insert(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Etudiant> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiant selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
