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
import javax.persistence.Id;
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
@Table(name = "annee_scolaire", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"date_debut", "date_fin"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnneeScolaire.findAll", query = "SELECT a FROM AnneeScolaire a")
    , @NamedQuery(name = "AnneeScolaire.findByIdanneeScolaire", query = "SELECT a FROM AnneeScolaire a WHERE a.idanneeScolaire = :idanneeScolaire")
    , @NamedQuery(name = "AnneeScolaire.findByDateDebut", query = "SELECT a FROM AnneeScolaire a WHERE a.dateDebut = :dateDebut")
    , @NamedQuery(name = "AnneeScolaire.findByDateFin", query = "SELECT a FROM AnneeScolaire a WHERE a.dateFin = :dateFin")
    , @NamedQuery(name = "AnneeScolaire.findByEnCours", query = "SELECT a FROM AnneeScolaire a WHERE a.enCours = :enCours")
    , @NamedQuery(name = "AnneeScolaire.findByCreated", query = "SELECT a FROM AnneeScolaire a WHERE a.created = :created")
    , @NamedQuery(name = "AnneeScolaire.findByModified", query = "SELECT a FROM AnneeScolaire a WHERE a.modified = :modified")
    , @NamedQuery(name = "AnneeScolaire.findByDeleted", query = "SELECT a FROM AnneeScolaire a WHERE a.deleted = :deleted")})
public class AnneeScolaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idannee_scolaire", nullable = false)
    private Integer idanneeScolaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "date_debut", nullable = false, length = 45)
    private String dateDebut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "date_fin", nullable = false, length = 45)
    private String dateFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "en_cours", nullable = false)
    private boolean enCours;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anneeScolaireIdanneeScolaire", fetch = FetchType.LAZY)
    private Collection<Sequence> sequenceCollection;

    public AnneeScolaire() {
    }

    public AnneeScolaire(Integer idanneeScolaire) {
        this.idanneeScolaire = idanneeScolaire;
    }

    public AnneeScolaire(Integer idanneeScolaire, String dateDebut, String dateFin, boolean enCours, boolean deleted) {
        this.idanneeScolaire = idanneeScolaire;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.enCours = enCours;
        this.deleted = deleted;
    }

    public Integer getIdanneeScolaire() {
        return idanneeScolaire;
    }

    public void setIdanneeScolaire(Integer idanneeScolaire) {
        this.idanneeScolaire = idanneeScolaire;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public boolean getEnCours() {
        return enCours;
    }

    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
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

    @XmlTransient
    public Collection<Sequence> getSequenceCollection() {
        return sequenceCollection;
    }

    public void setSequenceCollection(Collection<Sequence> sequenceCollection) {
        this.sequenceCollection = sequenceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idanneeScolaire != null ? idanneeScolaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnneeScolaire)) {
            return false;
        }
        AnneeScolaire other = (AnneeScolaire) object;
        if ((this.idanneeScolaire == null && other.idanneeScolaire != null) || (this.idanneeScolaire != null && !this.idanneeScolaire.equals(other.idanneeScolaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.AnneeScolaire[ idanneeScolaire=" + idanneeScolaire + " ]";
    }
    
}
