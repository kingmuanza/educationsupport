/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.ClasseMatiere;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface ClasseMatiereFacadeLocal {

    void create(ClasseMatiere classeMatiere);

    void edit(ClasseMatiere classeMatiere);

    void remove(ClasseMatiere classeMatiere);

    ClasseMatiere find(Object id);

    List<ClasseMatiere> findAll();

    List<ClasseMatiere> findRange(int[] range);

    int count();
    
}
