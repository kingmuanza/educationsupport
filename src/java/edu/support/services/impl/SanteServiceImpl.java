/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.services.impl;

import edu.support.dao.EleveFacadeLocal;
import edu.support.dao.EleveMaladieFacadeLocal;
import edu.support.dao.PassageInfirmerieFacadeLocal;
import edu.support.entities.Classe;
import edu.support.entities.Eleve;
import edu.support.entities.EleveMaladie;
import edu.support.entities.Maladie;
import edu.support.entities.PassageInfirmerie;
import edu.support.services.SanteService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author N9-T
 */
public class SanteServiceImpl implements SanteService{

    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    @EJB(mappedName="java:app/edusupport/PassageInfirmerieFacade")
    private PassageInfirmerieFacadeLocal pifl;
    
    @EJB(mappedName="java:app/edusupport/EleveMaladieFacade")
    private EleveMaladieFacadeLocal emfl;
    
    @Override
    public List<PassageInfirmerie> getPassageInfirmerie(Eleve e) {
        return (List)e.getPassageInfirmerieCollection();
    }

    @Override
    public List<Eleve> getElevesMalades() {
        List<Eleve> le = new ArrayList<>();
        for(EleveMaladie em: emfl.findAll())
            le.add(em.getEleveIdeleve());
        return le;
    }

    @Override
    public List<Eleve> getElevesMaladesByClasse(Classe c) {
        List<Eleve> le = new ArrayList<>();
        c.getEleveCollection().stream().filter((e) -> (isEleveMalade(e))).forEachOrdered((e) -> {
            le.add(e);
        });
        return le;
    }

    @Override
    public List<Eleve> getElevesBYMaladies(Maladie m) {
        List<Eleve> le = new ArrayList<>();
        for(EleveMaladie em : emfl.findAll()){
            if(em.getMaladieIdmaladie().equals(m))
                le.add(em.getEleveIdeleve());
        }
        return le;
    }

    @Override
    public boolean isEleveMalade(Eleve e) {
        return getElevesMalades().contains(e);
    }
    
}
