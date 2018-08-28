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
@Table(name = "utilisateurs_fonctionnalites", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UtilisateursFonctionnalites.findAll", query = "SELECT u FROM UtilisateursFonctionnalites u")
    , @NamedQuery(name = "UtilisateursFonctionnalites.findByIdutilisateursFonctionnalites", query = "SELECT u FROM UtilisateursFonctionnalites u WHERE u.idutilisateursFonctionnalites = :idutilisateursFonctionnalites")
    , @NamedQuery(name = "UtilisateursFonctionnalites.findByCreated", query = "SELECT u FROM UtilisateursFonctionnalites u WHERE u.created = :created")
    , @NamedQuery(name = "UtilisateursFonctionnalites.findByModified", query = "SELECT u FROM UtilisateursFonctionnalites u WHERE u.modified = :modified")
    , @NamedQuery(name = "UtilisateursFonctionnalites.findByDeleted", query = "SELECT u FROM UtilisateursFonctionnalites u WHERE u.deleted = :deleted")})
public class UtilisateursFonctionnalites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idutilisateurs_fonctionnalites", nullable = false)
    private Integer idutilisateursFonctionnalites;
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
    @JoinColumn(name = "utilisateur_idutilisateur", referencedColumnName = "idutilisateur", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateurIdutilisateur;
    @JoinColumn(name = "fonctionnalite_idfonctionnalite", referencedColumnName = "idfonctionnalite", nullable = false)
    @ManyToOne(optional = false)
    private Fonctionnalite fonctionnaliteIdfonctionnalite;

    public UtilisateursFonctionnalites() {
    }

    public UtilisateursFonctionnalites(Integer idutilisateursFonctionnalites) {
        this.idutilisateursFonctionnalites = idutilisateursFonctionnalites;
    }

    public UtilisateursFonctionnalites(Integer idutilisateursFonctionnalites, boolean deleted) {
        this.idutilisateursFonctionnalites = idutilisateursFonctionnalites;
        this.deleted = deleted;
    }

    public Integer getIdutilisateursFonctionnalites() {
        return idutilisateursFonctionnalites;
    }

    public void setIdutilisateursFonctionnalites(Integer idutilisateursFonctionnalites) {
        this.idutilisateursFonctionnalites = idutilisateursFonctionnalites;
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

    public Utilisateur getUtilisateurIdutilisateur() {
        return utilisateurIdutilisateur;
    }

    public void setUtilisateurIdutilisateur(Utilisateur utilisateurIdutilisateur) {
        this.utilisateurIdutilisateur = utilisateurIdutilisateur;
    }

    public Fonctionnalite getFonctionnaliteIdfonctionnalite() {
        return fonctionnaliteIdfonctionnalite;
    }

    public void setFonctionnaliteIdfonctionnalite(Fonctionnalite fonctionnaliteIdfonctionnalite) {
        this.fonctionnaliteIdfonctionnalite = fonctionnaliteIdfonctionnalite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idutilisateursFonctionnalites != null ? idutilisateursFonctionnalites.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UtilisateursFonctionnalites)) {
            return false;
        }
        UtilisateursFonctionnalites other = (UtilisateursFonctionnalites) object;
        if ((this.idutilisateursFonctionnalites == null && other.idutilisateursFonctionnalites != null) || (this.idutilisateursFonctionnalites != null && !this.idutilisateursFonctionnalites.equals(other.idutilisateursFonctionnalites))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.UtilisateursFonctionnalites[ idutilisateursFonctionnalites=" + idutilisateursFonctionnalites + " ]";
    }
    
}
