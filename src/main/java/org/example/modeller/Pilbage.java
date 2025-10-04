package org.example.modeller;

public class Pilbage  extends  Vapen {
    public Pilbage(String vapenNamn, int skada) {
        super(vapenNamn, skada);
    }

    @Override
    public void attack ()  {
        System.out.println("Du skjuter en pil med " + vapenNamn + " och gör " + skada + " skada!");
    }
}
