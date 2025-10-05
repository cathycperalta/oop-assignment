package org.example.spel;
import org.example.modeller.*;

import java.util.List;
import java.util.Random;


public class Duell {
    private final Spelare spelare;
    private final Random random = new Random();

    public Duell(Spelare spelare) {
        this.spelare = spelare;
    }

    public void starta() {
        //skapa en slumpmässig bot
        Bot motstandare = Bot.slumpaBot();

        //Botten väljer nu sitt vapen och gömställe slumpmässigt
        motstandare.botVal(
                List.of(
                        new Yxa("Yxa", 10),
                        new Yxa("Svärd", 12),
                        new Yxa("Hammare", 13),
                        new Yxa("Pilbåge", 9),
                        new Yxa("Spjut", 14)

                ),
        List.of("Skandinaviska skogen", "Djungeln", "Ådalen", "Bergen")
        );

        System.out.println("Du du blir attackerad av " + motstandare.getAnvNamn() + "!");
        System.out.println("Båda gör sig redo för strid...");

        try {
            Thread.sleep(1000);
            System.out.println("3...");
            Thread.sleep(1000);
            System.out.println("2...");
            Thread.sleep(1000);
            System.out.println("1...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 50% chans att vinna
        boolean spelarenVinner = random.nextBoolean();

        if (spelarenVinner) {
            System.out.println("Du vann duellen mot " + motstandare.getAnvNamn() + "!");
            motstandare.elimineras("Besegrades i duell");
                    spelare.okaVinstPott(1_000_000); // öka spelarens pott
        }
        else{
            System.out.println("Du förlorade duellen mot " +  motstandare.getAnvNamn() + "!");
            spelare.elimineras("Besegrades i duell");
        }

    }
}
