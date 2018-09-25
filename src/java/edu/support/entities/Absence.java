/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "absence", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Absence.findAll", query = "SELECT a FROM Absence a")
    , @NamedQuery(name = "Absence.findByIdabsence", query = "SELECT a FROM Absence a WHERE a.idabsence = :idabsence")
    , @NamedQuery(name = "Absence.findByJourAbsence", query = "SELECT a FROM Absence a WHERE a.jourAbsence = :jourAbsence")
    , @NamedQuery(name = "Absence.findByJustifiee", query = "SELECT a FROM Absence a WHERE a.justifiee = :justifiee")
    , @NamedQuery(name = "Absence.findByCreated", query = "SELECT a FROM Absence a WHERE a.created = :created")
    , @NamedQuery(name = "Absence.findByModified", query = "SELECT a FROM Absence a WHERE a.modified = :modified")
    , @NamedQuery(name = "Absence.findByDeleted", query = "SELECT a FROM Absence a WHERE a.deleted = :deleted")})
public class Absence implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "justifiee", nullable = false)
    private boolean justifiee;
    @Lob
    @Size(max = 65535)
    @Column(name = "motif", length = 65535)
    private String motif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idabsence", nullable = false)
    private Integer idabsence;
    @Basic(optional = false)
    @Column(name = "jour_absence", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date jourAbsence;
    @Basic(optional = false)
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created;
    @Basic(optional = false)
    @Column(name = "modified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modified;
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false)
    private Eleve eleveIdeleve;

    public Absence() {
    }

    public Absence(Integer idabsence) {
        this.idabsence = idabsence;
    }

    public Absence(Integer idabsence, Date jourAbsence, boolean justifiee, Date created, Date modified, boolean deleted) {
        this.idabsence = idabsence;
        this.jourAbsence = jourAbsence;
        this.justifiee = justifiee;
        this.created = created;
        this.modified = modified;
        this.deleted = deleted;
    }

    public Integer getIdabsence() {
        return idabsence;
    }

    public void setIdabsence(Integer idabsence) {
        this.idabsence = idabsence;
    }

    public Date getJourAbsence() {
        return jourAbsence;
    }

    public void setJourAbsence(Date jourAbsence) {
        this.jourAbsence = jourAbsence;
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


    public Eleve getEleveIdeleve() {
        return eleveIdeleve;
    }

    public void setEleveIdeleve(Eleve eleveIdeleve) {
        this.eleveIdeleve = eleveIdeleve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idabsence != null ? idabsence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Absence)) {
            return false;
        }
        Absence other = (Absence) object;
        if ((this.idabsence == null && other.idabsence != null) || (this.idabsence != null && !this.idabsence.equals(other.idabsence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Absence[ idabsence=" + idabsence + " ]";
    }

    public boolean getJustifiee() {
        return justifiee;
    }

    public void setJustifiee(boolean justifiee) {
        this.justifiee = justifiee;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
}
