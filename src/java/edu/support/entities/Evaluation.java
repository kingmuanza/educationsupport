/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "evaluation", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e")
    , @NamedQuery(name = "Evaluation.findByIdevaluation", query = "SELECT e FROM Evaluation e WHERE e.idevaluation = :idevaluation")})
public class Evaluation implements Serializable {

    @Column(name = "date_evaluation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEvaluation;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private short deleted;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idevaluation", nullable = false)
    private Integer idevaluation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluationIdevaluation", fetch = FetchType.LAZY)
    private Collection<Note> noteCollection;
    @JoinColumn(name = "classe_idclasse", referencedColumnName = "idclasse", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Classe classeIdclasse;
    @JoinColumn(name = "matiere_idmatiere", referencedColumnName = "idmatiere", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Matiere matiereIdmatiere;
    @JoinColumn(name = "sequence_idsequence", referencedColumnName = "idsequence", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sequence sequenceIdsequence;

    public Evaluation() {
    }

    public Evaluation(Integer idevaluation) {
        this.idevaluation = idevaluation;
    }

    public Integer getIdevaluation() {
        return idevaluation;
    }

    public void setIdevaluation(Integer idevaluation) {
        this.idevaluation = idevaluation;
    }

    @XmlTransient
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }

    public Classe getClasseIdclasse() {
        return classeIdclasse;
    }

    public void setClasseIdclasse(Classe classeIdclasse) {
        this.classeIdclasse = classeIdclasse;
    }

    public Matiere getMatiereIdmatiere() {
        return matiereIdmatiere;
    }

    public void setMatiereIdmatiere(Matiere matiereIdmatiere) {
        this.matiereIdmatiere = matiereIdmatiere;
    }

    public Sequence getSequenceIdsequence() {
        return sequenceIdsequence;
    }

    public void setSequenceIdsequence(Sequence sequenceIdsequence) {
        this.sequenceIdsequence = sequenceIdsequence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevaluation != null ? idevaluation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.idevaluation == null && other.idevaluation != null) || (this.idevaluation != null && !this.idevaluation.equals(other.idevaluation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Evaluation[ idevaluation=" + idevaluation + " ]";
    }

    public Date getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(Date dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public short getDeleted() {
        return deleted;
    }

    public void setDeleted(short deleted) {
        this.deleted = deleted;
    }
    
}
