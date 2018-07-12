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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "convocation", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convocation.findAll", query = "SELECT c FROM Convocation c")
    , @NamedQuery(name = "Convocation.findByIdconvocation", query = "SELECT c FROM Convocation c WHERE c.idconvocation = :idconvocation")
    , @NamedQuery(name = "Convocation.findByCreated", query = "SELECT c FROM Convocation c WHERE c.created = :created")
    , @NamedQuery(name = "Convocation.findByModified", query = "SELECT c FROM Convocation c WHERE c.modified = :modified")
    , @NamedQuery(name = "Convocation.findByDeleted", query = "SELECT c FROM Convocation c WHERE c.deleted = :deleted")})
public class Convocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconvocation", nullable = false)
    private Integer idconvocation;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "motif", nullable = false, length = 65535)
    private String motif;
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
    @JoinColumn(name = "employe_idemploye", referencedColumnName = "idemploye", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employe employeIdemploye;
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Eleve eleveIdeleve;

    public Convocation() {
    }

    public Convocation(Integer idconvocation) {
        this.idconvocation = idconvocation;
    }

    public Convocation(Integer idconvocation, String motif, Date created, Date modified, short deleted) {
        this.idconvocation = idconvocation;
        this.motif = motif;
        this.created = created;
        this.modified = modified;
        this.deleted = deleted;
    }

    public Integer getIdconvocation() {
        return idconvocation;
    }

    public void setIdconvocation(Integer idconvocation) {
        this.idconvocation = idconvocation;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
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

    public Employe getEmployeIdemploye() {
        return employeIdemploye;
    }

    public void setEmployeIdemploye(Employe employeIdemploye) {
        this.employeIdemploye = employeIdemploye;
    }

    public Eleve getEleveIdeleve() {
        return eleveIdeleve;
    }

    public void setEleveIdeleve(Eleve eleveIdeleve) {
        this.eleveIdeleve = eleveIdeleve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconvocation != null ? idconvocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convocation)) {
            return false;
        }
        Convocation other = (Convocation) object;
        if ((this.idconvocation == null && other.idconvocation != null) || (this.idconvocation != null && !this.idconvocation.equals(other.idconvocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Convocation[ idconvocation=" + idconvocation + " ]";
    }
    
}