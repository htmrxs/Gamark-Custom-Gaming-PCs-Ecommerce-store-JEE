package com.gamark.mb;

import com.gamark.ejb.StorageFacade;
import com.gamark.jpa.Storage;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "storage")
@SessionScoped
public class StorageMB implements Serializable {

    private String type="HDD";
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
    
    public void setType(String type)
    {
        this.type=type;
    }
    
    public String getType()
    {
        return type;
    }
    
    @EJB
    private StorageFacade storageEJB;
    
    public StorageMB() {
    }
    
    public List<Storage> getByType()
    {
        return storageEJB.findByType(type,ord,search);
    }
}
