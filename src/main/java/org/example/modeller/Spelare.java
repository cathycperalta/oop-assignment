package org.example.modeller;

public class Spelare { //Vi skapa klassen spelare
    private String anvNamn; //För att spara spelarens namn
    private int hp; //spara spelarens livspoäng
    private Vapen vapen;

    public Spelare(String anvNamn) { //Konstruktorn
        this.anvNamn = anvNamn;
        this.hp = 100; //Start värdet på hälsan/livspoäng
    }

    public void setAnvNamn(String anvNamn) {
        this.anvNamn = anvNamn;
    }

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
}


