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
import javax.persistence.UniqueConstraint;
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
@Table(name = "salle_de_classe", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalleDeClasse.findAll", query = "SELECT s FROM SalleDeClasse s")
    , @NamedQuery(name = "SalleDeClasse.findByIdsalleDeClasse", query = "SELECT s FROM SalleDeClasse s WHERE s.idsalleDeClasse = :idsalleDeClasse")
    , @NamedQuery(name = "SalleDeClasse.findByCode", query = "SELECT s FROM SalleDeClasse s WHERE s.code = :code")
    , @NamedQuery(name = "SalleDeClasse.findByLibelle", query = "SELECT s FROM SalleDeClasse s WHERE s.libelle = :libelle")
    , @NamedQuery(name = "SalleDeClasse.findByCreated", query = "SELECT s FROM SalleDeClasse s WHERE s.created = :created")
    , @NamedQuery(name = "SalleDeClasse.findByModified", query = "SELECT s FROM SalleDeClasse s WHERE s.modified = :modified")
    , @NamedQuery(name = "SalleDeClasse.findByDeleted", query = "SELECT s FROM SalleDeClasse s WHERE s.deleted = :deleted")})
public class SalleDeClasse implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Size(max = 45)
    @Column(name = "libelle", length = 45)
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salleDeClasseIdsalleDeClasse", fetch = FetchType.EAGER)
    private Collection<ClasseMatiere> classeMatiereCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsalle_de_classe", nullable = false)
    private Integer idsalleDeClasse;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modified;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salleDeClasseIdsalleDeClasse")
    private Collection<Eleve> eleveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salleDeClasseIdsalleDeClasse")
    private Collection<ClassesMatieres> classesMatieresCollection;
    @JoinColumn(name = "serie_idserie", referencedColumnName = "idserie")
    @ManyToOne
    private Serie serieIdserie;
    @JoinColumn(name = "classe_idclasse", referencedColumnName = "idclasse", nullable = false)
    @ManyToOne(optional = false)
    private Classe classeIdclasse;

    public SalleDeClasse() {
    }

    public SalleDeClasse(Integer idsalleDeClasse) {
        this.idsalleDeClasse = idsalleDeClasse;
    }

    public SalleDeClasse(Integer idsalleDeClasse, String code, boolean deleted) {
        this.idsalleDeClasse = idsalleDeClasse;
        this.code = code;
        this.deleted = deleted;
    }

    public Integer getIdsalleDeClasse() {
        return idsalleDeClasse;
    }

    public void setIdsalleDeClasse(Integer idsalleDeClasse) {
        this.idsalleDeClasse = idsalleDeClasse;
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
    public Collection<Eleve> getEleveCollection() {
        return eleveCollection;
    }

    public void setEleveCollection(Collection<Eleve> eleveCollection) {
        this.eleveCollection = eleveCollection;
    }

    @XmlTransient
    public Collection<ClassesMatieres> getClassesMatieresCollection() {
        return classesMatieresCollection;
    }

    public void setClassesMatieresCollection(Collection<ClassesMatieres> classesMatieresCollection) {
        this.classesMatieresCollection = classesMatieresCollection;
    }

    public Serie getSerieIdserie() {
        return serieIdserie;
    }

    public void setSerieIdserie(Serie serieIdserie) {
        this.serieIdserie = serieIdserie;
    }

    public Classe getClasseIdclasse() {
        return classeIdclasse;
    }

    public void setClasseIdclasse(Classe classeIdclasse) {
        this.classeIdclasse = classeIdclasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsalleDeClasse != null ? idsalleDeClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalleDeClasse)) {
            return false;
        }
        SalleDeClasse other = (SalleDeClasse) object;
        if ((this.idsalleDeClasse == null && other.idsalleDeClasse != null) || (this.idsalleDeClasse != null && !this.idsalleDeClasse.equals(other.idsalleDeClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.SalleDeClasse[ idsalleDeClasse=" + idsalleDeClasse + " ]";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    @XmlTransient
    public Collection<ClasseMatiere> getClasseMatiereCollection() {
        return classeMatiereCollection;
    }

    public void setClasseMatiereCollection(Collection<ClasseMatiere> classeMatiereCollection) {
        this.classeMatiereCollection = classeMatiereCollection;
    }
    
}
