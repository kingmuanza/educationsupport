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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "enseignant", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e")
    , @NamedQuery(name = "Enseignant.findByIdenseignant", query = "SELECT e FROM Enseignant e WHERE e.idenseignant = :idenseignant")
    , @NamedQuery(name = "Enseignant.findByCreated", query = "SELECT e FROM Enseignant e WHERE e.created = :created")
    , @NamedQuery(name = "Enseignant.findByModified", query = "SELECT e FROM Enseignant e WHERE e.modified = :modified")
    , @NamedQuery(name = "Enseignant.findByDeleted", query = "SELECT e FROM Enseignant e WHERE e.deleted = :deleted")})
public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idenseignant", nullable = false)
    private Integer idenseignant;
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
    @OneToMany(mappedBy = "enseignantIdenseignant", fetch = FetchType.LAZY)
    private Collection<Sanction> sanctionCollection;
    @JoinColumn(name = "individu_idindividu", referencedColumnName = "idindividu", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Individu individuIdindividu;

    public Enseignant() {
    }

    public Enseignant(Integer idenseignant) {
        this.idenseignant = idenseignant;
    }

    public Enseignant(Integer idenseignant, boolean deleted) {
        this.idenseignant = idenseignant;
        this.deleted = deleted;
    }

    public Integer getIdenseignant() {
        return idenseignant;
    }

    public void setIdenseignant(Integer idenseignant) {
        this.idenseignant = idenseignant;
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
    public Collection<Sanction> getSanctionCollection() {
        return sanctionCollection;
    }

    public void setSanctionCollection(Collection<Sanction> sanctionCollection) {
        this.sanctionCollection = sanctionCollection;
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
        hash += (idenseignant != null ? idenseignant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.idenseignant == null && other.idenseignant != null) || (this.idenseignant != null && !this.idenseignant.equals(other.idenseignant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Enseignant[ idenseignant=" + idenseignant + " ]";
    }
    
}
