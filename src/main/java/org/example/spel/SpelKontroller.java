package org.example.spel;

import org.example.modeller.Spelare;
import org.example.utils.ClearConsole;
import java.util.Scanner;


public class SpelKontroller {
    public final Scanner scanner = new Scanner(System.in);


    public void start() {
        boolean körSpelet = true;

        while(körSpelet) {
            Welcome start = new Welcome();
            start.visaRegler();
            System.out.println("\n=== Huvudmeny ===\n[1] Starta spel\n[2] Avsluta spel \n[3] Återgå till spel regler.");
            Scanner scanner = new Scanner(System.in);
            String huvudmenyval = scanner.next();

            switch (huvudmenyval) {
                case "1": startaSpel();
                case "2": {
                    System.out.println("Tack för att du spelade!");
                    körSpelet = false;
                }
                case "3": start.visaRegler();
                default:
                    System.out.println("Ogiltigt val, försök igen!");
            }
        }
    }
  private void startaSpel() {
      System.out.println("\n Ange ditt alias: ");
      String alias = scanner.next();

      Spelare spelare = new Spelare(alias);
      System.out.println("Välkommen " + spelare.getAnvNamn() + "!");

      ClearConsole.clearConsole();

      SpelRunda spelRunda = new  Spelrunda(scanner, spelare);
      spelRunda.startRunda();
  }
}
