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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "maladie", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maladie.findAll", query = "SELECT m FROM Maladie m")
    , @NamedQuery(name = "Maladie.findByIdmaladie", query = "SELECT m FROM Maladie m WHERE m.idmaladie = :idmaladie")
    , @NamedQuery(name = "Maladie.findByCreated", query = "SELECT m FROM Maladie m WHERE m.created = :created")
    , @NamedQuery(name = "Maladie.findByModified", query = "SELECT m FROM Maladie m WHERE m.modified = :modified")
    , @NamedQuery(name = "Maladie.findByDeleted", query = "SELECT m FROM Maladie m WHERE m.deleted = :deleted")})
public class Maladie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmaladie", nullable = false)
    private Integer idmaladie;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nom", nullable = false, length = 65535)
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description", nullable = false, length = 65535)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "type_maladie", nullable = false, length = 65535)
    private String typeMaladie;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maladieIdmaladie", fetch = FetchType.EAGER)
    private List<EleveMaladie> eleveMaladieList;

    public Maladie() {
    }

    public Maladie(Integer idmaladie) {
        this.idmaladie = idmaladie;
    }

    public Maladie(Integer idmaladie, String nom, String description, String typeMaladie, Date created, Date modified, short deleted) {
        this.idmaladie = idmaladie;
        this.nom = nom;
        this.description = description;
        this.typeMaladie = typeMaladie;
        this.created = created;
        this.modified = modified;
        this.deleted = deleted;
    }

    public Integer getIdmaladie() {
        return idmaladie;
    }

    public void setIdmaladie(Integer idmaladie) {
        this.idmaladie = idmaladie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeMaladie() {
        return typeMaladie;
    }

    public void setTypeMaladie(String typeMaladie) {
        this.typeMaladie = typeMaladie;
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
    public List<EleveMaladie> getEleveMaladieList() {
        return eleveMaladieList;
    }

    public void setEleveMaladieList(List<EleveMaladie> eleveMaladieList) {
        this.eleveMaladieList = eleveMaladieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmaladie != null ? idmaladie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maladie)) {
            return false;
        }
        Maladie other = (Maladie) object;
        if ((this.idmaladie == null && other.idmaladie != null) || (this.idmaladie != null && !this.idmaladie.equals(other.idmaladie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Maladie[ idmaladie=" + idmaladie + " ]";
    }
    
}