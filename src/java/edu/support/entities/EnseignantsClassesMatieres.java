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
@Table(name = "enseignants_classes_matieres", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnseignantsClassesMatieres.findAll", query = "SELECT e FROM EnseignantsClassesMatieres e")
    , @NamedQuery(name = "EnseignantsClassesMatieres.findByIdenseignantsClassesMatieres", query = "SELECT e FROM EnseignantsClassesMatieres e WHERE e.idenseignantsClassesMatieres = :idenseignantsClassesMatieres")
    , @NamedQuery(name = "EnseignantsClassesMatieres.findByCreated", query = "SELECT e FROM EnseignantsClassesMatieres e WHERE e.created = :created")
    , @NamedQuery(name = "EnseignantsClassesMatieres.findByModified", query = "SELECT e FROM EnseignantsClassesMatieres e WHERE e.modified = :modified")
    , @NamedQuery(name = "EnseignantsClassesMatieres.findByDeleted", query = "SELECT e FROM EnseignantsClassesMatieres e WHERE e.deleted = :deleted")})
public class EnseignantsClassesMatieres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idenseignants_classes_matieres", nullable = false)
    private Integer idenseignantsClassesMatieres;
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
    @JoinColumn(name = "enseignant_idenseignant", referencedColumnName = "idenseignant", nullable = false)
    @ManyToOne(optional = false)
    private Enseignant enseignantIdenseignant;
    @JoinColumn(name = "classes_matieres_idclasses_matieres", referencedColumnName = "idclasses_matieres", nullable = false)
    @ManyToOne(optional = false)
    private ClassesMatieres classesMatieresIdclassesMatieres;

    public EnseignantsClassesMatieres() {
    }

    public EnseignantsClassesMatieres(Integer idenseignantsClassesMatieres) {
        this.idenseignantsClassesMatieres = idenseignantsClassesMatieres;
    }

    public EnseignantsClassesMatieres(Integer idenseignantsClassesMatieres, boolean deleted) {
        this.idenseignantsClassesMatieres = idenseignantsClassesMatieres;
        this.deleted = deleted;
    }

    public Integer getIdenseignantsClassesMatieres() {
        return idenseignantsClassesMatieres;
    }

    public void setIdenseignantsClassesMatieres(Integer idenseignantsClassesMatieres) {
        this.idenseignantsClassesMatieres = idenseignantsClassesMatieres;
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

    public Enseignant getEnseignantIdenseignant() {
        return enseignantIdenseignant;
    }

    public void setEnseignantIdenseignant(Enseignant enseignantIdenseignant) {
        this.enseignantIdenseignant = enseignantIdenseignant;
    }

    public ClassesMatieres getClassesMatieresIdclassesMatieres() {
        return classesMatieresIdclassesMatieres;
    }

    public void setClassesMatieresIdclassesMatieres(ClassesMatieres classesMatieresIdclassesMatieres) {
        this.classesMatieresIdclassesMatieres = classesMatieresIdclassesMatieres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idenseignantsClassesMatieres != null ? idenseignantsClassesMatieres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnseignantsClassesMatieres)) {
            return false;
        }
        EnseignantsClassesMatieres other = (EnseignantsClassesMatieres) object;
        if ((this.idenseignantsClassesMatieres == null && other.idenseignantsClassesMatieres != null) || (this.idenseignantsClassesMatieres != null && !this.idenseignantsClassesMatieres.equals(other.idenseignantsClassesMatieres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.EnseignantsClassesMatieres[ idenseignantsClassesMatieres=" + idenseignantsClassesMatieres + " ]";
    }
    
}
