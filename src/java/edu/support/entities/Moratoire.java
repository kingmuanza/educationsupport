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

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "moratoire", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moratoire.findAll", query = "SELECT m FROM Moratoire m")
    , @NamedQuery(name = "Moratoire.findByIdmoratoire", query = "SELECT m FROM Moratoire m WHERE m.idmoratoire = :idmoratoire")
    , @NamedQuery(name = "Moratoire.findByCode", query = "SELECT m FROM Moratoire m WHERE m.code = :code")
    , @NamedQuery(name = "Moratoire.findByDateFinValidite", query = "SELECT m FROM Moratoire m WHERE m.dateFinValidite = :dateFinValidite")
    , @NamedQuery(name = "Moratoire.findByEtat", query = "SELECT m FROM Moratoire m WHERE m.etat = :etat")
    , @NamedQuery(name = "Moratoire.findByCreated", query = "SELECT m FROM Moratoire m WHERE m.created = :created")
    , @NamedQuery(name = "Moratoire.findByModified", query = "SELECT m FROM Moratoire m WHERE m.modified = :modified")
    , @NamedQuery(name = "Moratoire.findByDeleted", query = "SELECT m FROM Moratoire m WHERE m.deleted = :deleted")})
public class Moratoire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmoratoire", nullable = false)
    private Integer idmoratoire;
    @Basic(optional = false)
    
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Column(name = "date_fin_validite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinValidite;
    @Lob
    @Size(max = 65535)
    @Column(name = "reponse", length = 65535)
    private String reponse;
    @Basic(optional = false)
    
    @Column(name = "etat", nullable = false)
    private int etat;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false)
    private Eleve eleveIdeleve;

    public Moratoire() {
    }

    public Moratoire(Integer idmoratoire) {
        this.idmoratoire = idmoratoire;
    }

    public Moratoire(Integer idmoratoire, String code, int etat, boolean deleted) {
        this.idmoratoire = idmoratoire;
        this.code = code;
        this.etat = etat;
        this.deleted = deleted;
    }

    public Integer getIdmoratoire() {
        return idmoratoire;
    }

    public void setIdmoratoire(Integer idmoratoire) {
        this.idmoratoire = idmoratoire;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateFinValidite() {
        return dateFinValidite;
    }

    public void setDateFinValidite(Date dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
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

    public boolean isDeleted() {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmoratoire != null ? idmoratoire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moratoire)) {
            return false;
        }
        Moratoire other = (Moratoire) object;
        if ((this.idmoratoire == null && other.idmoratoire != null) || (this.idmoratoire != null && !this.idmoratoire.equals(other.idmoratoire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Moratoire[ idmoratoire=" + idmoratoire + " ]";
    }
    
}
