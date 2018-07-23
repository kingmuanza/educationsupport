/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.AutorisationSortie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zos hall
 */
@Local
public interface AutorisationSortieFacadeLocal {

    void create(AutorisationSortie autorisationSortie);

    void edit(AutorisationSortie autorisationSortie);

    void remove(AutorisationSortie autorisationSortie);

    AutorisationSortie find(Object id);

    List<AutorisationSortie> findAll();

    List<AutorisationSortie> findRange(int[] range);

    int count();
    
}
