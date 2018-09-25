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
@Table(name = "utilisateur", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIdutilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idutilisateur = :idutilisateur")
    , @NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login")
    , @NamedQuery(name = "Utilisateur.findByCreated", query = "SELECT u FROM Utilisateur u WHERE u.created = :created")
    , @NamedQuery(name = "Utilisateur.findByModified", query = "SELECT u FROM Utilisateur u WHERE u.modified = :modified")
    , @NamedQuery(name = "Utilisateur.findByDeleted", query = "SELECT u FROM Utilisateur u WHERE u.deleted = :deleted")})
public class Utilisateur implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "login", nullable = false, length = 254)
    private String login;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "mot_de_passe", nullable = false, length = 65535)
    private String motDePasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateurIdutilisateur", fetch = FetchType.EAGER)
    private Collection<UtilisateurFonctionnalite> utilisateurFonctionnaliteCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idutilisateur", nullable = false)
    private Integer idutilisateur;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modified;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateurIdutilisateur")
    private Collection<UtilisateursFonctionnalites> utilisateursFonctionnalitesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateurIdutilisateur")
    private Collection<Activite> activiteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateurIdutilisateur")
    private Collection<IndividuUtilisateur> individuUtilisateurCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Utilisateur(Integer idutilisateur, String login, String motDePasse, boolean deleted) {
        this.idutilisateur = idutilisateur;
        this.login = login;
        this.motDePasse = motDePasse;
        this.deleted = deleted;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }


    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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


    @XmlTransient
    public Collection<UtilisateursFonctionnalites> getUtilisateursFonctionnalitesCollection() {
        return utilisateursFonctionnalitesCollection;
    }

    public void setUtilisateursFonctionnalitesCollection(Collection<UtilisateursFonctionnalites> utilisateursFonctionnalitesCollection) {
        this.utilisateursFonctionnalitesCollection = utilisateursFonctionnalitesCollection;
    }

    @XmlTransient
    public Collection<Activite> getActiviteCollection() {
        return activiteCollection;
    }

    public void setActiviteCollection(Collection<Activite> activiteCollection) {
        this.activiteCollection = activiteCollection;
    }

    @XmlTransient
    public Collection<IndividuUtilisateur> getIndividuUtilisateurCollection() {
        return individuUtilisateurCollection;
    }

    public void setIndividuUtilisateurCollection(Collection<IndividuUtilisateur> individuUtilisateurCollection) {
        this.individuUtilisateurCollection = individuUtilisateurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idutilisateur != null ? idutilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idutilisateur == null && other.idutilisateur != null) || (this.idutilisateur != null && !this.idutilisateur.equals(other.idutilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Utilisateur[ idutilisateur=" + idutilisateur + " ]";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @XmlTransient
    public Collection<UtilisateurFonctionnalite> getUtilisateurFonctionnaliteCollection() {
        return utilisateurFonctionnaliteCollection;
    }

    public void setUtilisateurFonctionnaliteCollection(Collection<UtilisateurFonctionnalite> utilisateurFonctionnaliteCollection) {
        this.utilisateurFonctionnaliteCollection = utilisateurFonctionnaliteCollection;
    }
    
}
