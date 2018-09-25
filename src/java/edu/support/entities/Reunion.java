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
@Table(name = "reunion", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reunion.findAll", query = "SELECT r FROM Reunion r")
    , @NamedQuery(name = "Reunion.findByIdreunion", query = "SELECT r FROM Reunion r WHERE r.idreunion = :idreunion")
    , @NamedQuery(name = "Reunion.findByCode", query = "SELECT r FROM Reunion r WHERE r.code = :code")
    , @NamedQuery(name = "Reunion.findByLibelle", query = "SELECT r FROM Reunion r WHERE r.libelle = :libelle")
    , @NamedQuery(name = "Reunion.findByEtat", query = "SELECT r FROM Reunion r WHERE r.etat = :etat")
    , @NamedQuery(name = "Reunion.findByDateJour", query = "SELECT r FROM Reunion r WHERE r.dateJour = :dateJour")
    , @NamedQuery(name = "Reunion.findByCreated", query = "SELECT r FROM Reunion r WHERE r.created = :created")
    , @NamedQuery(name = "Reunion.findByModified", query = "SELECT r FROM Reunion r WHERE r.modified = :modified")
    , @NamedQuery(name = "Reunion.findByDeleted", query = "SELECT r FROM Reunion r WHERE r.deleted = :deleted")})
public class Reunion implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @NotNull    
    @Size(min = 1, max = 45)
    @Column(name = "libelle", nullable = false, length = 45)
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idreunion", nullable = false)
    private Integer idreunion;
    @Basic(optional = false)
    
    @Column(name = "etat", nullable = false)
    private int etat;
    @Basic(optional = false)
    @Column(name = "date_jour", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateJour;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modified;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reunionIdreunion")
    private Collection<Rapport> rapportCollection;

    public Reunion() {
    }

    public Reunion(Integer idreunion) {
        this.idreunion = idreunion;
    }

    public Reunion(Integer idreunion, String code, String libelle, int etat, Date dateJour, boolean deleted) {
        this.idreunion = idreunion;
        this.code = code;
        this.libelle = libelle;
        this.etat = etat;
        this.dateJour = dateJour;
        this.deleted = deleted;
    }

    public Integer getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Integer idreunion) {
        this.idreunion = idreunion;
    }


    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Date getDateJour() {
        return dateJour;
    }

    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
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
    public Collection<Rapport> getRapportCollection() {
        return rapportCollection;
    }

    public void setRapportCollection(Collection<Rapport> rapportCollection) {
        this.rapportCollection = rapportCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreunion != null ? idreunion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reunion)) {
            return false;
        }
        Reunion other = (Reunion) object;
        if ((this.idreunion == null && other.idreunion != null) || (this.idreunion != null && !this.idreunion.equals(other.idreunion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Reunion[ idreunion=" + idreunion + " ]";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
}
