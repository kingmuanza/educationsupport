/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.CompteParentEleve;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface CompteParentEleveFacadeLocal {

    void create(CompteParentEleve compteParentEleve);

    void edit(CompteParentEleve compteParentEleve);

    void remove(CompteParentEleve compteParentEleve);

    CompteParentEleve find(Object id);

    List<CompteParentEleve> findAll();

    List<CompteParentEleve> findRange(int[] range);

    int count();
    
}
