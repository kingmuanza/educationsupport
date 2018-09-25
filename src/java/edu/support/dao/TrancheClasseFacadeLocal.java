/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.TrancheClasse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface TrancheClasseFacadeLocal {

    void create(TrancheClasse trancheClasse);

    void edit(TrancheClasse trancheClasse);

    void remove(TrancheClasse trancheClasse);

    TrancheClasse find(Object id);

    List<TrancheClasse> findAll();

    List<TrancheClasse> findRange(int[] range);

    int count();
    
}
