package org.example.modeller;

public class Pilbage extends Vapen {

    public Pilbage(String vapenNamn, int skada) {
        super(vapenNamn, skada);
    }

    @Override
    public void attack() {
        System.out.println("Du skjuter med din " + vapenNamn + "!");
    }
}