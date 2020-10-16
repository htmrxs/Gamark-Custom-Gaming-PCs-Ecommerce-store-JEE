/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamark.mb;

import com.gamark.ejb.FeaturedFacade;
import com.gamark.jpa.Featured;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Maraoui
 */
@Named(value = "featured")
@SessionScoped
public class FeaturedMB implements Serializable {

    @EJB
    private FeaturedFacade featuredEJB;
    
    /**
     * Creates a new instance of CpuMB
     */
    public FeaturedMB() {
    }
    
    public List<Featured> getFeatureds() {
        return featuredEJB.findAll();
    }
    
}
