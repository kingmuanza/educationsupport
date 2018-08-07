/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zos hall
 */
@Entity
@Table(name = "paiement", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paiement.findAll", query = "SELECT p FROM Paiement p")
    , @NamedQuery(name = "Paiement.findByIdpaiement", query = "SELECT p FROM Paiement p WHERE p.idpaiement = :idpaiement")
    , @NamedQuery(name = "Paiement.findByCode", query = "SELECT p FROM Paiement p WHERE p.code = :code")
    , @NamedQuery(name = "Paiement.findByMontant", query = "SELECT p FROM Paiement p WHERE p.montant = :montant")
    , @NamedQuery(name = "Paiement.findByDateJour", query = "SELECT p FROM Paiement p WHERE p.dateJour = :dateJour")
    , @NamedQuery(name = "Paiement.findByCreated", query = "SELECT p FROM Paiement p WHERE p.created = :created")
    , @NamedQuery(name = "Paiement.findByModified", query = "SELECT p FROM Paiement p WHERE p.modified = :modified")
    , @NamedQuery(name = "Paiement.findByDeleted", query = "SELECT p FROM Paiement p WHERE p.deleted = :deleted")})
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaiement", nullable = false)
    private Integer idpaiement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant", nullable = false)
    private double montant;
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
    @ManyToOne(optional = false)
    @JsonIgnore
    private Eleve eleveIdeleve;

    public Paiement() {
    }

    public Paiement(Integer idpaiement) {
        this.idpaiement = idpaiement;
    }

    public Paiement(Integer idpaiement, String code, double montant, Date dateJour, boolean deleted) {
        this.idpaiement = idpaiement;
        this.code = code;
        this.montant = montant;
        this.dateJour = dateJour;
        this.deleted = deleted;
    }

    public Integer getIdpaiement() {
        return idpaiement;
    }

    public void setIdpaiement(Integer idpaiement) {
        this.idpaiement = idpaiement;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
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
        hash += (idpaiement != null ? idpaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.idpaiement == null && other.idpaiement != null) || (this.idpaiement != null && !this.idpaiement.equals(other.idpaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Paiement[ idpaiement=" + idpaiement + " ]";
    }
    
}
