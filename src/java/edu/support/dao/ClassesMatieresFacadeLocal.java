/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.ClassesMatieres;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface ClassesMatieresFacadeLocal {

    void create(ClassesMatieres classesMatieres);

    void edit(ClassesMatieres classesMatieres);

    void remove(ClassesMatieres classesMatieres);

    ClassesMatieres find(Object id);

    List<ClassesMatieres> findAll();

    List<ClassesMatieres> findRange(int[] range);

    int count();
    
}
