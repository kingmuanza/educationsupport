/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.CompteParent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface CompteParentFacadeLocal {

    void create(CompteParent compteParent);

    void edit(CompteParent compteParent);

    void remove(CompteParent compteParent);

    CompteParent find(Object id);

    List<CompteParent> findAll();

    List<CompteParent> findRange(int[] range);

    int count();
    
}
