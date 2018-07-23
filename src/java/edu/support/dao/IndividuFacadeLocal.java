/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Individu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zos hall
 */
@Local
public interface IndividuFacadeLocal {

    void create(Individu individu);

    void edit(Individu individu);

    void remove(Individu individu);

    Individu find(Object id);

    List<Individu> findAll();

    List<Individu> findRange(int[] range);

    int count();
    
}
