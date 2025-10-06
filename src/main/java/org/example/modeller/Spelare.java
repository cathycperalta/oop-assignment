

/*
*
*
*
* */
package org.example.modeller;

public abstract class Spelare {
    protected String anvNamn;
    protected boolean levande;
    protected Vapen vapen;

    public Spelare(String anvNamn) {
        this.anvNamn = anvNamn;
        this.levande = true;
        this.vapen = null;
    }

    public String getAnvNamn() {
        return anvNamn;
    }

    public boolean isLevande() {
        return levande;
    }

    public void setLevande(boolean levande) {
        this.levande = levande;
    }

    public Vapen getVapen() {
        return vapen;
    }

    public void setVapen(Vapen vapen) {
        this.vapen = vapen;
    }

    public void elimineras(String anledning) {
        this.levande = false;
        System.out.println(this.anvNamn + " är eliminerad (" + anledning + ")");
    }

    // ===== Lägg till equals och hashCode för Map-nycklar =====
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spelare spelare = (Spelare) o;
        return anvNamn.equals(spelare.anvNamn);
    }

    @Override
    public int hashCode() {
        return anvNamn.hashCode();
    }
}