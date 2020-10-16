/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamark.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Maraoui
 */
@Entity
@Table(name = "ODR")
@NamedQueries({
    @NamedQuery(name = "Odr.findAll", query = "SELECT o FROM Odr o"),
    @NamedQuery(name = "Odr.findById", query = "SELECT o FROM Odr o WHERE o.id = :id"),
    @NamedQuery(name = "Odr.findByIduser", query = "SELECT o FROM Odr o WHERE o.iduser = :iduser"),
    @NamedQuery(name = "Odr.findByIdbuild", query = "SELECT o FROM Odr o WHERE o.idbuild = :idbuild"),
    @NamedQuery(name = "Odr.findByIdstatus", query = "SELECT o FROM Odr o WHERE o.idstatus = :idstatus"),
    @NamedQuery(name = "Odr.findByOrderdate", query = "SELECT o FROM Odr o WHERE o.orderdate = :orderdate"),
    @NamedQuery(name = "Odr.findByShipdate", query = "SELECT o FROM Odr o WHERE o.shipdate = :shipdate")})
public class Odr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IDUSER")
    private Integer iduser;
    @Column(name = "IDBUILD")
    private Integer idbuild;
    @Column(name = "IDSTATUS")
    private Integer idstatus;
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    @Column(name = "SHIPDATE")
    @Temporal(TemporalType.DATE)
    private Date shipdate;

    public Odr() {
    }

    public Odr(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIdbuild() {
        return idbuild;
    }

    public void setIdbuild(Integer idbuild) {
        this.idbuild = idbuild;
    }

    public Integer getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Integer idstatus) {
        this.idstatus = idstatus;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odr)) {
            return false;
        }
        Odr other = (Odr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamark.jpa.Odr[ id=" + id + " ]";
    }
    
}
