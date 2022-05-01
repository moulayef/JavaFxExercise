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
public interface IDao <T>{
    int insert (T obj);
    int update (T obj);
    int delete (int id);
    ArrayList<T> selectAll();
    T selectById(int id);
}
