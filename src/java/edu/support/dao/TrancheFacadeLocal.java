/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Tranche;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface TrancheFacadeLocal {

    void create(Tranche tranche);

    void edit(Tranche tranche);

    void remove(Tranche tranche);

    Tranche find(Object id);

    List<Tranche> findAll();

    List<Tranche> findRange(int[] range);

    int count();
    
}
