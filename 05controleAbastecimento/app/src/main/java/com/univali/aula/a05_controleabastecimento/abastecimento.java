package com.univali.aula.a05_controleabastecimento;

import java.io.Serializable;

public class abastecimento implements Serializable {
    private String data;
    private String posto;
    private double litro;
    private double km;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public double getLitro() {
        return litro;
    }

    public void setLitro(double litro) {
        this.litro = litro;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }
}
