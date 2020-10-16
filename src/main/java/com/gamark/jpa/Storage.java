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
@Table(name = "STORAGE")
@NamedQueries({
    @NamedQuery(name = "Storage.findAll", query = "SELECT s FROM Storage s"),
    @NamedQuery(name = "Storage.findById", query = "SELECT s FROM Storage s WHERE s.id = :id"),
    @NamedQuery(name = "Storage.findByTypeASC", query = "SELECT c FROM Storage c WHERE c.type = :type AND UPPER(c.name) LIKE UPPER(:search) ORDER BY c.price ASC"),
    @NamedQuery(name = "Storage.findByTypeDESC", query = "SELECT c FROM Storage c WHERE c.type = :type AND UPPER(c.name) LIKE UPPER(:search) ORDER BY c.price DESC"),
    @NamedQuery(name = "Storage.findByType", query = "SELECT s FROM Storage s WHERE s.type = :type"),
    @NamedQuery(name = "Storage.findByCapacity", query = "SELECT s FROM Storage s WHERE s.capacity = :capacity"),
    @NamedQuery(name = "Storage.findByName", query = "SELECT s FROM Storage s WHERE s.name = :name"),
    @NamedQuery(name = "Storage.findByDescription", query = "SELECT s FROM Storage s WHERE s.description = :description"),
    @NamedQuery(name = "Storage.findByPrice", query = "SELECT s FROM Storage s WHERE s.price = :price")})
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 50)
    @Column(name = "CAPACITY")
    private String capacity;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private Integer price;

    public Storage() {
    }

    public Storage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
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
        if (!(object instanceof Storage)) {
            return false;
        }
        Storage other = (Storage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamark.jpa.Storage[ id=" + id + " ]";
    }
    
}
