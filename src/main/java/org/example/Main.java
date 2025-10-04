package org.example;

import org.example.modeller.*;
import org.example.spel.Welcome;
 import org.example.modeller.Vapen;
import org.example.utils.ClearConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
/*public static void startaSpel(Scanner scanner) {
    System.out.println("Spelet startar!");
    System.out.println("Vänligen skriv in din spelares alias: ");
    String alias = scanner.next();              // använder scanner som skickas in
    Spelare spelare = new Spelare(alias);       // skapar spelare
    System.out.println("Välkommen " + spelare.getName() + "!");
    System.out.println("Alla spelare är redo. Bered dig på strid!");
    System.out.println("3");
    System.out.println("2");
    System.out.println("1");
    ClearConsole.clearConsole();                // rensar konsolen
}

 */

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
       /* System.out.println("Hello World");
        Scanner scanner = new Scanner(System.in);
        Welcome start = new Welcome();
        start.visaRegler();
         System.out.println("Spelet startar!");
         System.out.println("Vänligen skriv in din spelares alias: ");
         String alias = scanner.next();              // använder scanner som skickas in
         Spelare spelare = new Spelare(alias);       // skapar spelare
         System.out.println("Välkommen " + spelare.getName() + "!");
         System.out.println("Alla spelare är redo. Bered dig på strid!");
         System.out.println("3");
         System.out.println("2");
        System.out.println("1");                                                           
         ClearConsole.clearConsole();                // rensar konsolen                     ;
*/


        boolean knapp = true;


        while(knapp) {
            Welcome start = new Welcome();
            start.visaRegler();
            System.out.println("Huvudmeny\n[1] Starta spel\n[2] Avsluta spel \n[3] Återgå till spel regler.");
            Scanner scanner = new Scanner(System.in);
            String menyval1 = scanner.next();

            switch(menyval1) {

                case "1":
                    //startaSpel(scanner);   // skickar med scanner




                    System.out.println("Spelet startar!");
                    System.out.println("Vänligen skriv in din spelares alias: ");
                    String alias = scanner.next();              // använder scanner som skickas in
                    Spelare spelare = new Spelare(alias);       // skapar spelare
                    System.out.println("Välkommen " + spelare.getName() + "!");
                    System.out.println("Alla spelare är redo. Bered dig på strid!");
                    System.out.println("3");
                    System.out.println("2");
                    System.out.println("1");
                    ClearConsole.clearConsole();                // rensar konsolen

                    boolean spela = true;
                    while (spela) {
                        System.out.println("Spelmeny:");
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


                                for (int i = 0; i < vapenLista.size(); i++) {
                                    System.out.print((i + 1) + ". " + vapenLista.get(i));
                                    vapenLista.get(i);

                                }

                                System.out.println("Välj ett vapen:");

                                String vapenVal = scanner.next();
                                Vapen vapen = vapenLista.get(Integer.parseInt(vapenVal)-1);
                                spelare.setVapen(vapen);
                                System.out.println("Du har valt vapen: " + spelare.getVapen().toString());



                                break;
                            case "2":
                                System.out.println("Du gömmer dig i en zon...");
                                break;
                            case "3":
                                System.out.println("Spelet avslutas, tillbaka till huvudmeny!");
                                spela = false; // lämnar spel-loopen
                                break;
                            default:
                                System.out.println("Ogiltigt val.");
                        }
                    }
                    break;


                    case "2":
                        System.out.println("du har valt att avsluta spelet, tack för denna gång!");
                        knapp = false;
                        break;


                        case "3":
                            System.out.println("Återgå till spelregler");

                default:
                    System.out.println("Inget giltigt svar, vänligen välj mellan menyval 1-3");
            }

        }

        /*
        if (spela) {
            System.out.println("Spelet startar!");
            System.out.println("Vänligen skriv in din spelares alias: ");
            String alias = scanner.next();
            Spelare spelare = new Spelare(alias);
            System.out.println("Välkommen " + spelare.getName() + "!");
            System.out.println("Alla spelare är redo. Bered dig på strid!");

        }else {
            System.out.println("Spelet avslutas.");
        }

         */










        }
    }
