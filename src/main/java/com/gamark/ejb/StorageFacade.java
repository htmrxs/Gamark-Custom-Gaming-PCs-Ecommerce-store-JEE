/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamark.ejb;

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
public class StorageFacade extends AbstractFacade<Storage> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StorageFacade() {
        super(Storage.class);
    }
    
    public List<Storage> findByType(String type,String ord,String search) {
        if(ord.equals("Asc"))
        {return em.createNamedQuery("Storage.findByTypeASC")
        .setParameter("type", type)
        .setParameter("search", search)
        .getResultList();
        }
        return em.createNamedQuery("Storage.findByTypeDESC")
        .setParameter("type", type)
        .setParameter("search", search)
        .getResultList(); 
    } 
    
}
