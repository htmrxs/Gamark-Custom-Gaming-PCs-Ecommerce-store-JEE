package com.gamark.mb;

import com.gamark.ejb.MotherboardFacade;
import com.gamark.jpa.Motherboard;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "motherboard")
@SessionScoped
public class MotherboardMB implements Serializable {

    private String brand="Asus";
    private String search="%%";
    private String ord="Asc";
    private String selected="";

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
    
    

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
    private MotherboardFacade motherboardEJB;
    
    public MotherboardMB() {
    }
   
    public List<Motherboard> getByBrand()
    {
        return motherboardEJB.findByBrand(brand,ord,search);
    }
}
