package org.example.modeller;

public class Svard extends Vapen {

    public Svard(String vapenNamn, int skada) {
        super(vapenNamn, skada);
    }

    @Override
    public void attack() {
        System.out.println("Du svingar ditt " + vapenNamn + "!");
    }
}