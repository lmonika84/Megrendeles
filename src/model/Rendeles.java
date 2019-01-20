/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author monika.lohr
 */
public class Rendeles implements Serializable{
    int id;
    int rendeloId;
    int osszeg;
    int darabszam;
    boolean teljesitve;

    public Rendeles() {
    }

    public Rendeles(int id, int rendeloId, int osszeg, int darabszam, boolean teljesitve) {
        this.id = id;
        this.rendeloId = rendeloId;
        this.osszeg = osszeg;
        this.darabszam = darabszam;
        this.teljesitve = teljesitve;
    }

    public Rendeles(int rendeloId, int osszeg, int darabszam, boolean teljesitve) {
        this.rendeloId = rendeloId;
        this.osszeg = osszeg;
        this.darabszam = darabszam;
        this.teljesitve = teljesitve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRendeloId() {
        return rendeloId;
    }

    public void setRendeloId(int rendeloId) {
        this.rendeloId = rendeloId;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public int getDarabszam() {
        return darabszam;
    }

    public void setDarabszam(int darabszam) {
        this.darabszam = darabszam;
    }

    public boolean isTeljesitve() {
        return teljesitve;
    }

    public void setTeljesitve(boolean teljesitve) {
        this.teljesitve = teljesitve;
    }
    
    
    
    
    
}
