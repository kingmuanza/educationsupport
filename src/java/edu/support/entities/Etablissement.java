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
@Table(name = "etablissement", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etablissement.findAll", query = "SELECT e FROM Etablissement e")
    , @NamedQuery(name = "Etablissement.findByIdetablissement", query = "SELECT e FROM Etablissement e WHERE e.idetablissement = :idetablissement")
    , @NamedQuery(name = "Etablissement.findByCode", query = "SELECT e FROM Etablissement e WHERE e.code = :code")
    , @NamedQuery(name = "Etablissement.findByNomEtablissement", query = "SELECT e FROM Etablissement e WHERE e.nomEtablissement = :nomEtablissement")
    , @NamedQuery(name = "Etablissement.findByCreated", query = "SELECT e FROM Etablissement e WHERE e.created = :created")
    , @NamedQuery(name = "Etablissement.findByModified", query = "SELECT e FROM Etablissement e WHERE e.modified = :modified")
    , @NamedQuery(name = "Etablissement.findByDeleted", query = "SELECT e FROM Etablissement e WHERE e.deleted = :deleted")})
public class Etablissement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idetablissement", nullable = false)
    private Integer idetablissement;
    @Size(max = 45)
    @Column(name = "code", length = 45)
    private String code;
    @Size(max = 254)
    @Column(name = "nom_etablissement", length = 254)
    private String nomEtablissement;
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
    @OneToMany(mappedBy = "etablissement", fetch = FetchType.EAGER)
    private Collection<CompteParent> compteParentCollection;

    public Etablissement() {
    }

    public Etablissement(Integer idetablissement) {
        this.idetablissement = idetablissement;
    }

    public Etablissement(Integer idetablissement, boolean deleted) {
        this.idetablissement = idetablissement;
        this.deleted = deleted;
    }

    public Integer getIdetablissement() {
        return idetablissement;
    }

    public void setIdetablissement(Integer idetablissement) {
        this.idetablissement = idetablissement;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomEtablissement() {
        return nomEtablissement;
    }

    public void setNomEtablissement(String nomEtablissement) {
        this.nomEtablissement = nomEtablissement;
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
    public Collection<CompteParent> getCompteParentCollection() {
        return compteParentCollection;
    }

    public void setCompteParentCollection(Collection<CompteParent> compteParentCollection) {
        this.compteParentCollection = compteParentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idetablissement != null ? idetablissement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etablissement)) {
            return false;
        }
        Etablissement other = (Etablissement) object;
        if ((this.idetablissement == null && other.idetablissement != null) || (this.idetablissement != null && !this.idetablissement.equals(other.idetablissement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Etablissement[ idetablissement=" + idetablissement + " ]";
    }
    
}
