/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.PassageInfirmerie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author N9-T
 */
@Stateless
public class PassageInfirmerieFacade extends AbstractFacade<PassageInfirmerie> implements PassageInfirmerieFacadeLocal {

    @PersistenceContext(unitName = "edusupportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PassageInfirmerieFacade() {
        super(PassageInfirmerie.class);
    }

    @Override
    public List<PassageInfirmerie> findByDates(String date1, String date2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
