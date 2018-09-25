/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.UtilisateurFonctionnalite;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author N9-T
 */
@Stateless
public class UtilisateurFonctionnaliteFacade extends AbstractFacade<UtilisateurFonctionnalite> implements UtilisateurFonctionnaliteFacadeLocal {

    @PersistenceContext(unitName = "edusupportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFonctionnaliteFacade() {
        super(UtilisateurFonctionnalite.class);
    }
    
}
