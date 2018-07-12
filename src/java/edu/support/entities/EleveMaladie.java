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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "eleve_maladie", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EleveMaladie.findAll", query = "SELECT e FROM EleveMaladie e")
    , @NamedQuery(name = "EleveMaladie.findByIdeleveMaladie", query = "SELECT e FROM EleveMaladie e WHERE e.ideleveMaladie = :ideleveMaladie")
    , @NamedQuery(name = "EleveMaladie.findByCreated", query = "SELECT e FROM EleveMaladie e WHERE e.created = :created")
    , @NamedQuery(name = "EleveMaladie.findByModified", query = "SELECT e FROM EleveMaladie e WHERE e.modified = :modified")
    , @NamedQuery(name = "EleveMaladie.findByDeleted", query = "SELECT e FROM EleveMaladie e WHERE e.deleted = :deleted")})
public class EleveMaladie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideleve_maladie", nullable = false)
    private Integer ideleveMaladie;
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
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Eleve eleveIdeleve;
    @JoinColumn(name = "maladie_idmaladie", referencedColumnName = "idmaladie", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Maladie maladieIdmaladie;

    public EleveMaladie() {
    }

    public EleveMaladie(Integer ideleveMaladie) {
        this.ideleveMaladie = ideleveMaladie;
    }

    public EleveMaladie(Integer ideleveMaladie, Date created, Date modified, short deleted) {
        this.ideleveMaladie = ideleveMaladie;
        this.created = created;
        this.modified = modified;
        this.deleted = deleted;
    }

    public Integer getIdeleveMaladie() {
        return ideleveMaladie;
    }

    public void setIdeleveMaladie(Integer ideleveMaladie) {
        this.ideleveMaladie = ideleveMaladie;
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

    public Eleve getEleveIdeleve() {
        return eleveIdeleve;
    }

    public void setEleveIdeleve(Eleve eleveIdeleve) {
        this.eleveIdeleve = eleveIdeleve;
    }

    public Maladie getMaladieIdmaladie() {
        return maladieIdmaladie;
    }

    public void setMaladieIdmaladie(Maladie maladieIdmaladie) {
        this.maladieIdmaladie = maladieIdmaladie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideleveMaladie != null ? ideleveMaladie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EleveMaladie)) {
            return false;
        }
        EleveMaladie other = (EleveMaladie) object;
        if ((this.ideleveMaladie == null && other.ideleveMaladie != null) || (this.ideleveMaladie != null && !this.ideleveMaladie.equals(other.ideleveMaladie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.EleveMaladie[ ideleveMaladie=" + ideleveMaladie + " ]";
    }
    
}