/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.services;

import edu.support.entities.Eleve;
import edu.support.entities.Note;
import java.util.List;

/**
 *
 * @author N9-T
 */
public interface ResultatService {
    
    /**
     *retourne le rang de l'étudiant dans sa classe
     * @param e
     * @return 
    */
    public int getRang(Eleve e);
    
    /**
     * retourne la moyenne de l'élève
     * @param e
     * @return 
     */
    public double getMoyenne(Eleve e);
    
    /**
     * retourne les notes de l'élève
     * @param e
     * @return 
     */
    public List<Note> getNotes(Eleve e);
}
