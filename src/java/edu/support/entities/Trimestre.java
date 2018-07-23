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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zos hall
 */
@Entity
@Table(name = "trimestre", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"numero"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trimestre.findAll", query = "SELECT t FROM Trimestre t")
    , @NamedQuery(name = "Trimestre.findByIdtrimestre", query = "SELECT t FROM Trimestre t WHERE t.idtrimestre = :idtrimestre")
    , @NamedQuery(name = "Trimestre.findByNumero", query = "SELECT t FROM Trimestre t WHERE t.numero = :numero")
    , @NamedQuery(name = "Trimestre.findByCreated", query = "SELECT t FROM Trimestre t WHERE t.created = :created")
    , @NamedQuery(name = "Trimestre.findByModified", query = "SELECT t FROM Trimestre t WHERE t.modified = :modified")
    , @NamedQuery(name = "Trimestre.findByDeleted", query = "SELECT t FROM Trimestre t WHERE t.deleted = :deleted")})
public class Trimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtrimestre", nullable = false)
    private Integer idtrimestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero", nullable = false)
    private int numero;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimestreIdtrimestre")
    private Collection<Sequence> sequenceCollection;

    public Trimestre() {
    }

    public Trimestre(Integer idtrimestre) {
        this.idtrimestre = idtrimestre;
    }

    public Trimestre(Integer idtrimestre, int numero, boolean deleted) {
        this.idtrimestre = idtrimestre;
        this.numero = numero;
        this.deleted = deleted;
    }

    public Integer getIdtrimestre() {
        return idtrimestre;
    }

    public void setIdtrimestre(Integer idtrimestre) {
        this.idtrimestre = idtrimestre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
    public Collection<Sequence> getSequenceCollection() {
        return sequenceCollection;
    }

    public void setSequenceCollection(Collection<Sequence> sequenceCollection) {
        this.sequenceCollection = sequenceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrimestre != null ? idtrimestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trimestre)) {
            return false;
        }
        Trimestre other = (Trimestre) object;
        if ((this.idtrimestre == null && other.idtrimestre != null) || (this.idtrimestre != null && !this.idtrimestre.equals(other.idtrimestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Trimestre[ idtrimestre=" + idtrimestre + " ]";
    }
    
}
