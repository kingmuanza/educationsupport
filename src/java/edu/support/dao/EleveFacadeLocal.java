/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Eleve;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zos hall
 */
@Local
public interface EleveFacadeLocal {

    void create(Eleve eleve);

    void edit(Eleve eleve);

    void remove(Eleve eleve);

    Eleve find(Object id);

    List<Eleve> findAll();

    List<Eleve> findRange(int[] range);

    int count();
    
}
