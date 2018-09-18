/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers.rest;

import edu.support.dao.EvaluationFacadeLocal;
import edu.support.dao.ReunionFacadeLocal;
import edu.support.entities.Evaluation;
import edu.support.entities.Reunion;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author N9-T
 */
@RestController
@RequestMapping("/api/informations")
public class InformationsControllerRest {
    
    @EJB(mappedName="java:app/edusupport/ReunionFacade")
    private ReunionFacadeLocal refl;
    
    @EJB(mappedName="java:app/edusupport/EvaluationFacade")
    private EvaluationFacadeLocal efl;
    
    @RequestMapping(value="/reunions/list", produces="application/json")
    public List<Reunion> getListReunion(){
        return refl.findAll();
    }
    
    @RequestMapping(value="/evaluations/list", produces="application/json")
    public List<Evaluation> getListEvaluation(){
        return efl.findAll();
    }
}
