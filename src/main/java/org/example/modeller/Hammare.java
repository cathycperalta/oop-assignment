package org.example.modeller;

public class Hammare extends Vapen{
    public Hammare(String vapenNamn, int skada) {
        super(vapenNamn, skada);
    }



    @Override
    public void attack () {
        System.out.println("Du krossar fiende med " + vapenNamn + "du gör " + skada + " skada!" );
    }
}
