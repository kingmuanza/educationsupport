/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Trimestre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface TrimestreFacadeLocal {

    void create(Trimestre trimestre);

    void edit(Trimestre trimestre);

    void remove(Trimestre trimestre);

    Trimestre find(Object id);

    List<Trimestre> findAll();

    List<Trimestre> findRange(int[] range);

    int count();
    
}
