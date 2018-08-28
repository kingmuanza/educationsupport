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
@Table(name = "retard", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Retard.findAll", query = "SELECT r FROM Retard r")
    , @NamedQuery(name = "Retard.findByIdretard", query = "SELECT r FROM Retard r WHERE r.idretard = :idretard")
    , @NamedQuery(name = "Retard.findByMarge", query = "SELECT r FROM Retard r WHERE r.marge = :marge")
    , @NamedQuery(name = "Retard.findByJourRetard", query = "SELECT r FROM Retard r WHERE r.jourRetard = :jourRetard")
    , @NamedQuery(name = "Retard.findByCreated", query = "SELECT r FROM Retard r WHERE r.created = :created")
    , @NamedQuery(name = "Retard.findByModified", query = "SELECT r FROM Retard r WHERE r.modified = :modified")
    , @NamedQuery(name = "Retard.findByDeleted", query = "SELECT r FROM Retard r WHERE r.deleted = :deleted")})
public class Retard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idretard", nullable = false)
    private Integer idretard;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marge", nullable = false)
    private int marge;
    @Column(name = "jour_retard")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jourRetard;
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
    @ManyToOne(optional = false)
    private Eleve eleveIdeleve;

    public Retard() {
    }

    public Retard(Integer idretard) {
        this.idretard = idretard;
    }

    public Retard(Integer idretard, int marge, boolean deleted) {
        this.idretard = idretard;
        this.marge = marge;
        this.deleted = deleted;
    }

    public Integer getIdretard() {
        return idretard;
    }

    public void setIdretard(Integer idretard) {
        this.idretard = idretard;
    }

    public int getMarge() {
        return marge;
    }

    public void setMarge(int marge) {
        this.marge = marge;
    }

    public Date getJourRetard() {
        return jourRetard;
    }

    public void setJourRetard(Date jourRetard) {
        this.jourRetard = jourRetard;
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
        hash += (idretard != null ? idretard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retard)) {
            return false;
        }
        Retard other = (Retard) object;
        if ((this.idretard == null && other.idretard != null) || (this.idretard != null && !this.idretard.equals(other.idretard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Retard[ idretard=" + idretard + " ]";
    }
    
}
