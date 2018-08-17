/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Retard;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface RetardFacadeLocal {

    void create(Retard retard);

    void edit(Retard retard);

    void remove(Retard retard);

    Retard find(Object id);

    List<Retard> findAll();

    List<Retard> findRange(int[] range);

    int count();
    
}
