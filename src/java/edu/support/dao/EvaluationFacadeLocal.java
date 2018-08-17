/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Evaluation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface EvaluationFacadeLocal {

    void create(Evaluation evaluation);

    void edit(Evaluation evaluation);

    void remove(Evaluation evaluation);

    Evaluation find(Object id);

    List<Evaluation> findAll();

    List<Evaluation> findRange(int[] range);

    int count();
    
}
