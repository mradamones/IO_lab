package org.Warstwa_prezentacji;

import org.Katalog_zapisowy.Grupa;
import org.Katalog_zapisowy.Kurs;
import org.Katalog_zapisowy.Wydzial;
import org.Katalog_zapisowy.Termin;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Prowadzacy extends Uzytkownik {

    private String katedra;
    private String tytulNaukowy;

    /**
     * @param uzytkownik
     * @param katedra
     * @param tytulNaukowy
     */
    public Prowadzacy(Uzytkownik uzytkownik, String katedra, String tytulNaukowy) {
        this.setImie(uzytkownik.getImie());
        this.setNazwisko(uzytkownik.getNazwisko());
        this.setRokUrodzenia(uzytkownik.getRokUrodzenia());
        this.setWydzial(uzytkownik.getWydzial());
        this.katedra = katedra;
        this.tytulNaukowy = tytulNaukowy;
    }



    public String getKatedra() {
        return this.katedra;
    }

    /**
     *
     * @param katedra
     */
    public void setKatedra(String katedra) {
        this.katedra = katedra;
    }

    public String getTytulNaukowy() {
        return this.tytulNaukowy;
    }

    /**
     *
     * @param tytulNaukowy
     */
    public void setTytulNaukowy(String tytulNaukowy) {
        this.tytulNaukowy = tytulNaukowy;
    }

    /**
     *
     * @param sluchacz
     * @param grupa
     */
    public static boolean zapisPonadStan(Sluchacz sluchacz, Grupa grupa) {
        if(grupa.getLiczbaZapisanych() - grupa.getLiczbaMiejsc() > 0)
        {
            sluchacz.zapisaneGrupy.add(grupa);
            grupa.zwiekszZapisanych();
            return true;
        } else
            return false;
    }

    /**
     *
     * @param sluchacz
     * @param termin
     */
    public static void przydzielenieTerminuZapisow(Sluchacz sluchacz, LocalDateTime termin) {
        sluchacz.setTerminZapisow(termin);
    }

    /**
     *
     * @param grupa
     * @param doZmiany
     * @param nowaWartosc
     */
    public boolean modyfikacjaGrupy(Grupa grupa, String doZmiany, String nowaWartosc) {
        boolean czyZmienione;
        switch(doZmiany) {
            case "nazwaGrupy":
                czyZmienione = true;
                grupa.setNazwaGrupy(nowaWartosc);
            case "kodGrupy":
                czyZmienione = true;
                grupa.setKodGrupy(nowaWartosc);
            case "liczbaMiejsc":
                czyZmienione = true;
                grupa.setLiczbaMiejsc(Integer.parseInt(nowaWartosc));
            case "termin":
                czyZmienione = true;
                grupa.setTermin(Termin.stringToTermin(nowaWartosc));
            case "sala":
                czyZmienione = true;
                grupa.setSala(nowaWartosc);
            default:
                czyZmienione = false;
        }
        return czyZmienione;
    }
    public boolean modyfikacjaGrupy(Grupa grupa, Prowadzacy nowaWartosc) {
        try{
            grupa.setProwadzacy(nowaWartosc);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean modyfikacjaGrupy(Grupa grupa, Kurs nowaWartosc) {
        try{
            grupa.setKurs(nowaWartosc);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    /**
     *     private String nazwaKursu;
     *     private String kodKursu;
     *     private int ECTS;
     *     private int liczbaGodzin;
     *     private Wydzial wydzial;
     * @param kurs
     * @param doZmiany
     * @param nowaWartosc
     */
    public boolean modyfikacjaKursu(Kurs kurs, String doZmiany, String nowaWartosc) {
        boolean czyZmienione;
        switch(doZmiany) {
            case "nazwaKursu":
                czyZmienione = true;
            kurs.setNazwaKursu(nowaWartosc);
            case "kodKursu":
                czyZmienione = true;
                kurs.setKodKursu(nowaWartosc);
            case "ECTS":
                czyZmienione = true;
                kurs.setECTS(Integer.parseInt(nowaWartosc));
            case "liczbaGodzin":
                czyZmienione = true;
                kurs.setLiczbaGodzin(Integer.parseInt(nowaWartosc));
            default:
                czyZmienione = false;
        }
        return czyZmienione;
    }
    public boolean modyfikacjaKursu(Kurs kurs, Wydzial nowaWartosc) {
        try{
            kurs.setWydzial(nowaWartosc);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    /**
     *
     * @param nazwaGrupy
     */
    public static Grupa dodawanieGrupy(String nazwaGrupy, String kodGrupy, int liczbaMiejsc, Kurs kurs, Termin termin, String sala, Prowadzacy prowadzacy) {
        try{
            return new Grupa(nazwaGrupy, kodGrupy, liczbaMiejsc, kurs, termin, prowadzacy, sala);
            } catch(Exception e) {
            return null;
        }
    }

    /**
     *
     * @param nazwaKursu
     */
    public static Kurs dodawanieKursu(String nazwaKursu, String kodKursu, int ECTS, int liczbaGodzin, Wydzial wydzial) {
        try{
            return new Kurs(nazwaKursu, kodKursu, ECTS, liczbaGodzin, wydzial);
        } catch(Exception e) {
            return null;
        }
    }

}