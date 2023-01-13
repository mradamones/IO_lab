package Katalog_zapisowy;
import Warstwa_prezentacji.Prowadzacy;

import java.time.LocalTime;

public class Grupa {

    private String nazwaGrupy;
    private String kodGrupy;
    private int liczbaMiejsc;
    private int liczbaZapisanych;
    private Prowadzacy prowadzacy;
    private Termin termin;
    private String sala;
    private Kurs kurs;

    /**
     *
     * @param nazwaGrupy
     * @param kodGrupy
     * @param liczbaMiejsc
     * @param kurs
     */
    public Grupa(String nazwaGrupy, String kodGrupy, int liczbaMiejsc, Kurs kurs, Termin termin, Prowadzacy prowadzacy, String sala) {
        this.nazwaGrupy = nazwaGrupy;
        this.kodGrupy = kodGrupy;
        this.liczbaMiejsc = liczbaMiejsc;
        this.kurs = kurs;
        this.termin = termin;
        this.prowadzacy = prowadzacy;
        this.sala = sala;
        this.liczbaZapisanych = 0;
        throw new UnsupportedOperationException();
    }

    public String getNazwaGrupy() {
        return this.nazwaGrupy;
    }

    /**
     *
     * @param nazwaGrupy
     */
    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }

    public String getKodGrupy() {
        return this.kodGrupy;
    }

    /**
     *
     * @param kodGrupy
     */
    public void setKodGrupy(String kodGrupy) {
        this.kodGrupy = kodGrupy;
    }

    public int getLiczbaMiejsc() {
        return this.liczbaMiejsc;
    }

    /**
     *
     * @param liczbaMiejsc
     */
    public void setLiczbaMiejsc(int liczbaMiejsc) {
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public int getLiczbaZapisanych() {
        return this.liczbaZapisanych;
    }

    public void zwiekszZapisanych(){
        this.liczbaZapisanych++;
    }

    public void zmniejszZapisanych(){
        this.liczbaZapisanych--;
    }

    public Prowadzacy getProwadzacy() {
        return this.prowadzacy;
    }

    /**
     *
     * @param prowadzacy
     */
    public void setProwadzacy(Prowadzacy prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public Termin getTermin() {
        return this.termin;
    }

    /**
     *
     * @param termin
     */
    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public String getSala() {
        return this.sala;
    }

    /**
     *
     * @param sala
     */
    public void setSala(String sala) {
        this.sala = sala;
    }

    public Kurs getKurs() {
        return this.kurs;
    }

    /**
     *
     * @param kurs
     */
    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

}