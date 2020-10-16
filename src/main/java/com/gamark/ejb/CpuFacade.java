package com.gamark.ejb;

import com.gamark.jpa.Cpu;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CpuFacade extends AbstractFacade<Cpu> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CpuFacade() {
        super(Cpu.class);
    } 

    public List<Cpu> findByBrand(String brand,String ord,String search) {
        if(ord.equals("Asc"))
        {return em.createNamedQuery("Cpu.findByBrandASC")
        .setParameter("brand", brand)
        .setParameter("search", search)
        .getResultList();
        }
        return em.createNamedQuery("Cpu.findByBrandDESC")
        .setParameter("brand", brand)
        .setParameter("search", search)
        .getResultList(); 
    }        
}
