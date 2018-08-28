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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "employe", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e")
    , @NamedQuery(name = "Employe.findByIdemploye", query = "SELECT e FROM Employe e WHERE e.idemploye = :idemploye")
    , @NamedQuery(name = "Employe.findByCreated", query = "SELECT e FROM Employe e WHERE e.created = :created")
    , @NamedQuery(name = "Employe.findByModified", query = "SELECT e FROM Employe e WHERE e.modified = :modified")
    , @NamedQuery(name = "Employe.findByDeleted", query = "SELECT e FROM Employe e WHERE e.deleted = :deleted")})
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idemploye", nullable = false)
    private Integer idemploye;
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
    @JoinColumn(name = "individu_idindividu", referencedColumnName = "idindividu", nullable = false)
    @ManyToOne(optional = false)
    private Individu individuIdindividu;

    public Employe() {
    }

    public Employe(Integer idemploye) {
        this.idemploye = idemploye;
    }

    public Employe(Integer idemploye, boolean deleted) {
        this.idemploye = idemploye;
        this.deleted = deleted;
    }

    public Integer getIdemploye() {
        return idemploye;
    }

    public void setIdemploye(Integer idemploye) {
        this.idemploye = idemploye;
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

    public Individu getIndividuIdindividu() {
        return individuIdindividu;
    }

    public void setIndividuIdindividu(Individu individuIdindividu) {
        this.individuIdindividu = individuIdindividu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idemploye != null ? idemploye.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.idemploye == null && other.idemploye != null) || (this.idemploye != null && !this.idemploye.equals(other.idemploye))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Employe[ idemploye=" + idemploye + " ]";
    }
    
}
