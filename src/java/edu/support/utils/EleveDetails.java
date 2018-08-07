/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.support.entities.Absence;
import edu.support.entities.Eleve;
import edu.support.entities.Note;
import edu.support.entities.Paiement;
import edu.support.entities.Retard;
import edu.support.entities.Sanction;
import java.util.List;

/**
 *
 * @author N9-T
 */
public class EleveDetails {
    @JsonProperty
    private List<Absence> absences;
    @JsonProperty
    private List<Retard> retards;
    @JsonProperty
    private List<Sanction> sanctions;
    @JsonProperty
    private List<Paiement> paiements;
    @JsonProperty
    private List<Note> notes;
    private Eleve eleve;
    
    public EleveDetails(Eleve e) {
        eleve = e;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }

    public void setRetards(List<Retard> retards) {
        this.retards = retards;
    }

    public void setSanctions(List<Sanction> sanctions) {
        this.sanctions = sanctions;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Eleve getEleve() {
        return eleve;
    }
    
    
}
