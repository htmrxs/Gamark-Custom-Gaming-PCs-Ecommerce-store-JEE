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
@Table(name = "USR")
@NamedQueries({
    @NamedQuery(name = "Usr.findAll", query = "SELECT u FROM Usr u"),
    @NamedQuery(name = "Usr.findById", query = "SELECT u FROM Usr u WHERE u.id = :id"),
    @NamedQuery(name = "Usr.findByEmail", query = "SELECT u FROM Usr u WHERE u.email = :email"),
    @NamedQuery(name = "Usr.findByUsername", query = "SELECT u FROM Usr u WHERE u.username = :username"),
    @NamedQuery(name = "Usr.findByPassword", query = "SELECT u FROM Usr u WHERE u.password = :password"),
    @NamedQuery(name = "Usr.findByIdaddress", query = "SELECT u FROM Usr u WHERE u.idaddress = :idaddress")})
public class Usr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 100)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "IDADDRESS")
    private Integer idaddress;

    public Usr() {
    }

    public Usr(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(Integer idaddress) {
        this.idaddress = idaddress;
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
        if (!(object instanceof Usr)) {
            return false;
        }
        Usr other = (Usr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamark.jpa.Usr[ id=" + id + " ]";
    }
    
}
