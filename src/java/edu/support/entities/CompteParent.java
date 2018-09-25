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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "compte_parent", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompteParent.findAll", query = "SELECT c FROM CompteParent c")
    , @NamedQuery(name = "CompteParent.findByIdcompteParent", query = "SELECT c FROM CompteParent c WHERE c.idcompteParent = :idcompteParent")
    , @NamedQuery(name = "CompteParent.findByLogin", query = "SELECT c FROM CompteParent c WHERE c.login = :login")
    , @NamedQuery(name = "CompteParent.findByActif", query = "SELECT c FROM CompteParent c WHERE c.actif = :actif")
    , @NamedQuery(name = "CompteParent.findByCreated", query = "SELECT c FROM CompteParent c WHERE c.created = :created")
    , @NamedQuery(name = "CompteParent.findByModified", query = "SELECT c FROM CompteParent c WHERE c.modified = :modified")
    , @NamedQuery(name = "CompteParent.findByDeleted", query = "SELECT c FROM CompteParent c WHERE c.deleted = :deleted")})
public class CompteParent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompte_parent", nullable = false)
    private Integer idcompteParent;
    @Size(max = 254)
    @Column(name = "login", length = 254)
    private String login;
    @Lob
    @Size(max = 65535)
    @Column(name = "mot_de_passe", length = 65535)
    private String motDePasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actif", nullable = false)
    private boolean actif;
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
    @OneToMany(mappedBy = "compteParent", fetch = FetchType.EAGER)
    private Collection<CompteParentEleve> compteParentEleveCollection;
    @JoinColumn(name = "etablissement", referencedColumnName = "idetablissement")
    @ManyToOne(fetch = FetchType.EAGER)
    private Etablissement etablissement;

    public CompteParent() {
    }

    public CompteParent(Integer idcompteParent) {
        this.idcompteParent = idcompteParent;
    }

    public CompteParent(Integer idcompteParent, boolean actif, boolean deleted) {
        this.idcompteParent = idcompteParent;
        this.actif = actif;
        this.deleted = deleted;
    }

    public Integer getIdcompteParent() {
        return idcompteParent;
    }

    public void setIdcompteParent(Integer idcompteParent) {
        this.idcompteParent = idcompteParent;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
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
    public Collection<CompteParentEleve> getCompteParentEleveCollection() {
        return compteParentEleveCollection;
    }

    public void setCompteParentEleveCollection(Collection<CompteParentEleve> compteParentEleveCollection) {
        this.compteParentEleveCollection = compteParentEleveCollection;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompteParent != null ? idcompteParent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteParent)) {
            return false;
        }
        CompteParent other = (CompteParent) object;
        if ((this.idcompteParent == null && other.idcompteParent != null) || (this.idcompteParent != null && !this.idcompteParent.equals(other.idcompteParent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.CompteParent[ idcompteParent=" + idcompteParent + " ]";
    }
    
}
