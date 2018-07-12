/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.IndividuUtilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface IndividuUtilisateurFacadeLocal {

    void create(IndividuUtilisateur individuUtilisateur);

    void edit(IndividuUtilisateur individuUtilisateur);

    void remove(IndividuUtilisateur individuUtilisateur);

    IndividuUtilisateur find(Object id);

    List<IndividuUtilisateur> findAll();

    List<IndividuUtilisateur> findRange(int[] range);

    int count();
    
}
