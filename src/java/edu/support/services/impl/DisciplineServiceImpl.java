/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.services.impl;

import edu.support.entities.Absence;
import edu.support.entities.ConseilDiscipline;
import edu.support.entities.Convocation;
import edu.support.entities.Eleve;
import edu.support.entities.ElevesTraduits;
import edu.support.entities.Retard;
import edu.support.entities.Sanction;
import edu.support.services.DisciplineService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author N9-T
 */
public class DisciplineServiceImpl implements DisciplineService{

    @Override
    public List<Absence> getAbsences(Eleve e) {
        return (List) e.getAbsenceCollection();
    }

    @Override
    public List<Retard> getRetards(Eleve e) {
        return (List)e.getRetardCollection();
    }

    @Override
    public List<Convocation> getConvocations(Eleve e) {
        return (List)e.getConvocationCollection();
    }

    @Override
    public List<Sanction> getSanctions(Eleve e) {
        return (List)e.getSanctionCollection();
    }

    @Override
    public List<ConseilDiscipline> getConseilDisciplines(Eleve e) {
        List<ConseilDiscipline> lcd = new ArrayList<>();
        for(ElevesTraduits et: e.getElevesTraduitsCollection())
            lcd.add(et.getConseilDisciplineIdconseilDiscipline());
        return lcd;
    }
    
}
