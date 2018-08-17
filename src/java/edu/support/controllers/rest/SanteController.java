/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers.rest;

import edu.support.dao.SalleDeClasseFacadeLocal;
import edu.support.dao.EleveFacadeLocal;
import edu.support.dao.EleveMaladieFacadeLocal;
import edu.support.dao.MaladieFacadeLocal;
import edu.support.dao.PassageInfirmerieFacadeLocal;
import edu.support.entities.SalleDeClasse;
import edu.support.entities.Eleve;
import edu.support.entities.EleveMaladie;
import edu.support.entities.Maladie;
import edu.support.entities.PassageInfirmerie;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author N9-T
 */
@RestController("SanteControllerREST")
@RequestMapping("/api/sante")
public class SanteController {
    @EJB(mappedName="java:app/edusupport/EleveMaladieFacade")
    private EleveMaladieFacadeLocal emfl;
    
    @EJB(mappedName="java:app/edusupport/SalleDeClasseFacade")
    private SalleDeClasseFacadeLocal cfl;
    
    @EJB(mappedName="java:app/edusupport/MaladieFacade")
    private MaladieFacadeLocal mfl;
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    @EJB(mappedName="java:app/edusupport/PassageInfirmerieFacade")
    private PassageInfirmerieFacadeLocal pifl;
    
    @RequestMapping(value = "/eleves-malades", produces = {"application/json"})
    public List<Eleve> getElevesMalades() {
        List<Eleve> le = new ArrayList<>();
        for(EleveMaladie em: emfl.findAll())
            le.add(em.getEleveIdeleve());
        return le;
    }
    
    @RequestMapping(value = "/eleves-malades-par-classe/{idSalleDeClasse}" , produces = {"application/json"})
    public List<Eleve> getElevesMaladesBySalleDeClasse(@PathVariable("idSalleDeClasse")int idSalleDeClasse) {
        List<Eleve> le = new ArrayList<>();
        SalleDeClasse c = cfl.find(idSalleDeClasse);
        for(Eleve e: c.getEleveCollection()){
            if(!e.getEleveMaladieCollection().isEmpty())
                le.add(e);
        }
        return le;
    }
    
    @RequestMapping(value = "/eleves-par-maladie/{idMaladie}" , produces = {"application/json"})
    public List<Eleve> getElevesBYMaladies(@PathVariable("idMaladie")int idMaladie) {
        List<Eleve> le = new ArrayList<>();
        Maladie m = mfl.find(idMaladie);
        for(EleveMaladie em : m.getEleveMaladieCollection()){
            le.add(em.getEleveIdeleve());
        }
        return le;
    }
    
    @RequestMapping(value = "/is-eleve-malade/{idEleve}", produces = {"application/json"})
    public boolean isEleveMalade(@PathVariable("idEleve")int idEleve) {
        Eleve e = efl.find(idEleve);
        return !e.getEleveMaladieCollection().isEmpty();
    }
    
    @RequestMapping(value = "passages-infirmeries/{date1}/{date2}")
    public List<PassageInfirmerie> getPassageInfirmeries(@PathVariable("date1")String date1,@PathVariable("date2")String date2) throws ParseException{
        
        return pifl.findByDates(date1, date2);
    }
    @RequestMapping(value = "passages-infirmeries", produces={"application/json"})
    public List<PassageInfirmerie> getPassageInfirmeries(){
        return pifl.findAll();
    }
}
