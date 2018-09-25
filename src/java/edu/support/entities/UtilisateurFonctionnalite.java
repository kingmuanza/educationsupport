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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "utilisateur_fonctionnalite", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UtilisateurFonctionnalite.findAll", query = "SELECT u FROM UtilisateurFonctionnalite u")
    , @NamedQuery(name = "UtilisateurFonctionnalite.findByIdutilisateurFonctionnalite", query = "SELECT u FROM UtilisateurFonctionnalite u WHERE u.idutilisateurFonctionnalite = :idutilisateurFonctionnalite")
    , @NamedQuery(name = "UtilisateurFonctionnalite.findByCreated", query = "SELECT u FROM UtilisateurFonctionnalite u WHERE u.created = :created")
    , @NamedQuery(name = "UtilisateurFonctionnalite.findByModified", query = "SELECT u FROM UtilisateurFonctionnalite u WHERE u.modified = :modified")
    , @NamedQuery(name = "UtilisateurFonctionnalite.findByDeleted", query = "SELECT u FROM UtilisateurFonctionnalite u WHERE u.deleted = :deleted")})
public class UtilisateurFonctionnalite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idutilisateur_fonctionnalite", nullable = false)
    private Integer idutilisateurFonctionnalite;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private short deleted;
    @JoinColumn(name = "fonctionnalite_idfonctionnalite", referencedColumnName = "idfonctionnalite", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Fonctionnalite fonctionnaliteIdfonctionnalite;
    @JoinColumn(name = "utilisateur_idutilisateur", referencedColumnName = "idutilisateur", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Utilisateur utilisateurIdutilisateur;

    public UtilisateurFonctionnalite() {
    }

    public UtilisateurFonctionnalite(Integer idutilisateurFonctionnalite) {
        this.idutilisateurFonctionnalite = idutilisateurFonctionnalite;
    }

    public UtilisateurFonctionnalite(Integer idutilisateurFonctionnalite, short deleted) {
        this.idutilisateurFonctionnalite = idutilisateurFonctionnalite;
        this.deleted = deleted;
    }

    public Integer getIdutilisateurFonctionnalite() {
        return idutilisateurFonctionnalite;
    }

    public void setIdutilisateurFonctionnalite(Integer idutilisateurFonctionnalite) {
        this.idutilisateurFonctionnalite = idutilisateurFonctionnalite;
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

    public Fonctionnalite getFonctionnaliteIdfonctionnalite() {
        return fonctionnaliteIdfonctionnalite;
    }

    public void setFonctionnaliteIdfonctionnalite(Fonctionnalite fonctionnaliteIdfonctionnalite) {
        this.fonctionnaliteIdfonctionnalite = fonctionnaliteIdfonctionnalite;
    }

    public Utilisateur getUtilisateurIdutilisateur() {
        return utilisateurIdutilisateur;
    }

    public void setUtilisateurIdutilisateur(Utilisateur utilisateurIdutilisateur) {
        this.utilisateurIdutilisateur = utilisateurIdutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idutilisateurFonctionnalite != null ? idutilisateurFonctionnalite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UtilisateurFonctionnalite)) {
            return false;
        }
        UtilisateurFonctionnalite other = (UtilisateurFonctionnalite) object;
        if ((this.idutilisateurFonctionnalite == null && other.idutilisateurFonctionnalite != null) || (this.idutilisateurFonctionnalite != null && !this.idutilisateurFonctionnalite.equals(other.idutilisateurFonctionnalite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.UtilisateurFonctionnalite[ idutilisateurFonctionnalite=" + idutilisateurFonctionnalite + " ]";
    }
    
}
