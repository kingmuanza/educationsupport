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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "serie", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serie.findAll", query = "SELECT s FROM Serie s")
    , @NamedQuery(name = "Serie.findByIdserie", query = "SELECT s FROM Serie s WHERE s.idserie = :idserie")
    , @NamedQuery(name = "Serie.findByCode", query = "SELECT s FROM Serie s WHERE s.code = :code")
    , @NamedQuery(name = "Serie.findByLibelle", query = "SELECT s FROM Serie s WHERE s.libelle = :libelle")
    , @NamedQuery(name = "Serie.findByCreated", query = "SELECT s FROM Serie s WHERE s.created = :created")
    , @NamedQuery(name = "Serie.findByModified", query = "SELECT s FROM Serie s WHERE s.modified = :modified")
    , @NamedQuery(name = "Serie.findByDeleted", query = "SELECT s FROM Serie s WHERE s.deleted = :deleted")})
public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idserie", nullable = false)
    private Integer idserie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Size(max = 45)
    @Column(name = "libelle", length = 45)
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
    @OneToMany(mappedBy = "serieIdserie")
    private Collection<SalleDeClasse> salleDeClasseCollection;

    public Serie() {
    }

    public Serie(Integer idserie) {
        this.idserie = idserie;
    }

    public Serie(Integer idserie, String code, boolean deleted) {
        this.idserie = idserie;
        this.code = code;
        this.deleted = deleted;
    }

    public Integer getIdserie() {
        return idserie;
    }

    public void setIdserie(Integer idserie) {
        this.idserie = idserie;
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
    public Collection<SalleDeClasse> getSalleDeClasseCollection() {
        return salleDeClasseCollection;
    }

    public void setSalleDeClasseCollection(Collection<SalleDeClasse> salleDeClasseCollection) {
        this.salleDeClasseCollection = salleDeClasseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idserie != null ? idserie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serie)) {
            return false;
        }
        Serie other = (Serie) object;
        if ((this.idserie == null && other.idserie != null) || (this.idserie != null && !this.idserie.equals(other.idserie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Serie[ idserie=" + idserie + " ]";
    }
    
}
