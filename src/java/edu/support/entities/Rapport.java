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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author N9-T
 */
@Entity
@Table(name = "rapport", catalog = "edusupport_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rapport.findAll", query = "SELECT r FROM Rapport r")
    , @NamedQuery(name = "Rapport.findByIdrapport", query = "SELECT r FROM Rapport r WHERE r.idrapport = :idrapport")
    , @NamedQuery(name = "Rapport.findByCode", query = "SELECT r FROM Rapport r WHERE r.code = :code")
    , @NamedQuery(name = "Rapport.findByNomFichier", query = "SELECT r FROM Rapport r WHERE r.nomFichier = :nomFichier")
    , @NamedQuery(name = "Rapport.findByCreated", query = "SELECT r FROM Rapport r WHERE r.created = :created")
    , @NamedQuery(name = "Rapport.findByModified", query = "SELECT r FROM Rapport r WHERE r.modified = :modified")
    , @NamedQuery(name = "Rapport.findByDeleted", query = "SELECT r FROM Rapport r WHERE r.deleted = :deleted")})
public class Rapport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrapport", nullable = false)
    private Integer idrapport;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_fichier", nullable = false, length = 45)
    private String nomFichier;
    @Lob
    @Size(max = 65535)
    @Column(name = "url", length = 65535)
    private String url;
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
    @JoinColumn(name = "reunion_idreunion", referencedColumnName = "idreunion", nullable = false)
    @ManyToOne(optional = false)
    private Reunion reunionIdreunion;

    public Rapport() {
    }

    public Rapport(Integer idrapport) {
        this.idrapport = idrapport;
    }

    public Rapport(Integer idrapport, String code, String nomFichier, short deleted) {
        this.idrapport = idrapport;
        this.code = code;
        this.nomFichier = nomFichier;
        this.deleted = deleted;
    }

    public Integer getIdrapport() {
        return idrapport;
    }

    public void setIdrapport(Integer idrapport) {
        this.idrapport = idrapport;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Reunion getReunionIdreunion() {
        return reunionIdreunion;
    }

    public void setReunionIdreunion(Reunion reunionIdreunion) {
        this.reunionIdreunion = reunionIdreunion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrapport != null ? idrapport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rapport)) {
            return false;
        }
        Rapport other = (Rapport) object;
        if ((this.idrapport == null && other.idrapport != null) || (this.idrapport != null && !this.idrapport.equals(other.idrapport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.support.entities.Rapport[ idrapport=" + idrapport + " ]";
    }
    
}
