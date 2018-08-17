/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Matiere;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface MatiereFacadeLocal {

    void create(Matiere matiere);

    void edit(Matiere matiere);

    void remove(Matiere matiere);

    Matiere find(Object id);

    List<Matiere> findAll();

    List<Matiere> findRange(int[] range);

    int count();
    
}
