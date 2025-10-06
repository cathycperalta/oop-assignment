package org.example.modeller;

public class Spjut extends Vapen {

    public Spjut(String vapenNamn, int skada) {
        super(vapenNamn, skada);
    }

    @Override
    public void attack() {
        System.out.println("Du kastar ditt " + vapenNamn + "!");
    }
}