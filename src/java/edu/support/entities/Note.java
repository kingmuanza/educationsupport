/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zos hall
 */
@Entity
@Table(name = "note", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n")
    , @NamedQuery(name = "Note.findByIdnote", query = "SELECT n FROM Note n WHERE n.idnote = :idnote")
    , @NamedQuery(name = "Note.findByValeur", query = "SELECT n FROM Note n WHERE n.valeur = :valeur")
    , @NamedQuery(name = "Note.findByCreated", query = "SELECT n FROM Note n WHERE n.created = :created")
    , @NamedQuery(name = "Note.findByModified", query = "SELECT n FROM Note n WHERE n.modified = :modified")
    , @NamedQuery(name = "Note.findByDeleted", query = "SELECT n FROM Note n WHERE n.deleted = :deleted")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnote", nullable = false)
    private Integer idnote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valeur", nullable = false)
    private double valeur;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Eleve eleveIdeleve;
    @JoinColumn(name = "evaluation_idevaluation", referencedColumnName = "idevaluation", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Evaluation evaluationIdevaluation;

    public Note() {
    }

    public Note(Integer idnote) {
        this.idnote = idnote;
    }

    public Note(Integer idnote, double valeur, boolean deleted) {
        this.idnote = idnote;
        this.valeur = valeur;
        this.deleted = deleted;
    }

    public Integer getIdnote() {
        return idnote;
    }

    public void setIdnote(Integer idnote) {
        this.idnote = idnote;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
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

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Eleve getEleveIdeleve() {
        return eleveIdeleve;
    }

    public void setEleveIdeleve(Eleve eleveIdeleve) {
        this.eleveIdeleve = eleveIdeleve;
    }

    public Evaluation getEvaluationIdevaluation() {
        return evaluationIdevaluation;
    }

    public void setEvaluationIdevaluation(Evaluation evaluationIdevaluation) {
        this.evaluationIdevaluation = evaluationIdevaluation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnote != null ? idnote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.idnote == null && other.idnote != null) || (this.idnote != null && !this.idnote.equals(other.idnote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Note[ idnote=" + idnote + " ]";
    }
    
}
