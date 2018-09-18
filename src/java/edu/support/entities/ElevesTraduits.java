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
@Table(name = "eleves_traduits", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ElevesTraduits.findAll", query = "SELECT e FROM ElevesTraduits e")
    , @NamedQuery(name = "ElevesTraduits.findByIdelevesTraduits", query = "SELECT e FROM ElevesTraduits e WHERE e.idelevesTraduits = :idelevesTraduits")
    , @NamedQuery(name = "ElevesTraduits.findByCreated", query = "SELECT e FROM ElevesTraduits e WHERE e.created = :created")
    , @NamedQuery(name = "ElevesTraduits.findByModified", query = "SELECT e FROM ElevesTraduits e WHERE e.modified = :modified")
    , @NamedQuery(name = "ElevesTraduits.findByDeleted", query = "SELECT e FROM ElevesTraduits e WHERE e.deleted = :deleted")})
public class ElevesTraduits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideleves_traduits", nullable = false)
    private Integer idelevesTraduits;
    @Basic(optional = false)
    
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "motif", nullable = false, length = 65535)
    private String motif;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false)
    private Eleve eleveIdeleve;
    @JoinColumn(name = "conseil_discipline_idconseil_discipline", referencedColumnName = "idconseil_discipline", nullable = false)
    @ManyToOne(optional = false)
    private ConseilDiscipline conseilDisciplineIdconseilDiscipline;

    public ElevesTraduits() {
    }

    public ElevesTraduits(Integer idelevesTraduits) {
        this.idelevesTraduits = idelevesTraduits;
    }

    public ElevesTraduits(Integer idelevesTraduits, String motif, boolean deleted) {
        this.idelevesTraduits = idelevesTraduits;
        this.motif = motif;
        this.deleted = deleted;
    }

    public Integer getIdelevesTraduits() {
        return idelevesTraduits;
    }

    public void setIdelevesTraduits(Integer idelevesTraduits) {
        this.idelevesTraduits = idelevesTraduits;
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

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Eleve getEleveIdeleve() {
        return eleveIdeleve;
    }

    public void setEleveIdeleve(Eleve eleveIdeleve) {
        this.eleveIdeleve = eleveIdeleve;
    }

    public ConseilDiscipline getConseilDisciplineIdconseilDiscipline() {
        return conseilDisciplineIdconseilDiscipline;
    }

    public void setConseilDisciplineIdconseilDiscipline(ConseilDiscipline conseilDisciplineIdconseilDiscipline) {
        this.conseilDisciplineIdconseilDiscipline = conseilDisciplineIdconseilDiscipline;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idelevesTraduits != null ? idelevesTraduits.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElevesTraduits)) {
            return false;
        }
        ElevesTraduits other = (ElevesTraduits) object;
        if ((this.idelevesTraduits == null && other.idelevesTraduits != null) || (this.idelevesTraduits != null && !this.idelevesTraduits.equals(other.idelevesTraduits))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.ElevesTraduits[ idelevesTraduits=" + idelevesTraduits + " ]";
    }
    
}
