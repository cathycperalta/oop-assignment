package org.example.modeller;

public abstract class Vapen {
    protected String vapenNamn;
    protected int skada;

    public Vapen(String vapenNamn, int skada) {
        this.vapenNamn = vapenNamn;
        this.skada = skada;
    }

    public String getVapenNamn() {
        return vapenNamn;
    }

    public int getSkada() {
        return skada;
    }

    public abstract void attack();
}