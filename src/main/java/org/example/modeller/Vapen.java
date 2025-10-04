package org.example.modeller;

public abstract class Vapen {
    protected String vapenNamn;
    protected int skada;

    public Vapen(String vapenNamn, int skada) {
        this.vapenNamn = vapenNamn;
        this.skada = skada;

    }
    public abstract void attack();

    @Override
    public String toString() {
        return vapenNamn + " ";
    }
}

