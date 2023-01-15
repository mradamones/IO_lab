package org.Katalog_zapisowy;

import java.time.LocalTime;

public class Termin {

    private LocalTime godzina;
    private String dzienTygodnia;
    private char parzystosc;

    /**
     * HH:MM-DT-P
     * @param godzina
     * @param dzienTygodnia
     * Pn / Wt / Sr / Cz / Pt / So / Nd
     * N / P / T
     */
    public Termin(LocalTime godzina, String dzienTygodnia, char parzystosc) {
        this.godzina = godzina;
        this.dzienTygodnia = dzienTygodnia;
        this.parzystosc = parzystosc;
    }

    public static Termin stringToTermin(String termin){
        String[] sentences = termin.split("-");
        return new Termin(LocalTime.parse(sentences[0]), sentences[1], sentences[2].charAt(0));
    }

    public String terminToString(){
        return (this.godzina.toString() + "-" +  this.dzienTygodnia + "-" + this.parzystosc);
    }
    public LocalTime getGodzina() {
        return this.godzina;
    }

    /**
     *
     * @param godzina
     */
    public void setGodzina(LocalTime godzina) {
        this.godzina = godzina;
    }

    public String getDzienTygodnia() {
        return this.dzienTygodnia;
    }

    /**
     *
     * @param dzienTygodnia
     */
    public void setDzienTygodnia(String dzienTygodnia) {
        this.dzienTygodnia = dzienTygodnia;
    }

    public char getParzystosc() {
        return this.parzystosc;
    }

    /**
     *
     * @param parzystosc
     */
    public void setParzystosc(char parzystosc) {
        this.parzystosc = parzystosc;
    }

}