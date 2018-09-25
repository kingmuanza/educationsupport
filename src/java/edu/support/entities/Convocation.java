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
import org.springframework.format.annotation.DateTimeFormat;

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
    , @NamedQuery(name = "Convocation.findByCode", query = "SELECT c FROM Convocation c WHERE c.code = :code")
    , @NamedQuery(name = "Convocation.findByDateJour", query = "SELECT c FROM Convocation c WHERE c.dateJour = :dateJour")
    , @NamedQuery(name = "Convocation.findByCreated", query = "SELECT c FROM Convocation c WHERE c.created = :created")
    , @NamedQuery(name = "Convocation.findByModified", query = "SELECT c FROM Convocation c WHERE c.modified = :modified")
    , @NamedQuery(name = "Convocation.findByDeleted", query = "SELECT c FROM Convocation c WHERE c.deleted = :deleted")})
public class Convocation implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @NotNull    
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "motif", nullable = false, length = 65535)
    private String motif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconvocation", nullable = false)
    private Integer idconvocation;
    @Column(name = "date_jour")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateJour;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modified;
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false)
    private Eleve eleveIdeleve;

    public Convocation() {
    }

    public Convocation(Integer idconvocation) {
        this.idconvocation = idconvocation;
    }

    public Convocation(Integer idconvocation, String code, String motif, boolean deleted) {
        this.idconvocation = idconvocation;
        this.code = code;
        this.motif = motif;
        this.deleted = deleted;
    }

    public Integer getIdconvocation() {
        return idconvocation;
    }

    public void setIdconvocation(Integer idconvocation) {
        this.idconvocation = idconvocation;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
}
