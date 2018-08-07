/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers.rest;

import edu.support.dao.EleveFacadeLocal;
import edu.support.entities.Absence;
import edu.support.entities.AutorisationSortie;
import edu.support.entities.ConseilDiscipline;
import edu.support.entities.Convocation;
import edu.support.entities.Eleve;
import edu.support.entities.EleveMaladie;
import edu.support.entities.ElevesTraduits;
import edu.support.entities.Maladie;
import edu.support.entities.Moratoire;
import edu.support.entities.Note;
import edu.support.entities.Paiement;
import edu.support.entities.PassageInfirmerie;
import edu.support.entities.Retard;
import edu.support.entities.Sanction;
import edu.support.services.impl.SanteServiceImpl;
import edu.support.services.impl.SolvabiliteServiceImpl;
import edu.support.utils.EleveDetails;
import edu.support.utils.StaticVars;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author N9-T
 */
@RestController("EleveControllerREST")
@RequestMapping("/api/eleves")
public class EleveControllerRest {
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
//    @RequestMapping("/list")
//    public List<Eleve> getAllEleves(){
//        return efl.findAll();
//    }
    
    @RequestMapping("/get/{id}")
    @Produces("application/json")
    public Eleve getEleve(@PathVariable("id") int id){
        return efl.find(id);
    }
    
    // INFORMATIONS SUR LA SANTE DE L'ETUDIANT
    /**
     * retourne un booléen selon que l'étudiant a déclaré ou non une maladie
     * @param id
     * @return 
     */
    @RequestMapping("/sante/ismalade/{id}")
    public boolean isMalade(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        return new SanteServiceImpl().isEleveMalade(e);
    }
    
    /**
     * retourne la liste des maladies déclarées par un étudiant
     * @param id
     * @return 
     */
    @RequestMapping("/sante/maladies/{id}")
    public List<Maladie> getEleveMaladies(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        List<Maladie> maladies = new ArrayList<>();
        for(EleveMaladie em: e.getEleveMaladieCollection())
            maladies.add(em.getMaladieIdmaladie());
        return maladies;
    }
    
    /**
     * retourne la liste des passages à l'infirmerie d'un élève
     * @param id
     * @return 
     */
    @RequestMapping("/sante/passageinfirmeries/{id}")
    public List<PassageInfirmerie> getElevePassageInfirmeries(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        return (List)e.getPassageInfirmerieCollection();
    }
    
    //*******************               *******************//
    //              INFORMATIONS SUR LA SOLVABILITE
    //*******************               *******************//
    
    @RequestMapping("/solvabilite/issolvable/{id}")
    public boolean isSolvable(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        return new SolvabiliteServiceImpl().isSolvable(e);
    }
    
    @RequestMapping("/solvabilite/paiements/{id}")
    public List<Paiement> getElevePaiements(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        return (List)e.getPaiementCollection();
    }
    
    @RequestMapping("/solvabilite/moratoires/{id}")
    public List<Moratoire> getEleveMoratoires(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        return (List)e.getMoratoireCollection();
    }
    
    @RequestMapping("/solvabilite/relances/{id}")
    public List<Moratoire> getEleveRelances(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        return (List)e.getRelanceCollection();
    }
    
    //*******************               *******************//
    //              INFORMATIONS SUR LA DISCIPLINE
    //*******************               *******************//
    
    @RequestMapping("/discipline/autorisationsorties/{id}")
    public List<AutorisationSortie> getEleveAutorisationSorties(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        return (List)e.getAutorisationSortieCollection();
    }
    
    @RequestMapping("/discipline/absences/{id}")
    public List<Absence> getEleveAbsences(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        return (List)e.getIndividuIdindividu().getAbsenceCollection();
    }
    
    @RequestMapping("/discipline/nombreheureabsences/{id}")
    public int getEleveHeureAbsences(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        int som =0;
        for(Absence a: e.getIndividuIdindividu().getAbsenceCollection()){
            if(!a.getJustifee())
                som += a.getIdabsence();
        }
        return som;
    }
    
    @RequestMapping("/discipline/retards/{id}")
    public List<Retard> getEleveRetards(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        return (List)e.getIndividuIdindividu().getRetardCollection();
    }
    
    @RequestMapping("/discipline/convocations/{id}")
    public List<Convocation> getEleveConvocations(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        return (List)e.getConvocationCollection();
    }
    
    @RequestMapping("/discipline/sanctions/{id}")
    public List<Sanction> getEleveSanctions(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        return (List)e.getSanctionCollection();
    }
    
    @RequestMapping("/discipline/conseildisciplines/{id}")
    public List<ConseilDiscipline> getEleveConseilDisciplines(@PathVariable("id") int id){
        Eleve e = efl.find(id);
        List<ConseilDiscipline> conseilDisciplines = new ArrayList<>();
        for(ElevesTraduits et: e.getElevesTraduitsCollection())
            conseilDisciplines.add(et.getConseilDisciplineIdconseilDiscipline());
        return conseilDisciplines;
    }
    
    //*******************               *******************//
    //              INFORMATIONS SUR LES RESULTATS
    //*******************               *******************//
    
    @RequestMapping("/resultat/notes/{id}")
    public List<Note> getEleveNotes(@PathVariable("id")int id){
        Eleve e = efl.find(id);
        return (List)e.getNoteCollection();
    }
    
    @RequestMapping("/resultat/moyenne/{id}")
    public double getEleveMoyenne(@PathVariable("id")int id){
        Eleve e = efl.find(id);
        return calculMoyenne(e);
    }
    
    @RequestMapping("/resultat/rang/{id}")
    public int getEleveRang(@PathVariable("id")int id){
        Eleve e = efl.find(id);
        List<Eleve> leseleves = efl.findAll();
        Collections.sort(leseleves,(a,b)-> calculMoyenne(a) < calculMoyenne(b) ? - 1 : calculMoyenne(a) == calculMoyenne(b) ? 0 : 1);
        return leseleves.indexOf(e)+1;
    }
    
    //*******************               *******************//
    //              Détails d'un éleve
    //*******************               *******************//
    @RequestMapping(value="/details/{id}", produces="application/json")
    public EleveDetails getEleveDetails(@PathVariable("id")int id){
        Eleve eleve = efl.find(id);
        EleveDetails ed = new EleveDetails(eleve);
        return initializeEleveDetails(ed);
    }
    @RequestMapping(value="/list", produces="application/json")
    public List<EleveDetails> getAllEleveDetails(){
        List<EleveDetails> led = new ArrayList<>();
        for(Eleve e: efl.findAll()){
            EleveDetails ed = new EleveDetails(e);
            led.add(initializeEleveDetails(ed));
        }
        return led;
    }
    
    private double calculMoyenne(Eleve e){
        List<Note> lesnotes = (List)e.getNoteCollection();
        double som = 0;
        int somCoef = 0;
        for(Note n: lesnotes){
            som += n.getValeur();
            somCoef += n.getEvaluationIdevaluation().getMatiereIdmatiere().getCoefficient();
        }
        return som / somCoef;
    }
    
    private EleveDetails initializeEleveDetails(EleveDetails ed){
        ed.setAbsences((List)ed.getEleve().getIndividuIdindividu().getAbsenceCollection());
        ed.setRetards((List)ed.getEleve().getIndividuIdindividu().getRetardCollection());
        ed.setSanctions((List)ed.getEleve().getSanctionCollection());
        ed.setPaiements((List)ed.getEleve().getPaiementCollection());
        ed.setNotes((List)ed.getEleve().getNoteCollection());
        ed.getSolvabilite().setIsSolvable(new SolvabiliteServiceImpl().isSolvable(ed.getEleve()));
        double som = 0.0;
        for(Paiement p: ed.getEleve().getPaiementCollection())
            som += p.getMontant();
        ed.getSolvabilite().setMontantPaye(som);
        ed.getSolvabilite().setMontantDu(StaticVars.FRAIS_EXIGIBLES - som);
        return ed;
    }
}
