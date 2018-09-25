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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "compte_parent_eleve", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompteParentEleve.findAll", query = "SELECT c FROM CompteParentEleve c")
    , @NamedQuery(name = "CompteParentEleve.findByIdcompteParentEleve", query = "SELECT c FROM CompteParentEleve c WHERE c.idcompteParentEleve = :idcompteParentEleve")})
public class CompteParentEleve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompte_parent_eleve", nullable = false)
    private Integer idcompteParentEleve;
    @JoinColumn(name = "compte_parent", referencedColumnName = "idcompte_parent")
    @ManyToOne(fetch = FetchType.EAGER)
    private CompteParent compteParent;
    @JoinColumn(name = "eleve", referencedColumnName = "ideleve")
    @ManyToOne(fetch = FetchType.EAGER)
    private Eleve eleve;

    public CompteParentEleve() {
    }

    public CompteParentEleve(Integer idcompteParentEleve) {
        this.idcompteParentEleve = idcompteParentEleve;
    }

    public Integer getIdcompteParentEleve() {
        return idcompteParentEleve;
    }

    public void setIdcompteParentEleve(Integer idcompteParentEleve) {
        this.idcompteParentEleve = idcompteParentEleve;
    }

    public CompteParent getCompteParent() {
        return compteParent;
    }

    public void setCompteParent(CompteParent compteParent) {
        this.compteParent = compteParent;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompteParentEleve != null ? idcompteParentEleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteParentEleve)) {
            return false;
        }
        CompteParentEleve other = (CompteParentEleve) object;
        if ((this.idcompteParentEleve == null && other.idcompteParentEleve != null) || (this.idcompteParentEleve != null && !this.idcompteParentEleve.equals(other.idcompteParentEleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.CompteParentEleve[ idcompteParentEleve=" + idcompteParentEleve + " ]";
    }
    
}
