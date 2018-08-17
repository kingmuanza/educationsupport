/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Fonctionnalite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface FonctionnaliteFacadeLocal {

    void create(Fonctionnalite fonctionnalite);

    void edit(Fonctionnalite fonctionnalite);

    void remove(Fonctionnalite fonctionnalite);

    Fonctionnalite find(Object id);

    List<Fonctionnalite> findAll();

    List<Fonctionnalite> findRange(int[] range);

    int count();
    
}
