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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "classe", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c")
    , @NamedQuery(name = "Classe.findByIdclasse", query = "SELECT c FROM Classe c WHERE c.idclasse = :idclasse")
    , @NamedQuery(name = "Classe.findByCode", query = "SELECT c FROM Classe c WHERE c.code = :code")
    , @NamedQuery(name = "Classe.findByLibelle", query = "SELECT c FROM Classe c WHERE c.libelle = :libelle")
    , @NamedQuery(name = "Classe.findByFraisScolarite", query = "SELECT c FROM Classe c WHERE c.fraisScolarite = :fraisScolarite")
    , @NamedQuery(name = "Classe.findByCreated", query = "SELECT c FROM Classe c WHERE c.created = :created")
    , @NamedQuery(name = "Classe.findByModified", query = "SELECT c FROM Classe c WHERE c.modified = :modified")
    , @NamedQuery(name = "Classe.findByDeleted", query = "SELECT c FROM Classe c WHERE c.deleted = :deleted")})
public class Classe implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Size(max = 45)
    @Column(name = "libelle", length = 45)
    private String libelle;
    @JoinColumn(name = "serie", referencedColumnName = "idserie")
    @ManyToOne(fetch = FetchType.EAGER)
    private Serie serie;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "idclasse", nullable = false)
    private Integer idclasse;
    @Basic(optional = false)
    
    @Column(name = "frais_scolarite", nullable = false)
    private double fraisScolarite;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modified;
    @Basic(optional = false)
    
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classeIdclasse")
    private Collection<SalleDeClasse> salleDeClasseCollection;

    public Classe() {
    }

    public Classe(Integer idclasse) {
        this.idclasse = idclasse;
    }

    public Classe(Integer idclasse, String code, double fraisScolarite, boolean deleted) {
        this.idclasse = idclasse;
        this.code = code;
        this.fraisScolarite = fraisScolarite;
        this.deleted = deleted;
    }

    public Integer getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Integer idclasse) {
        this.idclasse = idclasse;
    }


    public double getFraisScolarite() {
        return fraisScolarite;
    }

    public void setFraisScolarite(double fraisScolarite) {
        this.fraisScolarite = fraisScolarite;
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
    public Collection<SalleDeClasse> getSalleDeClasseCollection() {
        return salleDeClasseCollection;
    }

    public void setSalleDeClasseCollection(Collection<SalleDeClasse> salleDeClasseCollection) {
        this.salleDeClasseCollection = salleDeClasseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclasse != null ? idclasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.idclasse == null && other.idclasse != null) || (this.idclasse != null && !this.idclasse.equals(other.idclasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Classe[ idclasse=" + idclasse + " ]";
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

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    
}
