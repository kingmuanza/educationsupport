/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.EleveTraduit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface EleveTraduitFacadeLocal {

    void create(EleveTraduit eleveTraduit);

    void edit(EleveTraduit eleveTraduit);

    void remove(EleveTraduit eleveTraduit);

    EleveTraduit find(Object id);

    List<EleveTraduit> findAll();

    List<EleveTraduit> findRange(int[] range);

    int count();
    
}
