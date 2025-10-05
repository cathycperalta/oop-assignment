package org.example;

import org.example.modeller.*;
import org.example.spel.Welcome;
import org.example.spel.SpelKontroller;
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

        boolean knapp = true;




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


                       {



                                System.out.println("Välj ett vapen:");

                                String vapenVal = scanner.next();
                                Vapen vapen = vapenLista.get(Integer.parseInt(vapenVal) - 1);
                                spelare.setVapen(vapen);
                                System.out.println("\n Du har valt vapen: " + spelare.getVapen().toString());
                                System.out.println("");
                                System.out.println("");
                                System.out.println("Du blir attackerad av " + randombot + ".");
                                System.out.println("Båda spelare är redo för strid");
                                System.out.println("3");
                                System.out.println("2");
                                System.out.println("1");
                                ClearConsole.clearConsole();

                                // här vil jag ha en slumpmässig fight med användaren och botten på 50% chans. Här ska det printas ut om anv vinner eller boten. Vinner användaren, så kommer ännu en meny till. Förlorar spelaren ska det meddelas och så får man välja om man vill spela igen eller avsluta spel




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
