package org.example.spel;

import org.example.modeller.*;
import org.example.utils.ClearConsole;
import java.util.*;

public class SpelRunda {


    private final Scanner scanner;
    private final Spelare spelare;
    private final Random random = new Random();

    public SpelRunda(Scanner scanner, Spelare spelare) {
        this.scanner = scanner;
        this.spelare = spelare;
    }

    public void startaRunda() {
        boolean spela = true;

        while (spela) {
            System.out.println("\n=== Spelmeny ===");
            System.out.println("[1] Spring till vapengömman");
            System.out.println("[2] Göm dig i en zon");
            System.out.println("[3] Avsluta spelet");

            String val = scanner.next();
            switch (val) {
                case "1":
                    System.out.println("Du springer till vapengömman...");

                    List<Vapen> vapenLista = new ArrayList<>();
                    vapenLista.add(new Yxa("Yxa", 10));
                    vapenLista.add(new Svard("Svärd", 12));
                    vapenLista.add(new Hammare("Hammare", 13));
                    vapenLista.add(new Pilbage("Pilbåge", 9));
                    vapenLista.add(new Spjut("Spjut", 14));

                    System.out.println("Tillgängliga vapen: ");
                    for (int i = 0; i < vapenLista.size(); i++) {
                        System.out.print("\n[" + (i + 1) + "] " + vapenLista.get(i));
                    }

                    System.out.println("Välj ett vapen: ");
                    int valVapen = Integer.parseInt(scanner.next());
                    Vapen valtVapen = vapenLista.get(valVapen - 1);
                    spelare.setVapen(valtVapen);


                    System.out.println("Du valde: " + valtVapen.getNamn());
                    ClearConsole.clearConsole();

                    Duell duell = new Duell(spelare);
                    duell.starta();
                    break;

                case "2":

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
                                System.out.println("Du gömmer dig i Skandinaviska skogen i norr!");
                                break;
                            case "2":
                                System.out.println("Du gömmer dig i Djungeln i söder!");
                                break;
                            case "3":
                                System.out.println("Du gömmer dig i Ådalen i öster!");
                                break;
                            case "4":
                                System.out.println("Du gömmer dig i Bergen i väster!");
                                break;
                            case "5":
                                zon = false;
                                spela = false;
                                break;
                            default:
                                System.out.println("Ogiltigt val.");
                        }
                    }
                    break;
                case "3":
                    spela = false;
                    break;
                default:
                    System.out.println("Ogiltigt val.");
            }
        }
    }
}