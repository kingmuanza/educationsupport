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
import javax.persistence.Lob;
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

/**
 *
 * @author zos hall
 */
@Entity
@Table(name = "individu", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"matricule"})
    , @UniqueConstraint(columnNames = {"email"})
    , @UniqueConstraint(columnNames = {"telephone"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Individu.findAll", query = "SELECT i FROM Individu i")
    , @NamedQuery(name = "Individu.findByIdindividu", query = "SELECT i FROM Individu i WHERE i.idindividu = :idindividu")
    , @NamedQuery(name = "Individu.findByMatricule", query = "SELECT i FROM Individu i WHERE i.matricule = :matricule")
    , @NamedQuery(name = "Individu.findByNoms", query = "SELECT i FROM Individu i WHERE i.noms = :noms")
    , @NamedQuery(name = "Individu.findByPrenoms", query = "SELECT i FROM Individu i WHERE i.prenoms = :prenoms")
    , @NamedQuery(name = "Individu.findByDateNaissance", query = "SELECT i FROM Individu i WHERE i.dateNaissance = :dateNaissance")
    , @NamedQuery(name = "Individu.findByEmail", query = "SELECT i FROM Individu i WHERE i.email = :email")
    , @NamedQuery(name = "Individu.findBySexe", query = "SELECT i FROM Individu i WHERE i.sexe = :sexe")
    , @NamedQuery(name = "Individu.findByTelephone", query = "SELECT i FROM Individu i WHERE i.telephone = :telephone")
    , @NamedQuery(name = "Individu.findByCreated", query = "SELECT i FROM Individu i WHERE i.created = :created")
    , @NamedQuery(name = "Individu.findByModified", query = "SELECT i FROM Individu i WHERE i.modified = :modified")
    , @NamedQuery(name = "Individu.findByDeleted", query = "SELECT i FROM Individu i WHERE i.deleted = :deleted")})
public class Individu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idindividu", nullable = false)
    private Integer idindividu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "matricule", nullable = false, length = 254)
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "noms", nullable = false, length = 45)
    private String noms;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prenoms", nullable = false, length = 45)
    private String prenoms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_naissance", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "lieu_naissance", nullable = false, length = 65535)
    private String lieuNaissance;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email", length = 254)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexe", nullable = false, length = 1)
    private String sexe;
    @Size(max = 45)
    @Column(name = "telephone", length = 45)
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "residence", nullable = false, length = 65535)
    private String residence;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "individuIdindividu")
    @JsonIgnore
    private Collection<Absence> absenceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "individuIdindividu")
    @JsonIgnore
    private Collection<Eleve> eleveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "individuIdindividu")
    private Collection<Retard> retardCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "individuIdindividu")
    @JsonIgnore
    private Collection<Employe> employeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "individuIdindividu")
    @JsonIgnore
    private Collection<IndividuUtilisateur> individuUtilisateurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "individuIdindividu")
    @JsonIgnore
    private Collection<Enseignant> enseignantCollection;

    public Individu() {
    }

    public Individu(Integer idindividu) {
        this.idindividu = idindividu;
    }

    public Individu(Integer idindividu, String matricule, String noms, String prenoms, Date dateNaissance, String lieuNaissance, String sexe, String residence, boolean deleted) {
        this.idindividu = idindividu;
        this.matricule = matricule;
        this.noms = noms;
        this.prenoms = prenoms;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.sexe = sexe;
        this.residence = residence;
        this.deleted = deleted;
    }

    public Integer getIdindividu() {
        return idindividu;
    }

    public void setIdindividu(Integer idindividu) {
        this.idindividu = idindividu;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
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
    public Collection<Absence> getAbsenceCollection() {
        return absenceCollection;
    }

    public void setAbsenceCollection(Collection<Absence> absenceCollection) {
        this.absenceCollection = absenceCollection;
    }

    @XmlTransient
    public Collection<Eleve> getEleveCollection() {
        return eleveCollection;
    }

    public void setEleveCollection(Collection<Eleve> eleveCollection) {
        this.eleveCollection = eleveCollection;
    }

    @XmlTransient
    public Collection<Retard> getRetardCollection() {
        return retardCollection;
    }

    public void setRetardCollection(Collection<Retard> retardCollection) {
        this.retardCollection = retardCollection;
    }

    @XmlTransient
    public Collection<Employe> getEmployeCollection() {
        return employeCollection;
    }

    public void setEmployeCollection(Collection<Employe> employeCollection) {
        this.employeCollection = employeCollection;
    }

    @XmlTransient
    public Collection<IndividuUtilisateur> getIndividuUtilisateurCollection() {
        return individuUtilisateurCollection;
    }

    public void setIndividuUtilisateurCollection(Collection<IndividuUtilisateur> individuUtilisateurCollection) {
        this.individuUtilisateurCollection = individuUtilisateurCollection;
    }

    @XmlTransient
    public Collection<Enseignant> getEnseignantCollection() {
        return enseignantCollection;
    }

    public void setEnseignantCollection(Collection<Enseignant> enseignantCollection) {
        this.enseignantCollection = enseignantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idindividu != null ? idindividu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Individu)) {
            return false;
        }
        Individu other = (Individu) object;
        if ((this.idindividu == null && other.idindividu != null) || (this.idindividu != null && !this.idindividu.equals(other.idindividu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Individu[ idindividu=" + idindividu + " ]";
    }
    
}
