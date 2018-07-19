/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "conseil_discipline", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConseilDiscipline.findAll", query = "SELECT c FROM ConseilDiscipline c")
    , @NamedQuery(name = "ConseilDiscipline.findByIdconseilDiscipline", query = "SELECT c FROM ConseilDiscipline c WHERE c.idconseilDiscipline = :idconseilDiscipline")
    , @NamedQuery(name = "ConseilDiscipline.findByCode", query = "SELECT c FROM ConseilDiscipline c WHERE c.code = :code")
    , @NamedQuery(name = "ConseilDiscipline.findByDateDebut", query = "SELECT c FROM ConseilDiscipline c WHERE c.dateDebut = :dateDebut")
    , @NamedQuery(name = "ConseilDiscipline.findByDateFin", query = "SELECT c FROM ConseilDiscipline c WHERE c.dateFin = :dateFin")
    , @NamedQuery(name = "ConseilDiscipline.findByCreated", query = "SELECT c FROM ConseilDiscipline c WHERE c.created = :created")
    , @NamedQuery(name = "ConseilDiscipline.findByModified", query = "SELECT c FROM ConseilDiscipline c WHERE c.modified = :modified")
    , @NamedQuery(name = "ConseilDiscipline.findByBoolean1", query = "SELECT c FROM ConseilDiscipline c WHERE c.boolean1 = :boolean1")})
public class ConseilDiscipline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconseil_discipline", nullable = false)
    private Integer idconseilDiscipline;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_debut", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_fin", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boolean", nullable = false)
    private boolean boolean1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conseilDisciplineIdconseilDiscipline", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<ElevesTraduits> elevesTraduitsCollection;

    public ConseilDiscipline() {
    }

    public ConseilDiscipline(Integer idconseilDiscipline) {
        this.idconseilDiscipline = idconseilDiscipline;
    }

    public ConseilDiscipline(Integer idconseilDiscipline, String code, Date dateDebut, Date dateFin, boolean boolean1) {
        this.idconseilDiscipline = idconseilDiscipline;
        this.code = code;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.boolean1 = boolean1;
    }

    public Integer getIdconseilDiscipline() {
        return idconseilDiscipline;
    }

    public void setIdconseilDiscipline(Integer idconseilDiscipline) {
        this.idconseilDiscipline = idconseilDiscipline;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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

    public boolean getBoolean1() {
        return boolean1;
    }

    public void setBoolean1(boolean boolean1) {
        this.boolean1 = boolean1;
    }

    @XmlTransient
    public Collection<ElevesTraduits> getElevesTraduitsCollection() {
        return elevesTraduitsCollection;
    }

    public void setElevesTraduitsCollection(Collection<ElevesTraduits> elevesTraduitsCollection) {
        this.elevesTraduitsCollection = elevesTraduitsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconseilDiscipline != null ? idconseilDiscipline.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConseilDiscipline)) {
            return false;
        }
        ConseilDiscipline other = (ConseilDiscipline) object;
        if ((this.idconseilDiscipline == null && other.idconseilDiscipline != null) || (this.idconseilDiscipline != null && !this.idconseilDiscipline.equals(other.idconseilDiscipline))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.ConseilDiscipline[ idconseilDiscipline=" + idconseilDiscipline + " ]";
    }
    
}
