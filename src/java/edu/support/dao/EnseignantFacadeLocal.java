/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Enseignant;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface EnseignantFacadeLocal {

    void create(Enseignant enseignant);

    void edit(Enseignant enseignant);

    void remove(Enseignant enseignant);

    Enseignant find(Object id);

    List<Enseignant> findAll();

    List<Enseignant> findRange(int[] range);

    int count();
    
}
