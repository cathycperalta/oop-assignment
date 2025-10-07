package org.example.modeller;

public class Anvandare extends Spelare {
    public int level;

    public Anvandare(String anvNamn, Vapen vapen) {
        super(anvNamn);
        this.vapen = vapen;
        this.level = 1; // Startar på level 0
    }

    public int getKapital() {
        return kapital;
    }

    public void setKapital(int kapital) {
        this.kapital = kapital;
    }
}