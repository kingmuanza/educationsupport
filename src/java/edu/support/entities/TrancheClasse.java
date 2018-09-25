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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "tranche_classe", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrancheClasse.findAll", query = "SELECT t FROM TrancheClasse t")
    , @NamedQuery(name = "TrancheClasse.findByIdtrancheClasse", query = "SELECT t FROM TrancheClasse t WHERE t.idtrancheClasse = :idtrancheClasse")
    , @NamedQuery(name = "TrancheClasse.findByClasse", query = "SELECT t FROM TrancheClasse t WHERE t.classe = :classe")
    , @NamedQuery(name = "TrancheClasse.findByTranche", query = "SELECT t FROM TrancheClasse t WHERE t.tranche = :tranche")})
public class TrancheClasse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtranche_classe", nullable = false)
    private Integer idtrancheClasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classe", nullable = false)
    private int classe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tranche", nullable = false)
    private int tranche;

    public TrancheClasse() {
    }

    public TrancheClasse(Integer idtrancheClasse) {
        this.idtrancheClasse = idtrancheClasse;
    }

    public TrancheClasse(Integer idtrancheClasse, int classe, int tranche) {
        this.idtrancheClasse = idtrancheClasse;
        this.classe = classe;
        this.tranche = tranche;
    }

    public Integer getIdtrancheClasse() {
        return idtrancheClasse;
    }

    public void setIdtrancheClasse(Integer idtrancheClasse) {
        this.idtrancheClasse = idtrancheClasse;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public int getTranche() {
        return tranche;
    }

    public void setTranche(int tranche) {
        this.tranche = tranche;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrancheClasse != null ? idtrancheClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrancheClasse)) {
            return false;
        }
        TrancheClasse other = (TrancheClasse) object;
        if ((this.idtrancheClasse == null && other.idtrancheClasse != null) || (this.idtrancheClasse != null && !this.idtrancheClasse.equals(other.idtrancheClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.TrancheClasse[ idtrancheClasse=" + idtrancheClasse + " ]";
    }
    
}
