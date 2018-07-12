/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Maladie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface MaladieFacadeLocal {

    void create(Maladie maladie);

    void edit(Maladie maladie);

    void remove(Maladie maladie);

    Maladie find(Object id);

    List<Maladie> findAll();

    List<Maladie> findRange(int[] range);

    int count();
    
}
