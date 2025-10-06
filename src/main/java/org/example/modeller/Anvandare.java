package org.example.modeller;

public class Anvandare extends Spelare {
    public int level;
    private int kapital;

    public Anvandare(String anvNamn, Vapen vapen) {
        super(anvNamn);
        this.vapen = vapen;
        this.level = 0; // Startar på level 0
        this.kapital = 1_000_000; // Startkapital
    }

    public int getKapital() {
        return kapital;
    }

    public void okaVinstPott(int belopp) {
        kapital += belopp;
    }

    // Metod för att öka level
    public void levlaUpp() {
        this.level++;
        System.out.println("Grattis! Du har levlat upp till level " + this.level + "!");
    }
}