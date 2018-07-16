/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Eleve;
import edu.support.entities.PassageInfirmerie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface PassageInfirmerieFacadeLocal {

    void create(PassageInfirmerie passageInfirmerie);

    void edit(PassageInfirmerie passageInfirmerie);

    void remove(PassageInfirmerie passageInfirmerie);

    PassageInfirmerie find(Object id);

    List<PassageInfirmerie> findAll();

    List<PassageInfirmerie> findRange(int[] range);

    int count();
    
    //custom methods
    
    /**
     * retourne la liste des passages à l'infirmerie pour un étudiant donné
     * @param e
     * @return 
     */
    public List<PassageInfirmerie> findByEleve(Eleve e);
    
}
