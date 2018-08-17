/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.ConseilDiscipline;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author N9-T
 */
@Stateless
public class ConseilDisciplineFacade extends AbstractFacade<ConseilDiscipline> implements ConseilDisciplineFacadeLocal {

    @PersistenceContext(unitName = "edusupportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConseilDisciplineFacade() {
        super(ConseilDiscipline.class);
    }
    
}
