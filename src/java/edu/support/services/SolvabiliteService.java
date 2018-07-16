/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.services;

import edu.support.entities.Eleve;
import edu.support.entities.Moratoire;
import edu.support.entities.Paiement;
import edu.support.entities.Relance;
import java.util.List;

/**
 *
 * @author N9-T
 */
public interface SolvabiliteService {
    /*
    retourne un booléen selon que l'élève est solvable ou non
    */
    public boolean isSolvable(Eleve e);
    
    /*
    retourne la liste des paiements de l'élève
    */
    public List<Paiement> getPaiements(Eleve e);
    
    /*
    retourne la liste des moratoires
    */
    public List<Moratoire> getMoratoire(Eleve e);
    
    /*
    retourne la liste des relances
    */
    public List<Relance> getRelances(Eleve e);

}
