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
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author Maraoui
 */
@Entity
@Table(name = "MOTHERBOARD")
@NamedQueries({
    @NamedQuery(name = "Motherboard.findAll", query = "SELECT m FROM Motherboard m"),
    @NamedQuery(name = "Motherboard.findById", query = "SELECT m FROM Motherboard m WHERE m.id = :id"),
    @NamedQuery(name = "Motherboard.findByBrandASC", query = "SELECT c FROM Motherboard c WHERE c.brand = :brand AND UPPER(c.name) LIKE UPPER(:search) ORDER BY c.price ASC"),
    @NamedQuery(name = "Motherboard.findByBrandDESC", query = "SELECT c FROM Motherboard c WHERE c.brand = :brand AND UPPER(c.name) LIKE UPPER(:search) ORDER BY c.price DESC"),
    @NamedQuery(name = "Motherboard.findByBrand", query = "SELECT m FROM Motherboard m WHERE m.brand = :brand"),
    @NamedQuery(name = "Motherboard.findBySize", query = "SELECT m FROM Motherboard m WHERE m.size = :size"),
    @NamedQuery(name = "Motherboard.findByName", query = "SELECT m FROM Motherboard m WHERE m.name = :name"),
    @NamedQuery(name = "Motherboard.findByDescription", query = "SELECT m FROM Motherboard m WHERE m.description = :description"),
    @NamedQuery(name = "Motherboard.findByPrice", query = "SELECT m FROM Motherboard m WHERE m.price = :price")})
public class Motherboard implements Serializable {

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
    @Column(name = "SIZE")
    private String size;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private Integer price;

    public Motherboard() {
    }

    public Motherboard(Integer id) {
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
        if (!(object instanceof Motherboard)) {
            return false;
        }
        Motherboard other = (Motherboard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamark.jpa.Motherboard[ id=" + id + " ]";
    }
    
}
