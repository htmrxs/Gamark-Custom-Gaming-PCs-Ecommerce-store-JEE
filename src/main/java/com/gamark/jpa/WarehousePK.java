/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamark.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Maraoui
 */
@Embeddable
public class WarehousePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTYPE")
    private int idtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRODUCT")
    private int idproduct;

    public WarehousePK() {
    }

    public WarehousePK(int idtype, int idproduct) {
        this.idtype = idtype;
        this.idproduct = idproduct;
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtype;
        hash += (int) idproduct;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WarehousePK)) {
            return false;
        }
        WarehousePK other = (WarehousePK) object;
        if (this.idtype != other.idtype) {
            return false;
        }
        if (this.idproduct != other.idproduct) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamark.jpa.WarehousePK[ idtype=" + idtype + ", idproduct=" + idproduct + " ]";
    }
    
}
