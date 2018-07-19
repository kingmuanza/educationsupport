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
import javax.persistence.FetchType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "passage_infirmerie", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PassageInfirmerie.findAll", query = "SELECT p FROM PassageInfirmerie p")
    , @NamedQuery(name = "PassageInfirmerie.findByIdpassageInfirmerie", query = "SELECT p FROM PassageInfirmerie p WHERE p.idpassageInfirmerie = :idpassageInfirmerie")
    , @NamedQuery(name = "PassageInfirmerie.findByCode", query = "SELECT p FROM PassageInfirmerie p WHERE p.code = :code")
    , @NamedQuery(name = "PassageInfirmerie.findByDateJour", query = "SELECT p FROM PassageInfirmerie p WHERE p.dateJour = :dateJour")
    , @NamedQuery(name = "PassageInfirmerie.findByCreated", query = "SELECT p FROM PassageInfirmerie p WHERE p.created = :created")
    , @NamedQuery(name = "PassageInfirmerie.findByModified", query = "SELECT p FROM PassageInfirmerie p WHERE p.modified = :modified")
    , @NamedQuery(name = "PassageInfirmerie.findByDeleted", query = "SELECT p FROM PassageInfirmerie p WHERE p.deleted = :deleted")})
public class PassageInfirmerie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpassage_infirmerie", nullable = false)
    private Integer idpassageInfirmerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_jour", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateJour;
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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Eleve eleveIdeleve;

    public PassageInfirmerie() {
    }

    public PassageInfirmerie(Integer idpassageInfirmerie) {
        this.idpassageInfirmerie = idpassageInfirmerie;
    }

    public PassageInfirmerie(Integer idpassageInfirmerie, String code, Date dateJour, boolean deleted) {
        this.idpassageInfirmerie = idpassageInfirmerie;
        this.code = code;
        this.dateJour = dateJour;
        this.deleted = deleted;
    }

    public Integer getIdpassageInfirmerie() {
        return idpassageInfirmerie;
    }

    public void setIdpassageInfirmerie(Integer idpassageInfirmerie) {
        this.idpassageInfirmerie = idpassageInfirmerie;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpassageInfirmerie != null ? idpassageInfirmerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PassageInfirmerie)) {
            return false;
        }
        PassageInfirmerie other = (PassageInfirmerie) object;
        if ((this.idpassageInfirmerie == null && other.idpassageInfirmerie != null) || (this.idpassageInfirmerie != null && !this.idpassageInfirmerie.equals(other.idpassageInfirmerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.PassageInfirmerie[ idpassageInfirmerie=" + idpassageInfirmerie + " ]";
    }
    
}
