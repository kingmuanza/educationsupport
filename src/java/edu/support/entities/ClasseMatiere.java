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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "classe_matiere", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClasseMatiere.findAll", query = "SELECT c FROM ClasseMatiere c")
    , @NamedQuery(name = "ClasseMatiere.findByIdclasseMatiere", query = "SELECT c FROM ClasseMatiere c WHERE c.idclasseMatiere = :idclasseMatiere")
    , @NamedQuery(name = "ClasseMatiere.findByCoefficient", query = "SELECT c FROM ClasseMatiere c WHERE c.coefficient = :coefficient")
    , @NamedQuery(name = "ClasseMatiere.findByCreated", query = "SELECT c FROM ClasseMatiere c WHERE c.created = :created")
    , @NamedQuery(name = "ClasseMatiere.findByModified", query = "SELECT c FROM ClasseMatiere c WHERE c.modified = :modified")
    , @NamedQuery(name = "ClasseMatiere.findByDeleted", query = "SELECT c FROM ClasseMatiere c WHERE c.deleted = :deleted")})
public class ClasseMatiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclasse_matiere", nullable = false)
    private Integer idclasseMatiere;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coefficient", nullable = false)
    private int coefficient;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classeMatiereIdclasseMatiere", fetch = FetchType.EAGER)
    private Collection<EnseignantClasseMatiere> enseignantClasseMatiereCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classeMatiereIdclasseMatiere", fetch = FetchType.EAGER)
    private Collection<Evaluation> evaluationCollection;
    @JoinColumn(name = "salle_de_classe_idsalle_de_classe", referencedColumnName = "idsalle_de_classe", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SalleDeClasse salleDeClasseIdsalleDeClasse;
    @JoinColumn(name = "matiere_idmatiere", referencedColumnName = "idmatiere", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Matiere matiereIdmatiere;

    public ClasseMatiere() {
    }

    public ClasseMatiere(Integer idclasseMatiere) {
        this.idclasseMatiere = idclasseMatiere;
    }

    public ClasseMatiere(Integer idclasseMatiere, int coefficient, boolean deleted) {
        this.idclasseMatiere = idclasseMatiere;
        this.coefficient = coefficient;
        this.deleted = deleted;
    }

    public Integer getIdclasseMatiere() {
        return idclasseMatiere;
    }

    public void setIdclasseMatiere(Integer idclasseMatiere) {
        this.idclasseMatiere = idclasseMatiere;
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
    public Collection<EnseignantClasseMatiere> getEnseignantClasseMatiereCollection() {
        return enseignantClasseMatiereCollection;
    }

    public void setEnseignantClasseMatiereCollection(Collection<EnseignantClasseMatiere> enseignantClasseMatiereCollection) {
        this.enseignantClasseMatiereCollection = enseignantClasseMatiereCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclasseMatiere != null ? idclasseMatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClasseMatiere)) {
            return false;
        }
        ClasseMatiere other = (ClasseMatiere) object;
        if ((this.idclasseMatiere == null && other.idclasseMatiere != null) || (this.idclasseMatiere != null && !this.idclasseMatiere.equals(other.idclasseMatiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.ClasseMatiere[ idclasseMatiere=" + idclasseMatiere + " ]";
    }
    
}
