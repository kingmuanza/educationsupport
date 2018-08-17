/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Convocation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface ConvocationFacadeLocal {

    void create(Convocation convocation);

    void edit(Convocation convocation);

    void remove(Convocation convocation);

    Convocation find(Object id);

    List<Convocation> findAll();

    List<Convocation> findRange(int[] range);

    int count();
    
}
