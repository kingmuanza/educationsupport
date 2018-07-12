/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Absence;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface AbsenceFacadeLocal {

    void create(Absence absence);

    void edit(Absence absence);

    void remove(Absence absence);

    Absence find(Object id);

    List<Absence> findAll();

    List<Absence> findRange(int[] range);

    int count();
    
}
