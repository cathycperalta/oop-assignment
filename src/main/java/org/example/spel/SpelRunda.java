package org.example.spel;

import org.example.modeller.*;

import java.util.*;

public class SpelRunda {

    private final Scanner scanner;
    private final Anvandare anvandare;
    private final Random random = new Random();

    private List<Bot> bottar;
    private final List<String> zoner = List.of("Skandinaviska skogen", "Djungeln", "Ådalen", "Bergen");
    private Map<Spelare, String> placeringar;

    public SpelRunda(Scanner scanner, Anvandare anvandare) {
        this.scanner = scanner;
        this.anvandare = anvandare;
        resetSpel();
    }

    private void resetSpel() {
        bottar = Bot.getAllaBottar();
        placeringar = new HashMap<>();

        if (anvandare != null) {
            anvandare.setVapen(null);
            anvandare.setLevande(true);
            anvandare.level = 0;
            placeringar.put(anvandare, "");
        }

        for (Bot bot : bottar) {
            String botZon = zoner.get(random.nextInt(zoner.size()));
            placeringar.put(bot, botZon);
            bot.setLevande(true);
        }
    }

    public void startaRunda() {
        boolean spela = true;

        while (spela && anvandare.isLevande()) {
            System.out.println("\n=== Spelmeny ===");
            System.out.println("[1] Spring till vapengömman");
            System.out.println("[2] Göm dig i en zon");
            System.out.println("[3] Avsluta spelet");

            String val = scanner.next();

            switch (val) {
                case "1":
                    case1();
                    break;
                case "2":
                    spela = case2();
                    break;
                case "3":
                    spela = false;
                    break;
                default:
                    System.out.println("Ogiltigt val.");
            }

            // Naturkatastrof sker varje runda
            naturkatastrofRunda();

            // Kolla om någon har vunnit eller förlorat
            if (kontrolleraEventuelltVinstEllerForlust()) return;
        }
    }

    private void case1() {
        System.out.println("Du springer till vapengömman...");

        List<Vapen> vapenLista = List.of(
                new Yxa("Yxa", 10),
                new Svard("Svärd", 12),
                new Hammare("Hammare", 13),
                new Pilbage("Pilbåge", 9),
                new Spjut("Spjut", 14)
        );

        System.out.println("Tillgängliga vapen: ");
        for (int i = 0; i < vapenLista.size(); i++) {
            System.out.print("\n[" + (i + 1) + "] " + vapenLista.get(i).getVapenNamn());
        }

        System.out.println("\nVälj ett vapen: ");
        int valVapen = Integer.parseInt(scanner.next());
        Vapen valtVapen = vapenLista.get(valVapen - 1);
        anvandare.setVapen(valtVapen);

        System.out.println("Du valde: " + valtVapen.getVapenNamn());

        // Slumpa en levande bot för duellen
        Bot slumpadBot = bottar.get(random.nextInt(bottar.size()));
        while (!slumpadBot.isLevande()) {
            slumpadBot = bottar.get(random.nextInt(bottar.size()));
        }

        // Starta duellen
        Duell duell = new Duell(anvandare, slumpadBot);
        duell.starta();
    }

    private boolean case2() {
        boolean zon = true;
        while (zon) {
            System.out.println("Välj ett av de 4 zonerna som du vill gömma dig i: ");
            System.out.println("[1] Skandinaviska skogen i norr");
            System.out.println("[2] Djungeln i söder");
            System.out.println("[3] Ådalen i öster");
            System.out.println("[4] Bergen i väster");
            System.out.println("[5] Avsluta spel");

            String zonVal = scanner.next();

            switch (zonVal) {
                case "1":
                    placeringar.put(anvandare, zoner.get(0));
                    System.out.println("Du gömmer dig i Skandinaviska skogen i norr!");
                    zon = false;
                    break;
                case "2":
                    placeringar.put(anvandare, zoner.get(1));
                    System.out.println("Du gömmer dig i Djungeln i söder!");
                    zon = false;
                    break;
                case "3":
                    placeringar.put(anvandare, zoner.get(2));
                    System.out.println("Du gömmer dig i Ådalen i öster!");
                    zon = false;
                    break;
                case "4":
                    placeringar.put(anvandare, zoner.get(3));
                    System.out.println("Du gömmer dig i Bergen i väster!");
                    zon = false;
                    break;
                case "5":
                    return false;
                default:
                    System.out.println("Ogiltigt val.");
            }
        }
        return true;
    }

    private void naturkatastrofRunda() {
        String drabbadZon = zoner.get(random.nextInt(zoner.size()));
        System.out.println("En naturkatastrof har drabbat " + drabbadZon + "!");

        if (random.nextDouble() < 0.25) { // 25% chans att någon dör
            List<Spelare> offer = new ArrayList<>();
            if (anvandare.isLevande() && drabbadZon.equals(placeringar.get(anvandare))) {
                offer.add(anvandare);
            }

            for (Bot bot : bottar) {
                if (bot.isLevande() && drabbadZon.equals(placeringar.get(bot))) {
                    offer.add(bot);
                }
            }

            if (!offer.isEmpty()) {
                Spelare vald = offer.get(random.nextInt(offer.size()));
                System.out.println(vald.getAnvNamn() + " har dött p.g.a. naturkatastrof!");
                vald.elimineras("Naturkatastrof");
            }
        }
    }

    private boolean kontrolleraEventuelltVinstEllerForlust() {
        boolean allaBottarDoda = bottar.stream().allMatch(bot -> !bot.isLevande());

        if (allaBottarDoda && anvandare.isLevande()) {
            System.out.println("\nGrattis! Du är den sista överlevande och har vunnit hela vinstpotten på " + anvandare.getKapital() + " kr!");
            boolean giltigtVal = false;
            while (!giltigtVal) {
                System.out.println("[1] Spela igen");
                System.out.println("[2] Avsluta spel");

                String valSlut = scanner.next();
                switch (valSlut) {
                    case "1":
                        giltigtVal = true;
                        resetSpel();
                        startaRunda();
                        return true;
                    case "2":
                        giltigtVal = true;
                        System.out.println("Spelet avslutas. Tack för att du spelade!");
                        System.exit(0);
                    default:
                        System.out.println("Ogiltigt val, försök igen.");
                }
            }
        }

        if (!anvandare.isLevande()) {
            System.out.println("\nDu har dött! Spelet är slut.");
            boolean giltigtVal = false;
            while (!giltigtVal) {
                System.out.println("[1] Spela igen");
                System.out.println("[2] Avsluta spel");

                String val = scanner.next();
                switch (val) {
                    case "1":
                        giltigtVal = true;
                        resetSpel();
                        startaRunda();
                        return true;
                    case "2":
                        giltigtVal = true;
                        System.out.println("Spelet avslutas. Tack för att du spelade!");
                        System.exit(0);
                    default:
                        System.out.println("Ogiltigt val, försök igen.");
                }
            }
        }

        return false;
    }
}