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
import javax.persistence.Lob;
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
@Table(name = "droit_acces", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"niveau"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DroitAcces.findAll", query = "SELECT d FROM DroitAcces d")
    , @NamedQuery(name = "DroitAcces.findByIddroitAcces", query = "SELECT d FROM DroitAcces d WHERE d.iddroitAcces = :iddroitAcces")
    , @NamedQuery(name = "DroitAcces.findByNiveau", query = "SELECT d FROM DroitAcces d WHERE d.niveau = :niveau")
    , @NamedQuery(name = "DroitAcces.findByCreated", query = "SELECT d FROM DroitAcces d WHERE d.created = :created")
    , @NamedQuery(name = "DroitAcces.findByModified", query = "SELECT d FROM DroitAcces d WHERE d.modified = :modified")
    , @NamedQuery(name = "DroitAcces.findByDeleted", query = "SELECT d FROM DroitAcces d WHERE d.deleted = :deleted")})
public class DroitAcces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddroit_acces", nullable = false)
    private Integer iddroitAcces;
    @Basic(optional = false)
    @NotNull
    @Column(name = "niveau", nullable = false)
    private int niveau;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description", nullable = false, length = 65535)
    private String description;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "droitAccesIddroitAcces", fetch = FetchType.LAZY)
    private Collection<Utilisateur> utilisateurCollection;

    public DroitAcces() {
    }

    public DroitAcces(Integer iddroitAcces) {
        this.iddroitAcces = iddroitAcces;
    }

    public DroitAcces(Integer iddroitAcces, int niveau, String description, boolean deleted) {
        this.iddroitAcces = iddroitAcces;
        this.niveau = niveau;
        this.description = description;
        this.deleted = deleted;
    }

    public Integer getIddroitAcces() {
        return iddroitAcces;
    }

    public void setIddroitAcces(Integer iddroitAcces) {
        this.iddroitAcces = iddroitAcces;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddroitAcces != null ? iddroitAcces.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DroitAcces)) {
            return false;
        }
        DroitAcces other = (DroitAcces) object;
        if ((this.iddroitAcces == null && other.iddroitAcces != null) || (this.iddroitAcces != null && !this.iddroitAcces.equals(other.iddroitAcces))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.DroitAcces[ iddroitAcces=" + iddroitAcces + " ]";
    }
    
}
