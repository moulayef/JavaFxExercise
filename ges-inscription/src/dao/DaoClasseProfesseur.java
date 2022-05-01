/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public class DaoClasseProfesseur implements IDao<ClasseProfesseur>{
    private String SQL_INSERT="INSERT INTO `classe` (`filiere`, `niveau`) VALUES (?,?);";
    private String SQL_UPDATE="UPDATE `classe` SET `filiere` = ?, `niveau` = ? WHERE `classe`.`id_classe` = ?;";
    private String SQL_SELECTALL="SELECT * FROM `classe`";
    private String SQL_SELECTBYID="SELECT * FROM `classe` WHERE `id_classe` = ?";
    private String SQL_DELETE="DELETE * FROM `classe` WHERE `id_classe` = ?";
    public int insert(int idProf, int idClasse){
        return 0;
    }

    @Override
    public int insert(ClasseProfesseur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(ClasseProfesseur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ClasseProfesseur> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClasseProfesseur selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
