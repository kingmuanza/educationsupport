/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface UtilisateurFacadeLocal {

    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);

    int count();
    
    //
    
    /**
     * retourne un utilisateur en fonction des ses login et password
     * @param login
     * @param motDePasse
     * @return 
     */
    public Utilisateur findByCredentials(String login, String motDePasse);    
}
