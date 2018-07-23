/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Activite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zos hall
 */
@Local
public interface ActiviteFacadeLocal {

    void create(Activite activite);

    void edit(Activite activite);

    void remove(Activite activite);

    Activite find(Object id);

    List<Activite> findAll();

    List<Activite> findRange(int[] range);

    int count();
    
}
