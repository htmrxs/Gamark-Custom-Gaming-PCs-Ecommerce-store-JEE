/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamark.jpa;

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

/**
 *
 * @author Maraoui
 */
@Entity
@Table(name = "BUILD")
@NamedQueries({
    @NamedQuery(name = "Build.findAll", query = "SELECT b FROM Build b"),
    @NamedQuery(name = "Build.findById", query = "SELECT b FROM Build b WHERE b.id = :id"),
    @NamedQuery(name = "Build.findByIdcase", query = "SELECT b FROM Build b WHERE b.idcase = :idcase"),
    @NamedQuery(name = "Build.findByIdmotherboard", query = "SELECT b FROM Build b WHERE b.idmotherboard = :idmotherboard"),
    @NamedQuery(name = "Build.findByIdcpu", query = "SELECT b FROM Build b WHERE b.idcpu = :idcpu"),
    @NamedQuery(name = "Build.findByIdgpu", query = "SELECT b FROM Build b WHERE b.idgpu = :idgpu"),
    @NamedQuery(name = "Build.findByIdram", query = "SELECT b FROM Build b WHERE b.idram = :idram"),
    @NamedQuery(name = "Build.findByIdstorage", query = "SELECT b FROM Build b WHERE b.idstorage = :idstorage"),
    @NamedQuery(name = "Build.findByIdpsu", query = "SELECT b FROM Build b WHERE b.idpsu = :idpsu"),
    @NamedQuery(name = "Build.findByPrice", query = "SELECT b FROM Build b WHERE b.price = :price")})
public class Build implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IDCASE")
    private Integer idcase;
    @Column(name = "IDMOTHERBOARD")
    private Integer idmotherboard;
    @Column(name = "IDCPU")
    private Integer idcpu;
    @Column(name = "IDGPU")
    private Integer idgpu;
    @Column(name = "IDRAM")
    private Integer idram;
    @Column(name = "IDSTORAGE")
    private Integer idstorage;
    @Column(name = "IDPSU")
    private Integer idpsu;
    @Column(name = "PRICE")
    private Integer price;

    public Build() {
    }

    public Build(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdcase() {
        return idcase;
    }

    public void setIdcase(Integer idcase) {
        this.idcase = idcase;
    }

    public Integer getIdmotherboard() {
        return idmotherboard;
    }

    public void setIdmotherboard(Integer idmotherboard) {
        this.idmotherboard = idmotherboard;
    }

    public Integer getIdcpu() {
        return idcpu;
    }

    public void setIdcpu(Integer idcpu) {
        this.idcpu = idcpu;
    }

    public Integer getIdgpu() {
        return idgpu;
    }

    public void setIdgpu(Integer idgpu) {
        this.idgpu = idgpu;
    }

    public Integer getIdram() {
        return idram;
    }

    public void setIdram(Integer idram) {
        this.idram = idram;
    }

    public Integer getIdstorage() {
        return idstorage;
    }

    public void setIdstorage(Integer idstorage) {
        this.idstorage = idstorage;
    }

    public Integer getIdpsu() {
        return idpsu;
    }

    public void setIdpsu(Integer idpsu) {
        this.idpsu = idpsu;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
        if (!(object instanceof Build)) {
            return false;
        }
        Build other = (Build) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamark.jpa.Build[ id=" + id + " ]";
    }
    
}
