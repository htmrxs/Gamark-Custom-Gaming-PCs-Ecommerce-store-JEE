package com.gamark;

import com.gamark.jpa.Chassis;
import com.gamark.jpa.Cpu;
import com.gamark.jpa.Gpu;
import com.gamark.jpa.Motherboard;
import com.gamark.jpa.Psu;
import com.gamark.jpa.Ram;
import com.gamark.jpa.Storage;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "build")
@ApplicationScoped  
public class Build implements Serializable{

    private Motherboard motherboard;
    private Cpu cpu;
    private Gpu gpu;
    private Ram ram;
    private Psu psu;
    private Storage storage;
    private Chassis chassis;
    
    private int price;
    
    private boolean done=false;

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Gpu getGpu() {
        return gpu;
    }

    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Psu getPsu() {
        return psu;
    }

    public void setPsu(Psu psu) {
        this.psu = psu;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.done=true;
        this.chassis = chassis;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getPrice() {
        return motherboard.getPrice()+cpu.getPrice()+gpu.getPrice()+ram.getPrice()+psu.getPrice()+storage.getPrice()+chassis.getPrice();
    }    
    
    public void clearAll()
    {
        motherboard=null;
        cpu=null;
        gpu=null;
        ram=null;
        psu=null;
        storage=null;
        chassis=null;
        
        done=false;
    }
    
}
