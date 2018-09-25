/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.UtilisateurFonctionnalite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface UtilisateurFonctionnaliteFacadeLocal {

    void create(UtilisateurFonctionnalite utilisateurFonctionnalite);

    void edit(UtilisateurFonctionnalite utilisateurFonctionnalite);

    void remove(UtilisateurFonctionnalite utilisateurFonctionnalite);

    UtilisateurFonctionnalite find(Object id);

    List<UtilisateurFonctionnalite> findAll();

    List<UtilisateurFonctionnalite> findRange(int[] range);

    int count();
    
}
