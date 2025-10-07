package org.example.modeller;

import java.util.ArrayList;
import java.util.List;

public class Bot extends Spelare {

    private static final List<Bot> allaBottar = new ArrayList<>();

    public Bot(String namn, Vapen vapen) {
        super(namn);
        this.vapen = vapen;
        allaBottar.add(this);
    }

    public static List<Bot> getAllaBottar() {
        if (allaBottar.isEmpty()) {
            // Skapa botarna med exakt namn
            new Bot("Björn", null);
            new Bot("Jalling", null);
 /*           new Bot("Isadora", null);
            new Bot("Alexa", null);*/
        }
        return allaBottar;
    }

    @Override
    public void elimineras(String orsak) {
        this.levande = false;
        System.out.println(anvNamn + " är eliminerad (" + orsak + ")");
    }
}
