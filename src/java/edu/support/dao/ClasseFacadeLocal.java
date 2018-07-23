/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Classe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zos hall
 */
@Local
public interface ClasseFacadeLocal {

    void create(Classe classe);

    void edit(Classe classe);

    void remove(Classe classe);

    Classe find(Object id);

    List<Classe> findAll();

    List<Classe> findRange(int[] range);

    int count();
    
}
