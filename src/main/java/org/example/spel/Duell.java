package org.example.spel;

import org.example.modeller.*;

import java.util.Random;

public class Duell {

    private final Anvandare spelare;
    private final Bot bot;
    private final Random random = new Random();

    public Duell(Anvandare spelare, Bot bot) {
        this.spelare = spelare;
        this.bot = bot;
    }

    public void starta() {
        if (bot == null || !bot.isLevande()) {
            System.out.println("Ingen levande motståndare att duellera mot.");
            return;
        }

        System.out.println("\nDu blir attackerad av " + bot.getAnvNamn() + "!");
        System.out.println("Båda gör sig redo för strid...");
        try {
            for (int i = 3; i > 0; i--) {
                System.out.println(i + "...");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        boolean spelareVinner = random.nextBoolean(); // 50% chans
        if (spelareVinner) {
            System.out.println("Du vann duellen mot " + bot.getAnvNamn() + "!");
            bot.elimineras("Besegrades i duell");
            // Level upp endast vid stridsvinst
            spelare.level++;
            spelare.setKapital(spelare.getKapital() + 1000000);
            System.out.println("Grattis! Du har levlat upp till level " + spelare.level + "!");
        } else {
            System.out.println("Du förlorade duellen mot " + bot.getAnvNamn() + "!");
            spelare.elimineras("Besegrades i duell");
            bot.setKapital(bot.getKapital() + 1000000);
        }
    }
}