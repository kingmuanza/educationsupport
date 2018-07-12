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
@Table(name = "relance", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relance.findAll", query = "SELECT r FROM Relance r")
    , @NamedQuery(name = "Relance.findByIdrelance", query = "SELECT r FROM Relance r WHERE r.idrelance = :idrelance")
    , @NamedQuery(name = "Relance.findByMontant", query = "SELECT r FROM Relance r WHERE r.montant = :montant")
    , @NamedQuery(name = "Relance.findByEcheance", query = "SELECT r FROM Relance r WHERE r.echeance = :echeance")
    , @NamedQuery(name = "Relance.findByCreated", query = "SELECT r FROM Relance r WHERE r.created = :created")
    , @NamedQuery(name = "Relance.findByModified", query = "SELECT r FROM Relance r WHERE r.modified = :modified")
    , @NamedQuery(name = "Relance.findByDeleted", query = "SELECT r FROM Relance r WHERE r.deleted = :deleted")})
public class Relance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrelance", nullable = false)
    private Integer idrelance;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "motif", nullable = false, length = 65535)
    private String motif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant", nullable = false)
    private double montant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "echeance", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date echeance;
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

    public Relance() {
    }

    public Relance(Integer idrelance) {
        this.idrelance = idrelance;
    }

    public Relance(Integer idrelance, String motif, double montant, Date echeance, Date created, Date modified, short deleted) {
        this.idrelance = idrelance;
        this.motif = motif;
        this.montant = montant;
        this.echeance = echeance;
        this.created = created;
        this.modified = modified;
        this.deleted = deleted;
    }

    public Integer getIdrelance() {
        return idrelance;
    }

    public void setIdrelance(Integer idrelance) {
        this.idrelance = idrelance;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelance != null ? idrelance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relance)) {
            return false;
        }
        Relance other = (Relance) object;
        if ((this.idrelance == null && other.idrelance != null) || (this.idrelance != null && !this.idrelance.equals(other.idrelance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Relance[ idrelance=" + idrelance + " ]";
    }
    
}
