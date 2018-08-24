/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.services.impl;

import edu.support.dao.EvaluationFacadeLocal;
import edu.support.entities.Evaluation;
import edu.support.services.InformationService;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author N9-T
 */
public class InformationServiceImpl implements InformationService{
    
    @EJB(mappedName="java:app/edusupport/EvaluationFacade")
    private EvaluationFacadeLocal efl;

    @Override
    public List<Evaluation> getExamens() {
        return efl.findAllAnneeEnCours();
    }
    
}
