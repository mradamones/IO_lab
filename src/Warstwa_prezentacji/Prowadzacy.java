package Warstwa_prezentacji;

import Katalog_zapisowy.Grupa;
import Katalog_zapisowy.Kurs;
import Katalog_zapisowy.Wydzial;
import Katalog_zapisowy.Termin;

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
     * @param indeks
     * @param kodGrupy
     */
    public boolean zapisPonadStan(Sluchacz sluchacz, Grupa grupa) {
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
     * @param indeks
     * @param termin
     */
    public void przydzielenieTerminuZapisow(Sluchacz sluchacz, LocalDateTime termin) {
        sluchacz.setTerminZapisow(termin);
    }

    /**
     *
     * @param grupa
     * @param doZmiany
     * @param nowaWartosc
     */
    public boolean modyfikacjaGrupy(Grupa grupa, String doZmiany, String nowaWartosc) {
        switch(doZmiany) {
            case "nazwaGrupy":
                grupa.setNazwaGrupy(nowaWartosc);
                return true;
            case "kodGrupy":
                grupa.setKodGrupy(nowaWartosc);
                return true;
            case "liczbaMiejsc":
                grupa.setLiczbaMiejsc(Integer.parseInt(nowaWartosc));
                return true;
            case "termin":
                grupa.setTermin(Termin.stringToTermin(nowaWartosc));
                return true;
            case "sala":
                grupa.setSala(nowaWartosc);
                return true;
        }
        return false;
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
        switch(doZmiany) {
            case "nazwaKursu":
                kurs.setNazwaKursu(nowaWartosc);
                return true;
            case "kodGrupy":
                kurs.setNazwaKursu(nowaWartosc);
                return true;
            case "ECTS":
                kurs.setECTS(Integer.parseInt(nowaWartosc));
                return true;
            case "liczbaGodzin":
                kurs.setLiczbaGodzin(Integer.parseInt(nowaWartosc));
                return true;
        }
        return false;
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
     * @param grupa
     */
    public Grupa dodawanieGrupy(String nazwaGrupy, String kodGrupy, int liczbaMiejsc, Kurs kurs, Termin termin, String sala) {
        try{
            return new Grupa(nazwaGrupy, kodGrupy, liczbaMiejsc, kurs, termin, this, sala);
            } catch(Exception e) {
            return null;
        }
    }

    /**
     *
     * @param kurs
     */
    public Kurs dodawanieKursu(String nazwaKursu, String kodKursu, int ECTS, int liczbaGodzin, Wydzial wydzial) {
        try{
            return new Kurs(nazwaKursu, kodKursu, ECTS, liczbaGodzin, wydzial);
        } catch(Exception e) {
            return null;
        }
    }

}