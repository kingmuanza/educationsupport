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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "eleve_traduit", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EleveTraduit.findAll", query = "SELECT e FROM EleveTraduit e")
    , @NamedQuery(name = "EleveTraduit.findByIdelevesTraduits", query = "SELECT e FROM EleveTraduit e WHERE e.idelevesTraduits = :idelevesTraduits")
    , @NamedQuery(name = "EleveTraduit.findByCreated", query = "SELECT e FROM EleveTraduit e WHERE e.created = :created")
    , @NamedQuery(name = "EleveTraduit.findByModified", query = "SELECT e FROM EleveTraduit e WHERE e.modified = :modified")
    , @NamedQuery(name = "EleveTraduit.findByDeleted", query = "SELECT e FROM EleveTraduit e WHERE e.deleted = :deleted")})
public class EleveTraduit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideleves_traduits", nullable = false)
    private Integer idelevesTraduits;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "motif", nullable = false, length = 65535)
    private String motif;
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
    @JoinColumn(name = "conseil_discipline_idconseil_discipline", referencedColumnName = "idconseil_discipline", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ConseilDiscipline conseilDisciplineIdconseilDiscipline;
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Eleve eleveIdeleve;

    public EleveTraduit() {
    }

    public EleveTraduit(Integer idelevesTraduits) {
        this.idelevesTraduits = idelevesTraduits;
    }

    public EleveTraduit(Integer idelevesTraduits, String motif, boolean deleted) {
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

    public ConseilDiscipline getConseilDisciplineIdconseilDiscipline() {
        return conseilDisciplineIdconseilDiscipline;
    }

    public void setConseilDisciplineIdconseilDiscipline(ConseilDiscipline conseilDisciplineIdconseilDiscipline) {
        this.conseilDisciplineIdconseilDiscipline = conseilDisciplineIdconseilDiscipline;
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
        hash += (idelevesTraduits != null ? idelevesTraduits.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EleveTraduit)) {
            return false;
        }
        EleveTraduit other = (EleveTraduit) object;
        if ((this.idelevesTraduits == null && other.idelevesTraduits != null) || (this.idelevesTraduits != null && !this.idelevesTraduits.equals(other.idelevesTraduits))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.EleveTraduit[ idelevesTraduits=" + idelevesTraduits + " ]";
    }
    
}
