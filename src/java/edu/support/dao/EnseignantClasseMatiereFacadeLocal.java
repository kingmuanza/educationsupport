/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.EnseignantClasseMatiere;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface EnseignantClasseMatiereFacadeLocal {

    void create(EnseignantClasseMatiere enseignantClasseMatiere);

    void edit(EnseignantClasseMatiere enseignantClasseMatiere);

    void remove(EnseignantClasseMatiere enseignantClasseMatiere);

    EnseignantClasseMatiere find(Object id);

    List<EnseignantClasseMatiere> findAll();

    List<EnseignantClasseMatiere> findRange(int[] range);

    int count();
    
}
