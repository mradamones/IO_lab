package Katalog_zapisowy;

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
        return new Termin(LocalTime.parse(termin.substring(0,5)), termin.substring(6, 2), termin.charAt(9));
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