/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.SalleDeClasse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface SalleDeClasseFacadeLocal {

    void create(SalleDeClasse salleDeClasse);

    void edit(SalleDeClasse salleDeClasse);

    void remove(SalleDeClasse salleDeClasse);

    SalleDeClasse find(Object id);

    List<SalleDeClasse> findAll();

    List<SalleDeClasse> findRange(int[] range);

    int count();
    
}
