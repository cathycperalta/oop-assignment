package org.example.modeller;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Bot  extends Spelare{

    //lista som innehåller alla bottar
    private static final List<Bot> allaBottar = new ArrayList<Bot>();

    // Random generator
    private static final Random random = new Random();

    private String valdZon;

    //Konstruktor
    public Bot(String namn, Vapen vapen) {
        super(namn, 1_000_000, vapen);
    }

    //skapar bottar
    public static void skapaBottar() {
        if (allaBottar.isEmpty()) {
            allaBottar.add(new Bot ("Björn", null));
            allaBottar.add(new Bot("Jalling",  null));
            allaBottar.add(new Bot("Isadora",  null));
            allaBottar.add(new Bot("Alexa",  null));
        }
    }

    //Hämtar alla bottar
    public static List<Bot> getAllaBottar() {
        skapaBottar();
        return allaBottar;
    }

    //Hämtar slumpmässig bot
    public static Bot slumpaBot() {
        skapaBottar();
        return allaBottar.get(random.nextInt(allaBottar.size()));
    }

    //Bottens slumpmässiga val
    public void botVal(List<Vapen> vapenLista, List<String> zoner) {

        //Slumpa ett vapen
        int vapenVal = random.nextInt(vapenLista.size());
        setVapen(vapenLista.get(random.nextInt(vapenLista.size())));
        valdZon = zoner.get(random.nextInt(zoner.size()));
        //Inget skrivs ut i konsollen, alla bottar spelar tyst.
    }

    public String getValdZon() {
        return valdZon;
    }

        //Slumpa en zon
        @Override
    public void elimineras(String orsak) {
        super.elimineras(orsak);
        }
    }


