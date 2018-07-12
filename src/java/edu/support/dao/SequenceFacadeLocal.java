/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Sequence;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface SequenceFacadeLocal {

    void create(Sequence sequence);

    void edit(Sequence sequence);

    void remove(Sequence sequence);

    Sequence find(Object id);

    List<Sequence> findAll();

    List<Sequence> findRange(int[] range);

    int count();
    
}
