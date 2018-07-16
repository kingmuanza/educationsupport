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

/**
 *
 * @author N9-T
 */
public class SolvabiliteServiceImpl implements SolvabiliteService{

    @Override
    public boolean isSolvable(Eleve e) {
        double som = 0.0;
        for(Paiement p: e.getPaiementCollection())
            som += p.getMontant();
        return StaticVars.FRAIS_EXIGIBLES <= som;
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
    
}
