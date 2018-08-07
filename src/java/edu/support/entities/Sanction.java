/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * @author zos hall
 */
@Entity
@Table(name = "sanction", catalog = "edusupport_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sanction.findAll", query = "SELECT s FROM Sanction s")
    , @NamedQuery(name = "Sanction.findByIdsanction", query = "SELECT s FROM Sanction s WHERE s.idsanction = :idsanction")
    , @NamedQuery(name = "Sanction.findByDescription", query = "SELECT s FROM Sanction s WHERE s.description = :description")
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
    @Column(name = "description", nullable = false, length = 45)
    private String description;
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
    private boolean deleted;
    @JoinColumn(name = "eleve_ideleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Eleve eleveIdeleve;
    @JoinColumn(name = "employe_idemploye", referencedColumnName = "idemploye")
    @ManyToOne
    @JsonIgnore
    private Employe employeIdemploye;
    @JoinColumn(name = "enseignant_idenseignant", referencedColumnName = "idenseignant")
    @ManyToOne
    @JsonIgnore
    private Enseignant enseignantIdenseignant;

    public Sanction() {
    }

    public Sanction(Integer idsanction) {
        this.idsanction = idsanction;
    }

    public Sanction(Integer idsanction, String description, String motif, boolean deleted) {
        this.idsanction = idsanction;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Employe getEmployeIdemploye() {
        return employeIdemploye;
    }

    public void setEmployeIdemploye(Employe employeIdemploye) {
        this.employeIdemploye = employeIdemploye;
    }

    public Enseignant getEnseignantIdenseignant() {
        return enseignantIdenseignant;
    }

    public void setEnseignantIdenseignant(Enseignant enseignantIdenseignant) {
        this.enseignantIdenseignant = enseignantIdenseignant;
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
