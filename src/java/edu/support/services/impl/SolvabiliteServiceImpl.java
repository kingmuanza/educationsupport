/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.services.impl;

import edu.support.entities.Eleve;
import edu.support.entities.Moratoire;
import edu.support.entities.Paiement;
import edu.support.entities.Relance;
import edu.support.services.SolvabiliteService;
import edu.support.utils.StaticVars;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author N9-T
 */
@Stateless
public class SolvabiliteServiceImpl implements SolvabiliteService{

    @Override
    public boolean isSolvable(Eleve e) {
        double som = 0.0;
        for(Paiement p: e.getPaiementCollection())
            som += p.getMontant();
        return e.getSalleDeClasseIdsalleDeClasse().getClasseIdclasse().getFraisScolarite() <= som;
    }

    @Override
    public List<Paiement> getPaiements(Eleve e) {
        return (List)e.getPaiementCollection();
    }

    @Override
    public List<Moratoire> getMoratoire(Eleve e) {
        return (List)e.getMoratoireCollection();
    }

    @Override
    public List<Relance> getRelances(Eleve e) {
        return (List)e.getRelanceCollection();
    }
    
    @Override
    public double getMontantPaye(Eleve e){
        double montant = 0.0;
        for(Paiement p: e.getPaiementCollection())
            montant += p.getMontant();
        return montant;
    }
    
    @Override
    public double getMontantRestant(Eleve e){
        double montant = 0.0;
        for(Paiement p: e.getPaiementCollection())
            montant += p.getMontant();
        System.out.println(e.getSalleDeClasseIdsalleDeClasse().getClasseIdclasse().getFraisScolarite());
        return e.getSalleDeClasseIdsalleDeClasse().getClasseIdclasse().getFraisScolarite() - montant;
    }
}
