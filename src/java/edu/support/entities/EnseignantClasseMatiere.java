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
@Table(name = "enseignant_classe_matiere", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnseignantClasseMatiere.findAll", query = "SELECT e FROM EnseignantClasseMatiere e")
    , @NamedQuery(name = "EnseignantClasseMatiere.findByIdenseignantClasseMatiere", query = "SELECT e FROM EnseignantClasseMatiere e WHERE e.idenseignantClasseMatiere = :idenseignantClasseMatiere")
    , @NamedQuery(name = "EnseignantClasseMatiere.findByCreated", query = "SELECT e FROM EnseignantClasseMatiere e WHERE e.created = :created")
    , @NamedQuery(name = "EnseignantClasseMatiere.findByModified", query = "SELECT e FROM EnseignantClasseMatiere e WHERE e.modified = :modified")
    , @NamedQuery(name = "EnseignantClasseMatiere.findByDeleted", query = "SELECT e FROM EnseignantClasseMatiere e WHERE e.deleted = :deleted")})
public class EnseignantClasseMatiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idenseignant_classe_matiere", nullable = false)
    private Integer idenseignantClasseMatiere;
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
    @JoinColumn(name = "classes_matieres_idclasses_matieres", referencedColumnName = "idclasse_matiere", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ClasseMatiere classesMatieresIdclassesMatieres;
    @JoinColumn(name = "enseignant_idenseignant", referencedColumnName = "idenseignant", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Enseignant enseignantIdenseignant;

    public EnseignantClasseMatiere() {
    }

    public EnseignantClasseMatiere(Integer idenseignantClasseMatiere) {
        this.idenseignantClasseMatiere = idenseignantClasseMatiere;
    }

    public EnseignantClasseMatiere(Integer idenseignantClasseMatiere, short deleted) {
        this.idenseignantClasseMatiere = idenseignantClasseMatiere;
        this.deleted = deleted;
    }

    public Integer getIdenseignantClasseMatiere() {
        return idenseignantClasseMatiere;
    }

    public void setIdenseignantClasseMatiere(Integer idenseignantClasseMatiere) {
        this.idenseignantClasseMatiere = idenseignantClasseMatiere;
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

    public ClasseMatiere getClassesMatieresIdclassesMatieres() {
        return classesMatieresIdclassesMatieres;
    }

    public void setClassesMatieresIdclassesMatieres(ClasseMatiere classesMatieresIdclassesMatieres) {
        this.classesMatieresIdclassesMatieres = classesMatieresIdclassesMatieres;
    }

    public Enseignant getEnseignantIdenseignant() {
        return enseignantIdenseignant;
    }

    public void setEnseignantIdenseignant(Enseignant enseignantIdenseignant) {
        this.enseignantIdenseignant = enseignantIdenseignant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idenseignantClasseMatiere != null ? idenseignantClasseMatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnseignantClasseMatiere)) {
            return false;
        }
        EnseignantClasseMatiere other = (EnseignantClasseMatiere) object;
        if ((this.idenseignantClasseMatiere == null && other.idenseignantClasseMatiere != null) || (this.idenseignantClasseMatiere != null && !this.idenseignantClasseMatiere.equals(other.idenseignantClasseMatiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.EnseignantClasseMatiere[ idenseignantClasseMatiere=" + idenseignantClasseMatiere + " ]";
    }
    
}
