/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.UtilisateursFonctionnalites;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface UtilisateursFonctionnalitesFacadeLocal {

    void create(UtilisateursFonctionnalites utilisateursFonctionnalites);

    void edit(UtilisateursFonctionnalites utilisateursFonctionnalites);

    void remove(UtilisateursFonctionnalites utilisateursFonctionnalites);

    UtilisateursFonctionnalites find(Object id);

    List<UtilisateursFonctionnalites> findAll();

    List<UtilisateursFonctionnalites> findRange(int[] range);

    int count();
    
}
