/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Relance;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface RelanceFacadeLocal {

    void create(Relance relance);

    void edit(Relance relance);

    void remove(Relance relance);

    Relance find(Object id);

    List<Relance> findAll();

    List<Relance> findRange(int[] range);

    int count();
    
}
