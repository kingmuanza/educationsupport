/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.ConseilDiscipline;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface ConseilDisciplineFacadeLocal {

    void create(ConseilDiscipline conseilDiscipline);

    void edit(ConseilDiscipline conseilDiscipline);

    void remove(ConseilDiscipline conseilDiscipline);

    ConseilDiscipline find(Object id);

    List<ConseilDiscipline> findAll();

    List<ConseilDiscipline> findRange(int[] range);

    int count();
    
}
