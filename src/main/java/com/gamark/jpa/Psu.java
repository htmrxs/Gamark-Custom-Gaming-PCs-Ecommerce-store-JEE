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
@Table(name = "PSU")
@NamedQueries({
    @NamedQuery(name = "Psu.findAll", query = "SELECT p FROM Psu p"),
    @NamedQuery(name = "Psu.findById", query = "SELECT p FROM Psu p WHERE p.id = :id"),
    @NamedQuery(name = "Psu.findByBrandASC", query = "SELECT c FROM Psu c WHERE c.brand = :brand AND UPPER(c.name) LIKE UPPER(:search) ORDER BY c.price ASC"),
    @NamedQuery(name = "Psu.findByBrandDESC", query = "SELECT c FROM Psu c WHERE c.brand = :brand AND UPPER(c.name) LIKE UPPER(:search) ORDER BY c.price DESC"),
    @NamedQuery(name = "Psu.findByBrand", query = "SELECT p FROM Psu p WHERE p.brand = :brand"),
    @NamedQuery(name = "Psu.findByWattage", query = "SELECT p FROM Psu p WHERE p.wattage = :wattage"),
    @NamedQuery(name = "Psu.findByName", query = "SELECT p FROM Psu p WHERE p.name = :name"),
    @NamedQuery(name = "Psu.findByDescription", query = "SELECT p FROM Psu p WHERE p.description = :description"),
    @NamedQuery(name = "Psu.findByPrice", query = "SELECT p FROM Psu p WHERE p.price = :price")})
public class Psu implements Serializable {

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
    @Column(name = "WATTAGE")
    private String wattage;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private Integer price;

    public Psu() {
    }

    public Psu(Integer id) {
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

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
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
        if (!(object instanceof Psu)) {
            return false;
        }
        Psu other = (Psu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamark.jpa.Psu[ id=" + id + " ]";
    }
    
}
