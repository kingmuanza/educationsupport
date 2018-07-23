/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.EleveMaladie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zos hall
 */
@Local
public interface EleveMaladieFacadeLocal {

    void create(EleveMaladie eleveMaladie);

    void edit(EleveMaladie eleveMaladie);

    void remove(EleveMaladie eleveMaladie);

    EleveMaladie find(Object id);

    List<EleveMaladie> findAll();

    List<EleveMaladie> findRange(int[] range);

    int count();
    
}
