/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Moratoire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface MoratoireFacadeLocal {

    void create(Moratoire moratoire);

    void edit(Moratoire moratoire);

    void remove(Moratoire moratoire);

    Moratoire find(Object id);

    List<Moratoire> findAll();

    List<Moratoire> findRange(int[] range);

    int count();
    
}
