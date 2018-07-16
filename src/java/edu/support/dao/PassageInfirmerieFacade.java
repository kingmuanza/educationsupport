/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Eleve;
import edu.support.entities.PassageInfirmerie;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public List<PassageInfirmerie> findByEleve(Eleve e) {
        EntityManager entityManager = getEntityManager();
        Query q;
        try{
            q = em.createNamedQuery("SELECT pi FROM PassageInfirmerie pi WHERE pi.eleveIdeleve.ideleve=:id");
            q.setParameter("id", e.getIdeleve());
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            return new ArrayList<PassageInfirmerie>();
        }
    }
    
}
