/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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

/**
 *
 * @author N9-T
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve", fetch = FetchType.EAGER)
    private List<Note> noteList;
    @JoinColumn(name = "individu_idindividu", referencedColumnName = "idindividu", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Individu individuIdindividu;
    @JoinColumn(name = "paiement_idpaiement", referencedColumnName = "idpaiement", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Paiement paiementIdpaiement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve", fetch = FetchType.EAGER)
    private List<EleveMaladie> eleveMaladieList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve", fetch = FetchType.EAGER)
    private List<Sanction> sanctionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve", fetch = FetchType.EAGER)
    private List<Relance> relanceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve", fetch = FetchType.EAGER)
    private List<PassageInfirmerie> passageInfirmerieList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve", fetch = FetchType.EAGER)
    private List<Convocation> convocationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve", fetch = FetchType.EAGER)
    private List<AutorisationSortie> autorisationSortieList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve", fetch = FetchType.EAGER)
    private List<ElevesTraduits> elevesTraduitsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveIdeleve", fetch = FetchType.EAGER)
    private List<Moratoire> moratoireList;

    public Eleve() {
    }

    public Eleve(Integer ideleve) {
        this.ideleve = ideleve;
    }

    public Eleve(Integer ideleve, Date created, Date modified, short deleted) {
        this.ideleve = ideleve;
        this.created = created;
        this.modified = modified;
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

    public short getDeleted() {
        return deleted;
    }

    public void setDeleted(short deleted) {
        this.deleted = deleted;
    }

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public Individu getIndividuIdindividu() {
        return individuIdindividu;
    }

    public void setIndividuIdindividu(Individu individuIdindividu) {
        this.individuIdindividu = individuIdindividu;
    }

    public Paiement getPaiementIdpaiement() {
        return paiementIdpaiement;
    }

    public void setPaiementIdpaiement(Paiement paiementIdpaiement) {
        this.paiementIdpaiement = paiementIdpaiement;
    }

    @XmlTransient
    public List<EleveMaladie> getEleveMaladieList() {
        return eleveMaladieList;
    }

    public void setEleveMaladieList(List<EleveMaladie> eleveMaladieList) {
        this.eleveMaladieList = eleveMaladieList;
    }

    @XmlTransient
    public List<Sanction> getSanctionList() {
        return sanctionList;
    }

    public void setSanctionList(List<Sanction> sanctionList) {
        this.sanctionList = sanctionList;
    }

    @XmlTransient
    public List<Relance> getRelanceList() {
        return relanceList;
    }

    public void setRelanceList(List<Relance> relanceList) {
        this.relanceList = relanceList;
    }

    @XmlTransient
    public List<PassageInfirmerie> getPassageInfirmerieList() {
        return passageInfirmerieList;
    }

    public void setPassageInfirmerieList(List<PassageInfirmerie> passageInfirmerieList) {
        this.passageInfirmerieList = passageInfirmerieList;
    }

    @XmlTransient
    public List<Convocation> getConvocationList() {
        return convocationList;
    }

    public void setConvocationList(List<Convocation> convocationList) {
        this.convocationList = convocationList;
    }

    @XmlTransient
    public List<AutorisationSortie> getAutorisationSortieList() {
        return autorisationSortieList;
    }

    public void setAutorisationSortieList(List<AutorisationSortie> autorisationSortieList) {
        this.autorisationSortieList = autorisationSortieList;
    }

    @XmlTransient
    public List<ElevesTraduits> getElevesTraduitsList() {
        return elevesTraduitsList;
    }

    public void setElevesTraduitsList(List<ElevesTraduits> elevesTraduitsList) {
        this.elevesTraduitsList = elevesTraduitsList;
    }

    @XmlTransient
    public List<Moratoire> getMoratoireList() {
        return moratoireList;
    }

    public void setMoratoireList(List<Moratoire> moratoireList) {
        this.moratoireList = moratoireList;
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
