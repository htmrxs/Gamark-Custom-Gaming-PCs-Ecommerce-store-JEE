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

@Entity
@Table(name = "CPU")
@NamedQueries({
    @NamedQuery(name = "Cpu.findAll", query = "SELECT c FROM Cpu c"),
    @NamedQuery(name = "Cpu.findById", query = "SELECT c FROM Cpu c WHERE c.id = :id"),
    @NamedQuery(name = "Cpu.findByBrandASC", query = "SELECT c FROM Cpu c WHERE c.brand = :brand AND UPPER(c.name) LIKE UPPER(:search) ORDER BY c.price ASC"),
    @NamedQuery(name = "Cpu.findByBrandDESC", query = "SELECT c FROM Cpu c WHERE c.brand = :brand AND UPPER(c.name) LIKE UPPER(:search) ORDER BY c.price DESC"),
    @NamedQuery(name = "Cpu.findByGen", query = "SELECT c FROM Cpu c WHERE c.gen = :gen"),
    @NamedQuery(name = "Cpu.findByName", query = "SELECT c FROM Cpu c WHERE c.name = :name"),
    @NamedQuery(name = "Cpu.findByDescription", query = "SELECT c FROM Cpu c WHERE c.description = :description"),
    @NamedQuery(name = "Cpu.findByPrice", query = "SELECT c FROM Cpu c WHERE c.price = :price")})
public class Cpu implements Serializable {

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

    public Cpu() {
    }

    public Cpu(Integer id) {
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
        if (!(object instanceof Cpu)) {
            return false;
        }
        Cpu other = (Cpu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamark.jpa.Cpu[ id=" + id + " ]";
    }
    
}
