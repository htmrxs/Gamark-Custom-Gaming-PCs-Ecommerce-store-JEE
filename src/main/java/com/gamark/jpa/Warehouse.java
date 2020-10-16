/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamark.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Maraoui
 */
@Entity
@Table(name = "WAREHOUSE")
@NamedQueries({
    @NamedQuery(name = "Warehouse.findAll", query = "SELECT w FROM Warehouse w"),
    @NamedQuery(name = "Warehouse.findByIdtype", query = "SELECT w FROM Warehouse w WHERE w.warehousePK.idtype = :idtype"),
    @NamedQuery(name = "Warehouse.findByIdproduct", query = "SELECT w FROM Warehouse w WHERE w.warehousePK.idproduct = :idproduct"),
    @NamedQuery(name = "Warehouse.findByStock", query = "SELECT w FROM Warehouse w WHERE w.stock = :stock")})
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WarehousePK warehousePK;
    @Column(name = "STOCK")
    private Integer stock;

    public Warehouse() {
    }

    public Warehouse(WarehousePK warehousePK) {
        this.warehousePK = warehousePK;
    }

    public Warehouse(int idtype, int idproduct) {
        this.warehousePK = new WarehousePK(idtype, idproduct);
    }

    public WarehousePK getWarehousePK() {
        return warehousePK;
    }

    public void setWarehousePK(WarehousePK warehousePK) {
        this.warehousePK = warehousePK;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (warehousePK != null ? warehousePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warehouse)) {
            return false;
        }
        Warehouse other = (Warehouse) object;
        if ((this.warehousePK == null && other.warehousePK != null) || (this.warehousePK != null && !this.warehousePK.equals(other.warehousePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamark.jpa.Warehouse[ warehousePK=" + warehousePK + " ]";
    }
    
}
