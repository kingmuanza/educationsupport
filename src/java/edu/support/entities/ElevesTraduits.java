/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.entities;

import java.io.Serializable;
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
    , @NamedQuery(name = "ElevesTraduits.findByIdelevesTraduits", query = "SELECT e FROM ElevesTraduits e WHERE e.idelevesTraduits = :idelevesTraduits")})
public class ElevesTraduits implements Serializable {

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
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Eleve eleveIdeleve;
    @JoinColumn(name = "conseil_discipline_idconseil_discipline", referencedColumnName = "idconseil_discipline", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ConseilDiscipline conseilDisciplineIdconseilDiscipline;

    public ElevesTraduits() {
    }

    public ElevesTraduits(Integer idelevesTraduits) {
        this.idelevesTraduits = idelevesTraduits;
    }

    public ElevesTraduits(Integer idelevesTraduits, String motif) {
        this.idelevesTraduits = idelevesTraduits;
        this.motif = motif;
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
