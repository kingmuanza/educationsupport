/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author N9-T
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "edusupportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    @Override
    public Utilisateur findByCredentials(String login, String pwd) {
        EntityManager entityManager = getEntityManager();
        Query q;
        try{
            q = entityManager.createQuery("from Utilisateur u where u.login =:login and u.motDePasse=:motDePasse");
            q.setParameter("login", login);
            q.setParameter("motDePasse", pwd);
            return (Utilisateur) q.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
