/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.ElevesTraduits;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface ElevesTraduitsFacadeLocal {

    void create(ElevesTraduits elevesTraduits);

    void edit(ElevesTraduits elevesTraduits);

    void remove(ElevesTraduits elevesTraduits);

    ElevesTraduits find(Object id);

    List<ElevesTraduits> findAll();

    List<ElevesTraduits> findRange(int[] range);

    int count();
    
}
