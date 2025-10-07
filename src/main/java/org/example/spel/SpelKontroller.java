package org.example.spel;

import org.example.modeller.Anvandare;
import org.example.utils.ClearConsole;

import java.util.Scanner;

public class SpelKontroller {
    public final Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean körSpelet = true;

        while (körSpelet) {
            Welcome start = new Welcome();
            start.visaRegler();
            System.out.println("\n=== Huvudmeny ===\n[1] Starta spel\n[2] Avsluta spel \n[3] Återgå till spel regler.");

            String huvudmenyval = scanner.next();

            switch (huvudmenyval) {
                case "1":
                    startaSpel();
                    break;
                case "2":
                    System.out.println("Tack för att du spelade!");
                    körSpelet = false;
                    break;
                case "3":
                    start.visaRegler();
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen!");
                    break;
            }
        }
    }

    private void startaSpel() {
        System.out.println("\n Ange ditt alias: ");
        String alias = scanner.next();
        Anvandare spelare = new Anvandare(alias, null);
        System.out.println("Välkommen " + spelare.getAnvNamn() + "!");

        ClearConsole.clearConsole();

        SpelRunda spelRunda = new SpelRunda(scanner, spelare);
        spelRunda.startaRunda();

        if (!spelare.isLevande()) {
            hanteraSpelarDöd();
        }
    }

    private void hanteraSpelarDöd() {
        boolean giltigtVal = false;
        while (!giltigtVal) {
            System.out.println("\nDu har dött! Vad vill du göra?");
            System.out.println("[1] Spela igen");
            System.out.println("[2] Avsluta spel");

            String val = scanner.next();

            switch (val) {
                case "1":
                    giltigtVal = true;
                    start();
                    break;
                case "2":
                    giltigtVal = true;
                    System.out.println("Spelet avslutas. Tack för att du spelade!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }
}