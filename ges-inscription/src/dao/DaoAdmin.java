/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilisateur
 */
public class DaoAdmin implements IDao<Admin> {
    private String SQL_CONNECT="SELECT * FROM user WHERE login=? and password=?";
    
    private String SQL_INSERT="INSERT INTO `classe` (`filiere`, `niveau`) VALUES (?,?);";
    private String SQL_UPDATE="UPDATE `classe` SET `filiere` = ?, `niveau` = ? WHERE `classe`.`id_classe` = ?;";
    private String SQL_SELECTALL="SELECT * FROM `classe`";
    private String SQL_SELECTBYID="SELECT * FROM `classe` WHERE `id_classe` = ?";
    private String SQL_DELETE="DELETE * FROM `classe` WHERE `id_classe` = ?";
    
    public Admin selectAdminByLoginAndPassword(String login, String password){
        DaoMysql mysql = new DaoMysql();
        mysql.ouvrirConnexionBD();
        mysql.preparerRequete(SQL_CONNECT);
        try {
            mysql.getPs().setString(1, login);
            mysql.getPs().setString(2,password);
            ResultSet rs=mysql.executeSelect();
            if (rs.next()){
                Admin admin = new Admin();
                admin.setId(rs.getInt("id_user"));
                admin.setLogin(rs.getString("login"));
                admin.setPassword(rs.getString("password"));
                return admin;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        mysql.closeConnexion();
        return null;
    }

    @Override
    public int insert(Admin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Admin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Admin> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
