package org.example;

import org.example.modeller.Vapen;
import org.example.modeller.Yxa;
import org.example.spel.Welcome;
import org.example.modeller.Spelare;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello World");
        Scanner scanner = new Scanner(System.in);
        Welcome start = new Welcome();
        start.visaRegler();

        boolean spela = start.spelStart(scanner);
        Yxa yxa2000 = new Yxa("Yxa1", 10);
        Spelare spelareTest = new Spelare("Alexa", 100, yxa2000);

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










        }
    }
