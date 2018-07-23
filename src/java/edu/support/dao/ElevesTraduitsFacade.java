/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.ElevesTraduits;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zos hall
 */
@Stateless
public class ElevesTraduitsFacade extends AbstractFacade<ElevesTraduits> implements ElevesTraduitsFacadeLocal {

    @PersistenceContext(unitName = "edusupportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ElevesTraduitsFacade() {
        super(ElevesTraduits.class);
    }
    
}
