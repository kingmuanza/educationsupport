/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Rapport;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface RapportFacadeLocal {

    void create(Rapport rapport);

    void edit(Rapport rapport);

    void remove(Rapport rapport);

    Rapport find(Object id);

    List<Rapport> findAll();

    List<Rapport> findRange(int[] range);

    int count();
    
}
