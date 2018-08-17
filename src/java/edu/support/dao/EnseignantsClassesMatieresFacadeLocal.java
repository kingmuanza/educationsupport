/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.EnseignantsClassesMatieres;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface EnseignantsClassesMatieresFacadeLocal {

    void create(EnseignantsClassesMatieres enseignantsClassesMatieres);

    void edit(EnseignantsClassesMatieres enseignantsClassesMatieres);

    void remove(EnseignantsClassesMatieres enseignantsClassesMatieres);

    EnseignantsClassesMatieres find(Object id);

    List<EnseignantsClassesMatieres> findAll();

    List<EnseignantsClassesMatieres> findRange(int[] range);

    int count();
    
}
