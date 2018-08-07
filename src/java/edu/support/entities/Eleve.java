/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zos hall
 */
@Entity
@Table(name = "eleve", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eleve.findAll", query = "SELECT e FROM Eleve e")
    , @NamedQuery(name = "Eleve.findByIdeleve", query = "SELECT e FROM Eleve e WHERE e.ideleve = :ideleve")
    , @NamedQuery(name = "Eleve.findByCreated", query = "SELECT e FROM Eleve e WHERE e.created = :created")
    , @NamedQuery(name = "Eleve.findByModified", query = "SELECT e FROM Eleve e WHERE e.modified = :modified")
    , @NamedQuery(name = "Eleve.findByDeleted", query = "SELECT e FROM Eleve e WHERE e.deleted = :deleted")})
public class Eleve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideleve", nullable = false)
    private Integer ideleve;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve")
    @JsonIgnore
    private Collection<Note> noteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve")
    @JsonIgnore
    private Collection<Paiement> paiementCollection;
    @JoinColumn(name = "classe_idclasse", referencedColumnName = "idclasse", nullable = false)
    @ManyToOne(optional = false)
    private Classe classeIdclasse;
    @JoinColumn(name = "individu_idindividu", referencedColumnName = "idindividu", nullable = false)
    @ManyToOne(optional = false)
    private Individu individuIdindividu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve")
    @JsonIgnore
    private Collection<EleveMaladie> eleveMaladieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve")
    @JsonIgnore
    private Collection<Sanction> sanctionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve")
    @JsonIgnore
    private Collection<Relance> relanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve")
    @JsonIgnore
    private Collection<PassageInfirmerie> passageInfirmerieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve")
    @JsonIgnore
    private Collection<Convocation> convocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve")
    private Collection<AutorisationSortie> autorisationSortieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve")
    @JsonIgnore
    private Collection<ElevesTraduits> elevesTraduitsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve")
    private Collection<Moratoire> moratoireCollection;

    public Eleve() {
    }

    public Eleve(Integer ideleve) {
        this.ideleve = ideleve;
    }

    public Eleve(Integer ideleve, boolean deleted) {
        this.ideleve = ideleve;
        this.deleted = deleted;
    }

    public Integer getIdeleve() {
        return ideleve;
    }

    public void setIdeleve(Integer ideleve) {
        this.ideleve = ideleve;
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
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }

    @XmlTransient
    public Collection<Paiement> getPaiementCollection() {
        return paiementCollection;
    }

    public void setPaiementCollection(Collection<Paiement> paiementCollection) {
        this.paiementCollection = paiementCollection;
    }

    public Classe getClasseIdclasse() {
        return classeIdclasse;
    }

    public void setClasseIdclasse(Classe classeIdclasse) {
        this.classeIdclasse = classeIdclasse;
    }

    public Individu getIndividuIdindividu() {
        return individuIdindividu;
    }

    public void setIndividuIdindividu(Individu individuIdindividu) {
        this.individuIdindividu = individuIdindividu;
    }

    @XmlTransient
    public Collection<EleveMaladie> getEleveMaladieCollection() {
        return eleveMaladieCollection;
    }

    public void setEleveMaladieCollection(Collection<EleveMaladie> eleveMaladieCollection) {
        this.eleveMaladieCollection = eleveMaladieCollection;
    }

    @XmlTransient
    public Collection<Sanction> getSanctionCollection() {
        return sanctionCollection;
    }

    public void setSanctionCollection(Collection<Sanction> sanctionCollection) {
        this.sanctionCollection = sanctionCollection;
    }

    @XmlTransient
    public Collection<Relance> getRelanceCollection() {
        return relanceCollection;
    }

    public void setRelanceCollection(Collection<Relance> relanceCollection) {
        this.relanceCollection = relanceCollection;
    }

    @XmlTransient
    public Collection<PassageInfirmerie> getPassageInfirmerieCollection() {
        return passageInfirmerieCollection;
    }

    public void setPassageInfirmerieCollection(Collection<PassageInfirmerie> passageInfirmerieCollection) {
        this.passageInfirmerieCollection = passageInfirmerieCollection;
    }

    @XmlTransient
    public Collection<Convocation> getConvocationCollection() {
        return convocationCollection;
    }

    public void setConvocationCollection(Collection<Convocation> convocationCollection) {
        this.convocationCollection = convocationCollection;
    }

    @XmlTransient
    public Collection<AutorisationSortie> getAutorisationSortieCollection() {
        return autorisationSortieCollection;
    }

    public void setAutorisationSortieCollection(Collection<AutorisationSortie> autorisationSortieCollection) {
        this.autorisationSortieCollection = autorisationSortieCollection;
    }

    @XmlTransient
    public Collection<ElevesTraduits> getElevesTraduitsCollection() {
        return elevesTraduitsCollection;
    }

    public void setElevesTraduitsCollection(Collection<ElevesTraduits> elevesTraduitsCollection) {
        this.elevesTraduitsCollection = elevesTraduitsCollection;
    }

    @XmlTransient
    public Collection<Moratoire> getMoratoireCollection() {
        return moratoireCollection;
    }

    public void setMoratoireCollection(Collection<Moratoire> moratoireCollection) {
        this.moratoireCollection = moratoireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideleve != null ? ideleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((this.ideleve == null && other.ideleve != null) || (this.ideleve != null && !this.ideleve.equals(other.ideleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Eleve[ ideleve=" + ideleve + " ]";
    }
    
}
