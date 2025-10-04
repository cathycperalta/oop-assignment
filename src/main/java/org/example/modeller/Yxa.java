package org.example.modeller;

public class Yxa extends Vapen {

    public Yxa(String vapenNamn, int skada) {
        super(vapenNamn, skada);
    }

    @Override
    public void attack () {
        System.out.println("Du hugger med " + vapenNamn + " och gör " + skada + " skada!");
    }
}

