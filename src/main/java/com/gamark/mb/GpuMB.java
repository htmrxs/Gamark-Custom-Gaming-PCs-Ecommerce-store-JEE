package com.gamark.mb;

import com.gamark.ejb.GpuFacade;
import com.gamark.jpa.Gpu;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "gpu")
@SessionScoped
public class GpuMB implements Serializable {

    private String brand="Nvidia";
    private String search="%%";
    private String ord="Asc";

    public String getOrd() {
        return ord;
    }

    public void setOrd(String ord) {
        this.ord = ord;
    }

    public String getSearch() {
        return search.substring(1, search.length()-1);
    }

    public void setSearch(String search) {
        search = search.replaceAll("[^a-zA-Z0-9\\s\\-]", "");
        this.search = "%"+search+"%";
    }
    
    public void setBrand(String brand)
    {
        this.brand=brand;
    }
    
    public String getBrand()
    {
        return brand;
    }
    
    @EJB
    private GpuFacade gpuEJB;
    
    public GpuMB() {
    }
    
    public List<Gpu> getByBrand()
    {
        return gpuEJB.findByBrand(brand,ord,search);
    }
}
