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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "autorisation_sortie", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutorisationSortie.findAll", query = "SELECT a FROM AutorisationSortie a")
    , @NamedQuery(name = "AutorisationSortie.findByIdautorisationSortie", query = "SELECT a FROM AutorisationSortie a WHERE a.idautorisationSortie = :idautorisationSortie")
    , @NamedQuery(name = "AutorisationSortie.findByCode", query = "SELECT a FROM AutorisationSortie a WHERE a.code = :code")
    , @NamedQuery(name = "AutorisationSortie.findByDateJour", query = "SELECT a FROM AutorisationSortie a WHERE a.dateJour = :dateJour")
    , @NamedQuery(name = "AutorisationSortie.findByCreated", query = "SELECT a FROM AutorisationSortie a WHERE a.created = :created")
    , @NamedQuery(name = "AutorisationSortie.findByModified", query = "SELECT a FROM AutorisationSortie a WHERE a.modified = :modified")
    , @NamedQuery(name = "AutorisationSortie.findByDeleted", query = "SELECT a FROM AutorisationSortie a WHERE a.deleted = :deleted")})
public class AutorisationSortie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idautorisation_sortie", nullable = false)
    private Integer idautorisationSortie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_jour", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateJour;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleted;
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Eleve eleveIdeleve;
    @JoinColumn(name = "employe_idemploye", referencedColumnName = "idemploye", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employe employeIdemploye;

    public AutorisationSortie() {
    }

    public AutorisationSortie(Integer idautorisationSortie) {
        this.idautorisationSortie = idautorisationSortie;
    }

    public AutorisationSortie(Integer idautorisationSortie, String code, Date dateJour, Date created, Date modified, Date deleted) {
        this.idautorisationSortie = idautorisationSortie;
        this.code = code;
        this.dateJour = dateJour;
        this.created = created;
        this.modified = modified;
        this.deleted = deleted;
    }

    public Integer getIdautorisationSortie() {
        return idautorisationSortie;
    }

    public void setIdautorisationSortie(Integer idautorisationSortie) {
        this.idautorisationSortie = idautorisationSortie;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateJour() {
        return dateJour;
    }

    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
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

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    public Eleve getEleveIdeleve() {
        return eleveIdeleve;
    }

    public void setEleveIdeleve(Eleve eleveIdeleve) {
        this.eleveIdeleve = eleveIdeleve;
    }

    public Employe getEmployeIdemploye() {
        return employeIdemploye;
    }

    public void setEmployeIdemploye(Employe employeIdemploye) {
        this.employeIdemploye = employeIdemploye;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idautorisationSortie != null ? idautorisationSortie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorisationSortie)) {
            return false;
        }
        AutorisationSortie other = (AutorisationSortie) object;
        if ((this.idautorisationSortie == null && other.idautorisationSortie != null) || (this.idautorisationSortie != null && !this.idautorisationSortie.equals(other.idautorisationSortie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.AutorisationSortie[ idautorisationSortie=" + idautorisationSortie + " ]";
    }
    
}