/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.services;

import edu.support.entities.Classe;
import edu.support.entities.Eleve;
import edu.support.entities.Maladie;
import edu.support.entities.PassageInfirmerie;
import java.util.List;

/**
 *
 * @author N9-T
 */
public interface SanteService {
    /*
    retourne la liste des passages à l'infirmerie pour un étudiant donné
    */
    public List<PassageInfirmerie> getPassageInfirmerie(Eleve e);
    
    /*
    retourne la liste des élèves qui ont déclarés une maladie
    */
    public List<Eleve> getElevesMalades();
    
    /*
    retourne la liste des élèves d'une même classe qui ont déclarés une maladie
    */
    public List<Eleve> getElevesMaladesByClasse(Classe c);
    
    /*
    retourne la liste des élèves qui ont déclarés une maladie donnée
    */
    public List<Eleve> getElevesBYMaladies(Maladie m);
    
    /*
    retourne un booléen selon que l'élève ait déclaré ou non une maladie
    */
    public boolean isEleveMalade(Eleve e);
    
}
