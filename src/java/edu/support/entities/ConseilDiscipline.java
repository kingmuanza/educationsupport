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
@Table(name = "conseil_discipline", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConseilDiscipline.findAll", query = "SELECT c FROM ConseilDiscipline c")
    , @NamedQuery(name = "ConseilDiscipline.findByIdconseilDiscipline", query = "SELECT c FROM ConseilDiscipline c WHERE c.idconseilDiscipline = :idconseilDiscipline")
    , @NamedQuery(name = "ConseilDiscipline.findByCode", query = "SELECT c FROM ConseilDiscipline c WHERE c.code = :code")
    , @NamedQuery(name = "ConseilDiscipline.findByLibelle", query = "SELECT c FROM ConseilDiscipline c WHERE c.libelle = :libelle")
    , @NamedQuery(name = "ConseilDiscipline.findByDateDebut", query = "SELECT c FROM ConseilDiscipline c WHERE c.dateDebut = :dateDebut")
    , @NamedQuery(name = "ConseilDiscipline.findByDateFin", query = "SELECT c FROM ConseilDiscipline c WHERE c.dateFin = :dateFin")
    , @NamedQuery(name = "ConseilDiscipline.findByCreated", query = "SELECT c FROM ConseilDiscipline c WHERE c.created = :created")
    , @NamedQuery(name = "ConseilDiscipline.findByModified", query = "SELECT c FROM ConseilDiscipline c WHERE c.modified = :modified")
    , @NamedQuery(name = "ConseilDiscipline.findByDeleted", query = "SELECT c FROM ConseilDiscipline c WHERE c.deleted = :deleted")})
public class ConseilDiscipline implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Size(max = 45)
    @Column(name = "libelle", length = 45)
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conseilDisciplineIdconseilDiscipline", fetch = FetchType.EAGER)
    private Collection<EleveTraduit> eleveTraduitCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconseil_discipline", nullable = false)
    private Integer idconseilDiscipline;
    @Column(name = "rapport", length = 254)
    private String rapport;
    @Column(name = "date_debut")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateFin;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modified;
    @Basic(optional = false)
    
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conseilDisciplineIdconseilDiscipline")
    private Collection<ElevesTraduits> elevesTraduitsCollection;

    public ConseilDiscipline() {
    }

    public ConseilDiscipline(Integer idconseilDiscipline) {
        this.idconseilDiscipline = idconseilDiscipline;
    }

    public ConseilDiscipline(Integer idconseilDiscipline, String code, boolean deleted) {
        this.idconseilDiscipline = idconseilDiscipline;
        this.code = code;
        this.deleted = deleted;
    }

    public Integer getIdconseilDiscipline() {
        return idconseilDiscipline;
    }

    public void setIdconseilDiscipline(Integer idconseilDiscipline) {
        this.idconseilDiscipline = idconseilDiscipline;
    }


    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
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

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    @XmlTransient
    public Collection<EleveTraduit> getEleveTraduitCollection() {
        return eleveTraduitCollection;
    }

    public void setEleveTraduitCollection(Collection<EleveTraduit> eleveTraduitCollection) {
        this.eleveTraduitCollection = eleveTraduitCollection;
    }
    
}
