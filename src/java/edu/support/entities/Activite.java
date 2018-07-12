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

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "activite", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activite.findAll", query = "SELECT a FROM Activite a")
    , @NamedQuery(name = "Activite.findByIdactivite", query = "SELECT a FROM Activite a WHERE a.idactivite = :idactivite")
    , @NamedQuery(name = "Activite.findByAction", query = "SELECT a FROM Activite a WHERE a.action = :action")
    , @NamedQuery(name = "Activite.findByCreated", query = "SELECT a FROM Activite a WHERE a.created = :created")
    , @NamedQuery(name = "Activite.findByModified", query = "SELECT a FROM Activite a WHERE a.modified = :modified")
    , @NamedQuery(name = "Activite.findByDeleted", query = "SELECT a FROM Activite a WHERE a.deleted = :deleted")})
public class Activite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactivite", nullable = false)
    private Integer idactivite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "action", nullable = false)
    private int action;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private short deleted;
    @JoinColumn(name = "utilisateur_idutilisateur", referencedColumnName = "idutilisateur", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Utilisateur utilisateurIdutilisateur;

    public Activite() {
    }

    public Activite(Integer idactivite) {
        this.idactivite = idactivite;
    }

    public Activite(Integer idactivite, int action, Date created, Date modified, short deleted) {
        this.idactivite = idactivite;
        this.action = action;
        this.created = created;
        this.modified = modified;
        this.deleted = deleted;
    }

    public Integer getIdactivite() {
        return idactivite;
    }

    public void setIdactivite(Integer idactivite) {
        this.idactivite = idactivite;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
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

    public Utilisateur getUtilisateurIdutilisateur() {
        return utilisateurIdutilisateur;
    }

    public void setUtilisateurIdutilisateur(Utilisateur utilisateurIdutilisateur) {
        this.utilisateurIdutilisateur = utilisateurIdutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivite != null ? idactivite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activite)) {
            return false;
        }
        Activite other = (Activite) object;
        if ((this.idactivite == null && other.idactivite != null) || (this.idactivite != null && !this.idactivite.equals(other.idactivite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Activite[ idactivite=" + idactivite + " ]";
    }
    
}
