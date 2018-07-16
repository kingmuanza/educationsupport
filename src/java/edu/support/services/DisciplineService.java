/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.services;

import edu.support.entities.Absence;
import edu.support.entities.ConseilDiscipline;
import edu.support.entities.Convocation;
import edu.support.entities.Eleve;
import edu.support.entities.Retard;
import edu.support.entities.Sanction;
import java.util.List;

/**
 *
 * @author N9-T
 */
public interface DisciplineService {
    
    /*
    retourne la liste des absences d'un élève
    */
    public List<Absence> getAbsences(Eleve e);
    
    /*
    retourne la liste des retards d'un élève
    */
    public List<Retard> getRetards(Eleve e);
    
    /*
    retourne la liste des convocations d'un élève
    */
    public List<Convocation> getConvocations(Eleve e);
    
    /*
    retourne la liste des sanctions d'un élève
    */
    public List<Sanction> getSanctions(Eleve e);
    
    /*
    retourne la liste des conseil de discipline d'un élève
    */
    public List<ConseilDiscipline> getConseilDisciplines(Eleve e);
}
