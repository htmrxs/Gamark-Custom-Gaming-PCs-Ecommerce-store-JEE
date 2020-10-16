/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamark.ejb;

import com.gamark.jpa.Psu;
import com.gamark.jpa.Storage;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maraoui
 */
@Stateless
public class PsuFacade extends AbstractFacade<Psu> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PsuFacade() {
        super(Psu.class);
    }
    
    public List<Psu> findByBrand(String brand,String ord,String search) {
        if(ord.equals("Asc"))
        {return em.createNamedQuery("Psu.findByBrandASC")
        .setParameter("brand", brand)
        .setParameter("search", search)
        .getResultList();
        }
        return em.createNamedQuery("Psu.findByBrandDESC")
        .setParameter("brand", brand)
        .setParameter("search", search)
        .getResultList(); 
    } 
    
}
