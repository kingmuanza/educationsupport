/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.services;

import edu.support.entities.Evaluation;
import java.util.List;

/**
 *
 * @author N9-T
 */
public interface InformationService {
    
    /**
     * méthode qui va retourner les examens de l'année en cours
     * @return 
     */
    List<Evaluation> getExamens();
}
