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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "classes_matieres", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassesMatieres.findAll", query = "SELECT c FROM ClassesMatieres c")
    , @NamedQuery(name = "ClassesMatieres.findByIdclassesMatieres", query = "SELECT c FROM ClassesMatieres c WHERE c.idclassesMatieres = :idclassesMatieres")
    , @NamedQuery(name = "ClassesMatieres.findByCoefficient", query = "SELECT c FROM ClassesMatieres c WHERE c.coefficient = :coefficient")
    , @NamedQuery(name = "ClassesMatieres.findByCreated", query = "SELECT c FROM ClassesMatieres c WHERE c.created = :created")
    , @NamedQuery(name = "ClassesMatieres.findByModified", query = "SELECT c FROM ClassesMatieres c WHERE c.modified = :modified")
    , @NamedQuery(name = "ClassesMatieres.findByDeleted", query = "SELECT c FROM ClassesMatieres c WHERE c.deleted = :deleted")})
public class ClassesMatieres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclasses_matieres", nullable = false)
    private Integer idclassesMatieres;
    @Basic(optional = false)
    
    @Column(name = "coefficient", nullable = false)
    private int coefficient;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modified;
    @Basic(optional = false)
    
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classesMatieresIdclassesMatieres")
    private Collection<Evaluation> evaluationCollection;
    @JoinColumn(name = "salle_de_classe_idsalle_de_classe", referencedColumnName = "idsalle_de_classe", nullable = false)
    @ManyToOne(optional = false)
    private SalleDeClasse salleDeClasseIdsalleDeClasse;
    @JoinColumn(name = "matiere_idmatiere", referencedColumnName = "idmatiere", nullable = false)
    @ManyToOne(optional = false)
    private Matiere matiereIdmatiere;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classesMatieresIdclassesMatieres")
    private Collection<EnseignantsClassesMatieres> enseignantsClassesMatieresCollection;

    public ClassesMatieres() {
    }

    public ClassesMatieres(Integer idclassesMatieres) {
        this.idclassesMatieres = idclassesMatieres;
    }

    public ClassesMatieres(Integer idclassesMatieres, int coefficient, boolean deleted) {
        this.idclassesMatieres = idclassesMatieres;
        this.coefficient = coefficient;
        this.deleted = deleted;
    }

    public Integer getIdclassesMatieres() {
        return idclassesMatieres;
    }

    public void setIdclassesMatieres(Integer idclassesMatieres) {
        this.idclassesMatieres = idclassesMatieres;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
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
    public Collection<Evaluation> getEvaluationCollection() {
        return evaluationCollection;
    }

    public void setEvaluationCollection(Collection<Evaluation> evaluationCollection) {
        this.evaluationCollection = evaluationCollection;
    }

    public SalleDeClasse getSalleDeClasseIdsalleDeClasse() {
        return salleDeClasseIdsalleDeClasse;
    }

    public void setSalleDeClasseIdsalleDeClasse(SalleDeClasse salleDeClasseIdsalleDeClasse) {
        this.salleDeClasseIdsalleDeClasse = salleDeClasseIdsalleDeClasse;
    }

    public Matiere getMatiereIdmatiere() {
        return matiereIdmatiere;
    }

    public void setMatiereIdmatiere(Matiere matiereIdmatiere) {
        this.matiereIdmatiere = matiereIdmatiere;
    }

    @XmlTransient
    public Collection<EnseignantsClassesMatieres> getEnseignantsClassesMatieresCollection() {
        return enseignantsClassesMatieresCollection;
    }

    public void setEnseignantsClassesMatieresCollection(Collection<EnseignantsClassesMatieres> enseignantsClassesMatieresCollection) {
        this.enseignantsClassesMatieresCollection = enseignantsClassesMatieresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclassesMatieres != null ? idclassesMatieres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassesMatieres)) {
            return false;
        }
        ClassesMatieres other = (ClassesMatieres) object;
        if ((this.idclassesMatieres == null && other.idclassesMatieres != null) || (this.idclassesMatieres != null && !this.idclassesMatieres.equals(other.idclassesMatieres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.ClassesMatieres[ idclassesMatieres=" + idclassesMatieres + " ]";
    }
    
}
