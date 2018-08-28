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
@Table(name = "fonctionnalite", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fonctionnalite.findAll", query = "SELECT f FROM Fonctionnalite f")
    , @NamedQuery(name = "Fonctionnalite.findByIdfonctionnalite", query = "SELECT f FROM Fonctionnalite f WHERE f.idfonctionnalite = :idfonctionnalite")
    , @NamedQuery(name = "Fonctionnalite.findByCode", query = "SELECT f FROM Fonctionnalite f WHERE f.code = :code")
    , @NamedQuery(name = "Fonctionnalite.findByLibelle", query = "SELECT f FROM Fonctionnalite f WHERE f.libelle = :libelle")
    , @NamedQuery(name = "Fonctionnalite.findByCreated", query = "SELECT f FROM Fonctionnalite f WHERE f.created = :created")
    , @NamedQuery(name = "Fonctionnalite.findByModified", query = "SELECT f FROM Fonctionnalite f WHERE f.modified = :modified")
    , @NamedQuery(name = "Fonctionnalite.findByDeleted", query = "SELECT f FROM Fonctionnalite f WHERE f.deleted = :deleted")})
public class Fonctionnalite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfonctionnalite", nullable = false)
    private Integer idfonctionnalite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "libelle", nullable = false, length = 254)
    private String libelle;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fonctionnaliteIdfonctionnalite")
    private Collection<UtilisateursFonctionnalites> utilisateursFonctionnalitesCollection;

    public Fonctionnalite() {
    }

    public Fonctionnalite(Integer idfonctionnalite) {
        this.idfonctionnalite = idfonctionnalite;
    }

    public Fonctionnalite(Integer idfonctionnalite, String code, String libelle, boolean deleted) {
        this.idfonctionnalite = idfonctionnalite;
        this.code = code;
        this.libelle = libelle;
        this.deleted = deleted;
    }

    public Integer getIdfonctionnalite() {
        return idfonctionnalite;
    }

    public void setIdfonctionnalite(Integer idfonctionnalite) {
        this.idfonctionnalite = idfonctionnalite;
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
    public Collection<UtilisateursFonctionnalites> getUtilisateursFonctionnalitesCollection() {
        return utilisateursFonctionnalitesCollection;
    }

    public void setUtilisateursFonctionnalitesCollection(Collection<UtilisateursFonctionnalites> utilisateursFonctionnalitesCollection) {
        this.utilisateursFonctionnalitesCollection = utilisateursFonctionnalitesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfonctionnalite != null ? idfonctionnalite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fonctionnalite)) {
            return false;
        }
        Fonctionnalite other = (Fonctionnalite) object;
        if ((this.idfonctionnalite == null && other.idfonctionnalite != null) || (this.idfonctionnalite != null && !this.idfonctionnalite.equals(other.idfonctionnalite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Fonctionnalite[ idfonctionnalite=" + idfonctionnalite + " ]";
    }
    
}
