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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "sequence", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sequence.findAll", query = "SELECT s FROM Sequence s")
    , @NamedQuery(name = "Sequence.findByIdsequence", query = "SELECT s FROM Sequence s WHERE s.idsequence = :idsequence")
    , @NamedQuery(name = "Sequence.findByCode", query = "SELECT s FROM Sequence s WHERE s.code = :code")
    , @NamedQuery(name = "Sequence.findByNumero", query = "SELECT s FROM Sequence s WHERE s.numero = :numero")
    , @NamedQuery(name = "Sequence.findByCreated", query = "SELECT s FROM Sequence s WHERE s.created = :created")
    , @NamedQuery(name = "Sequence.findByModified", query = "SELECT s FROM Sequence s WHERE s.modified = :modified")
    , @NamedQuery(name = "Sequence.findByDeleted", query = "SELECT s FROM Sequence s WHERE s.deleted = :deleted")})
public class Sequence implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero", nullable = false)
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsequence", nullable = false)
    private Integer idsequence;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modified;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sequenceIdsequence")
    private Collection<Evaluation> evaluationCollection;
    @JoinColumn(name = "trimestre_idtrimestre", referencedColumnName = "idtrimestre", nullable = false)
    @ManyToOne(optional = false)
    private Trimestre trimestreIdtrimestre;
    @JoinColumn(name = "annee_scolaire_idannee_scolaire", referencedColumnName = "idannee_scolaire", nullable = false)
    @ManyToOne(optional = false)
    private AnneeScolaire anneeScolaireIdanneeScolaire;

    public Sequence() {
    }

    public Sequence(Integer idsequence) {
        this.idsequence = idsequence;
    }

    public Sequence(Integer idsequence, String code, int numero, boolean deleted) {
        this.idsequence = idsequence;
        this.code = code;
        this.numero = numero;
        this.deleted = deleted;
    }

    public Integer getIdsequence() {
        return idsequence;
    }

    public void setIdsequence(Integer idsequence) {
        this.idsequence = idsequence;
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


    @XmlTransient
    public Collection<Evaluation> getEvaluationCollection() {
        return evaluationCollection;
    }

    public void setEvaluationCollection(Collection<Evaluation> evaluationCollection) {
        this.evaluationCollection = evaluationCollection;
    }

    public Trimestre getTrimestreIdtrimestre() {
        return trimestreIdtrimestre;
    }

    public void setTrimestreIdtrimestre(Trimestre trimestreIdtrimestre) {
        this.trimestreIdtrimestre = trimestreIdtrimestre;
    }

    public AnneeScolaire getAnneeScolaireIdanneeScolaire() {
        return anneeScolaireIdanneeScolaire;
    }

    public void setAnneeScolaireIdanneeScolaire(AnneeScolaire anneeScolaireIdanneeScolaire) {
        this.anneeScolaireIdanneeScolaire = anneeScolaireIdanneeScolaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsequence != null ? idsequence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sequence)) {
            return false;
        }
        Sequence other = (Sequence) object;
        if ((this.idsequence == null && other.idsequence != null) || (this.idsequence != null && !this.idsequence.equals(other.idsequence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Sequence[ idsequence=" + idsequence + " ]";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
}
