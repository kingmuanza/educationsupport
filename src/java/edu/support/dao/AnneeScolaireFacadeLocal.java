/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.AnneeScolaire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface AnneeScolaireFacadeLocal {

    void create(AnneeScolaire anneeScolaire);

    void edit(AnneeScolaire anneeScolaire);

    void remove(AnneeScolaire anneeScolaire);

    AnneeScolaire find(Object id);

    List<AnneeScolaire> findAll();

    List<AnneeScolaire> findRange(int[] range);

    int count();
    
}
