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
@Table(name = "individu_utilisateur", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndividuUtilisateur.findAll", query = "SELECT i FROM IndividuUtilisateur i")
    , @NamedQuery(name = "IndividuUtilisateur.findByIdindividuUtilisateur", query = "SELECT i FROM IndividuUtilisateur i WHERE i.idindividuUtilisateur = :idindividuUtilisateur")
    , @NamedQuery(name = "IndividuUtilisateur.findByCreated", query = "SELECT i FROM IndividuUtilisateur i WHERE i.created = :created")
    , @NamedQuery(name = "IndividuUtilisateur.findByModified", query = "SELECT i FROM IndividuUtilisateur i WHERE i.modified = :modified")
    , @NamedQuery(name = "IndividuUtilisateur.findByDeleted", query = "SELECT i FROM IndividuUtilisateur i WHERE i.deleted = :deleted")})
public class IndividuUtilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idindividu_utilisateur", nullable = false)
    private Integer idindividuUtilisateur;
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
    @JoinColumn(name = "individu_idindividu", referencedColumnName = "idindividu", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Individu individuIdindividu;

    public IndividuUtilisateur() {
    }

    public IndividuUtilisateur(Integer idindividuUtilisateur) {
        this.idindividuUtilisateur = idindividuUtilisateur;
    }

    public IndividuUtilisateur(Integer idindividuUtilisateur, Date created, Date modified, short deleted) {
        this.idindividuUtilisateur = idindividuUtilisateur;
        this.created = created;
        this.modified = modified;
        this.deleted = deleted;
    }

    public Integer getIdindividuUtilisateur() {
        return idindividuUtilisateur;
    }

    public void setIdindividuUtilisateur(Integer idindividuUtilisateur) {
        this.idindividuUtilisateur = idindividuUtilisateur;
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

    public Individu getIndividuIdindividu() {
        return individuIdindividu;
    }

    public void setIndividuIdindividu(Individu individuIdindividu) {
        this.individuIdindividu = individuIdindividu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idindividuUtilisateur != null ? idindividuUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndividuUtilisateur)) {
            return false;
        }
        IndividuUtilisateur other = (IndividuUtilisateur) object;
        if ((this.idindividuUtilisateur == null && other.idindividuUtilisateur != null) || (this.idindividuUtilisateur != null && !this.idindividuUtilisateur.equals(other.idindividuUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.IndividuUtilisateur[ idindividuUtilisateur=" + idindividuUtilisateur + " ]";
    }
    
}
