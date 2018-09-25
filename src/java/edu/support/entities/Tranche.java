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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "tranche", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tranche.findAll", query = "SELECT t FROM Tranche t")
    , @NamedQuery(name = "Tranche.findByIdtranche", query = "SELECT t FROM Tranche t WHERE t.idtranche = :idtranche")
    , @NamedQuery(name = "Tranche.findByCode", query = "SELECT t FROM Tranche t WHERE t.code = :code")
    , @NamedQuery(name = "Tranche.findByLibelle", query = "SELECT t FROM Tranche t WHERE t.libelle = :libelle")
    , @NamedQuery(name = "Tranche.findByMontant", query = "SELECT t FROM Tranche t WHERE t.montant = :montant")
    , @NamedQuery(name = "Tranche.findByDateLimite", query = "SELECT t FROM Tranche t WHERE t.dateLimite = :dateLimite")
    , @NamedQuery(name = "Tranche.findByCreated", query = "SELECT t FROM Tranche t WHERE t.created = :created")
    , @NamedQuery(name = "Tranche.findByModified", query = "SELECT t FROM Tranche t WHERE t.modified = :modified")
    , @NamedQuery(name = "Tranche.findByDeleted", query = "SELECT t FROM Tranche t WHERE t.deleted = :deleted")})
public class Tranche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtranche", nullable = false)
    private Integer idtranche;
    @Size(max = 45)
    @Column(name = "code", length = 45)
    private String code;
    @Size(max = 100)
    @Column(name = "libelle", length = 100)
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant", nullable = false)
    private double montant;
    @Column(name = "date_limite")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateLimite;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    public Tranche() {
    }

    public Tranche(Integer idtranche) {
        this.idtranche = idtranche;
    }

    public Tranche(Integer idtranche, double montant, boolean deleted) {
        this.idtranche = idtranche;
        this.montant = montant;
        this.deleted = deleted;
    }

    public Integer getIdtranche() {
        return idtranche;
    }

    public void setIdtranche(Integer idtranche) {
        this.idtranche = idtranche;
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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtranche != null ? idtranche.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tranche)) {
            return false;
        }
        Tranche other = (Tranche) object;
        if ((this.idtranche == null && other.idtranche != null) || (this.idtranche != null && !this.idtranche.equals(other.idtranche))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Tranche[ idtranche=" + idtranche + " ]";
    }
    
}
