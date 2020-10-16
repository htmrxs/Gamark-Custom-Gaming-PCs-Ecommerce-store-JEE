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
import javax.validation.constraints.Size;

/**
 *
 * @author Maraoui
 */
@Entity
@Table(name = "GPU")
@NamedQueries({
    @NamedQuery(name = "Gpu.findAll", query = "SELECT g FROM Gpu g"),
    @NamedQuery(name = "Gpu.findById", query = "SELECT g FROM Gpu g WHERE g.id = :id"),
    @NamedQuery(name = "Gpu.findByBrandASC", query = "SELECT c FROM Gpu c WHERE c.brand = :brand AND UPPER(c.name) LIKE UPPER(:search) ORDER BY c.price ASC"),
    @NamedQuery(name = "Gpu.findByBrandDESC", query = "SELECT c FROM Gpu c WHERE c.brand = :brand AND UPPER(c.name) LIKE UPPER(:search) ORDER BY c.price DESC"),
    @NamedQuery(name = "Gpu.findByBrand", query = "SELECT g FROM Gpu g WHERE g.brand = :brand"),
    @NamedQuery(name = "Gpu.findByGen", query = "SELECT g FROM Gpu g WHERE g.gen = :gen"),
    @NamedQuery(name = "Gpu.findByName", query = "SELECT g FROM Gpu g WHERE g.name = :name"),
    @NamedQuery(name = "Gpu.findByDescription", query = "SELECT g FROM Gpu g WHERE g.description = :description"),
    @NamedQuery(name = "Gpu.findByPrice", query = "SELECT g FROM Gpu g WHERE g.price = :price")})
public class Gpu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "BRAND")
    private String brand;
    @Size(max = 50)
    @Column(name = "GEN")
    private String gen;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private Integer price;

    public Gpu() {
    }

    public Gpu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Gpu)) {
            return false;
        }
        Gpu other = (Gpu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamark.jpa.Gpu[ id=" + id + " ]";
    }
    
}
