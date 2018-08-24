/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Evaluation;
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
public class EvaluationFacade extends AbstractFacade<Evaluation> implements EvaluationFacadeLocal {

    @PersistenceContext(unitName = "edusupportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluationFacade() {
        super(Evaluation.class);
    }
    
    @Override
    public List<Evaluation> findAllAnneeEnCours(){
        EntityManager entityManager = getEntityManager();
        Query q;
        try{
            q = entityManager.createQuery("from Evaluation e where e.sequenceIdsequence.anneeScolaireIdanneeScolaire.enCours=true");
            return q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
