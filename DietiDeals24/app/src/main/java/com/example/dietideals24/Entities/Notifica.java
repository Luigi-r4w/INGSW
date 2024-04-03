package com.example.dietideals24.Entities;

import java.io.Serializable;

public class Notifica implements Serializable {
    private String venditore;
    private String compratore;
    private Integer asta;

    public String getVenditore() {
        return venditore;
    }

    public void setVenditore(String venditore) {
        this.venditore = venditore;
    }

    public String getCompratore() {
        return compratore;
    }

    public void setCompratore(String compratore) {
        this.compratore = compratore;
    }

    public Integer getAsta() {
        return asta;
    }

    public void setAsta(Integer asta) {
        this.asta = asta;
    }
}