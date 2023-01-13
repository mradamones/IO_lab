package Katalog_zapisowy;

public class Kurs {

    private String nazwaKursu;
    private String kodKursu;
    private int ECTS;
    private int liczbaGodzin;
    private Wydzial wydzial;

    /**
     *
     * @param nazwaKursu
     * @param kodKursu
     * @param ECTS
     * @param liczbaGodzin
     */
    public Kurs(String nazwaKursu, String kodKursu, int ECTS, int liczbaGodzin, Wydzial wydzial) {
        this.nazwaKursu = nazwaKursu;
        this.kodKursu = kodKursu;
        this.ECTS = ECTS;
        this.liczbaGodzin = liczbaGodzin;
        this.wydzial = wydzial;
    }

    public String getNazwaKursu() {
        return this.nazwaKursu;
    }

    /**
     *
     * @param nazwaKursu
     */
    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }

    public String getKodKursu() {
        return this.kodKursu;
    }

    /**
     *
     * @param kodKursu
     */
    public void setKodKursu(String kodKursu) {
        this.kodKursu = kodKursu;
    }

    public int getECTS() {
        return this.ECTS;
    }

    /**
     *
     * @param ECTS
     */
    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public int getLiczbaGodzin() {
        return this.liczbaGodzin;
    }

    /**
     *
     * @param liczbaGodzin
     */
    public void setLiczbaGodzin(int liczbaGodzin) {
        this.liczbaGodzin = liczbaGodzin;
    }

    public Wydzial getWydzial() {
        return this.wydzial;
    }

    /**
     *
     * @param wydzial
     */
    public void setWydzial(Wydzial wydzial) {
        this.wydzial = wydzial;
    }

}