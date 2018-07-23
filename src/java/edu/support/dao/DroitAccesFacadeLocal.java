/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.DroitAcces;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zos hall
 */
@Local
public interface DroitAccesFacadeLocal {

    void create(DroitAcces droitAcces);

    void edit(DroitAcces droitAcces);

    void remove(DroitAcces droitAcces);

    DroitAcces find(Object id);

    List<DroitAcces> findAll();

    List<DroitAcces> findRange(int[] range);

    int count();
    
}
