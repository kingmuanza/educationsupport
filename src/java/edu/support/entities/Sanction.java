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
@Table(name = "sanction", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sanction.findAll", query = "SELECT s FROM Sanction s")
    , @NamedQuery(name = "Sanction.findByIdsanction", query = "SELECT s FROM Sanction s WHERE s.idsanction = :idsanction")
    , @NamedQuery(name = "Sanction.findByCode", query = "SELECT s FROM Sanction s WHERE s.code = :code")
    , @NamedQuery(name = "Sanction.findByDescription", query = "SELECT s FROM Sanction s WHERE s.description = :description")
    , @NamedQuery(name = "Sanction.findByDateJour", query = "SELECT s FROM Sanction s WHERE s.dateJour = :dateJour")
    , @NamedQuery(name = "Sanction.findByCreated", query = "SELECT s FROM Sanction s WHERE s.created = :created")
    , @NamedQuery(name = "Sanction.findByModified", query = "SELECT s FROM Sanction s WHERE s.modified = :modified")
    , @NamedQuery(name = "Sanction.findByDeleted", query = "SELECT s FROM Sanction s WHERE s.deleted = :deleted")})
public class Sanction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsanction", nullable = false)
    private Integer idsanction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description", nullable = false, length = 45)
    private String description;
    @Column(name = "date_jour")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateJour;
    @Basic(optional = false)
    @NotNull
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
    @NotNull
    @Column(name = "deleted", nullable = false)
    private short deleted;
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false)
    private Eleve eleveIdeleve;

    public Sanction() {
    }

    public Sanction(Integer idsanction) {
        this.idsanction = idsanction;
    }

    public Sanction(Integer idsanction, String code, String description, String motif, short deleted) {
        this.idsanction = idsanction;
        this.code = code;
        this.description = description;
        this.motif = motif;
        this.deleted = deleted;
    }

    public Integer getIdsanction() {
        return idsanction;
    }

    public void setIdsanction(Integer idsanction) {
        this.idsanction = idsanction;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateJour() {
        return dateJour;
    }

    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
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

    public Eleve getEleveIdeleve() {
        return eleveIdeleve;
    }

    public void setEleveIdeleve(Eleve eleveIdeleve) {
        this.eleveIdeleve = eleveIdeleve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsanction != null ? idsanction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sanction)) {
            return false;
        }
        Sanction other = (Sanction) object;
        if ((this.idsanction == null && other.idsanction != null) || (this.idsanction != null && !this.idsanction.equals(other.idsanction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Sanction[ idsanction=" + idsanction + " ]";
    }
    
}
