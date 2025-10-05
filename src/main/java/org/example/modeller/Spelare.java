package org.example.modeller;

public class Spelare { //Vi skapa klassen spelare
    private String anvNamn; //För att spara spelarens namn
    private double kapital; //spara spelarens livspoäng
    private Vapen vapen;
    private boolean levande;


    //Konstruktor för skapande av spelaren
    public Spelare(String anvNamn) {
        this.anvNamn = anvNamn;
        this.kapital = 1_000_000; //Alla spelare är värd en miljon
        this.levande = true;
    }

    public Spelare(String anvNamn, double kapital, Vapen vaoen) {
        this.anvNamn = anvNamn;
        this.kapital = kapital;
        this.vapen = vaoen;
        this.levande = true;
    }

    public String getAnvNamn() {
        return anvNamn;
    }
    public double getKapital() {
        return kapital;
    }
    public void setVapen(Vapen vapen) {
        this.vapen = vapen;
    }
    public  Vapen getVapen() {
        return vapen;
    }
    public boolean isLevande() {
        return levande;
    }

    //Spelaren eliminieras
    public void elimineras(String orsak) {
        levande = false;
        System.out.println(anvNamn + " är eliminerad (" + orsak + ") vinst potten har ökat med " + kapital);
    }

    public void okaVinstPott(double belopp){
        this.kapital += belopp;
    }


      /*
    public void setAnvNamn(String anvNamn) {
        this.anvNamn = anvNamn;
    }




    /*

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() { //Metod som returnerar spelarens namn
        return anvNamn;
    }

    public int getHp() { //Metod som returnerar spelarens nuvarande hälsa
        return hp;
    }

    public void setVapen(Vapen vapen) {
        this.vapen = vapen;
    }

    public Vapen getVapen() {
        return vapen;
    }

    public Spelare(String anvNamn, int hp, Vapen vapen) {
        this.anvNamn = anvNamn;
        this.hp = hp;
        this.vapen = vapen;
    }

    public void taSkada(int skada) { //Metod om att kunna ta skada, man kan inte hamna under 0
        hp -= skada;
        if (hp < 0 ) hp = 0;
    }

     */
}


