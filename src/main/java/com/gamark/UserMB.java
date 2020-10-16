package com.gamark;

import com.gamark.ejb.AddressFacade;
import com.gamark.ejb.UsrFacade;
import com.gamark.jpa.Address;
import com.gamark.jpa.Usr;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "usr")
@SessionScoped
public class UserMB implements Serializable
{
    private String email;
    private String username;
    private String password;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    @EJB 
    UsrFacade usrFacade;
    
    @EJB
    AddressFacade addressFacade;
    
    public UserMB(){}
    
    public void createUser(String email,String username,String password, String Address)
    {
        Usr usr=new Usr();
        usr.setEmail(email);
        usr.setUsername(username);
        usr.setPassword(password);
        Address address=new Address();
        address.setCountry("Morocco");
        address.setStreet(Address);
        addressFacade.create(address);
        usr.setIdaddress(address.getId());
        usrFacade.create(usr);
    }
    
    public void updateUser(Usr usr,String email,String username,String password, String Address)
    {   
        usr.setEmail(email);
        usr.setUsername(username);
        usr.setPassword(password);
        if(addressFacade.find(usr.getIdaddress()).getStreet().equals(Address))
        {
            Address address=new Address();
            address.setCountry("Morocco");
            address.setStreet(Address);
            addressFacade.create(address);
            usr.setIdaddress(address.getId()); 
        }
        usrFacade.edit(usr);
    }
    
    public boolean login(String username, String password)
    {
        List<Usr> usrs=usrFacade.findAll();
        for(Usr usr:usrs)
        {
            if(usr.getUsername().equals(username) && usr.getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }
}
