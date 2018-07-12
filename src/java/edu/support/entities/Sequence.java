/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsequence", nullable = false)
    private Integer idsequence;
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
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private short deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sequenceIdsequence", fetch = FetchType.EAGER)
    private List<Evaluation> evaluationList;
    @JoinColumn(name = "trimestre_idtrimestre", referencedColumnName = "idtrimestre", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Trimestre trimestreIdtrimestre;
    @JoinColumn(name = "annee_scolaire_idannee_scolaire", referencedColumnName = "idannee_scolaire", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private AnneeScolaire anneeScolaireIdanneeScolaire;

    public Sequence() {
    }

    public Sequence(Integer idsequence) {
        this.idsequence = idsequence;
    }

    public Sequence(Integer idsequence, String code, int numero, Date created, Date modified, short deleted) {
        this.idsequence = idsequence;
        this.code = code;
        this.numero = numero;
        this.created = created;
        this.modified = modified;
        this.deleted = deleted;
    }

    public Integer getIdsequence() {
        return idsequence;
    }

    public void setIdsequence(Integer idsequence) {
        this.idsequence = idsequence;
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

    @XmlTransient
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
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
    
}
