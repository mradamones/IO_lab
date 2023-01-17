package Warstwa_prezentacji;

import Katalog_zapisowy.*;

import java.util.List;

class Uzytkownik {
    private String imie;
    private String nazwisko;
    private int rokUrodzenia;
    private Wydzial wydzial;

    /**
     *
     * @param imie
     * @param nazwisko
     * @param rokUrodzenia
     */
    protected Uzytkownik(String imie, String nazwisko, int rokUrodzenia, Wydzial wydzial) {
        this.imie = imie;
        this. nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
        this.wydzial = wydzial;
    }

    protected Uzytkownik() {
        new Uzytkownik("","",0,null);
    }

    public String getImie() {
        return this.imie;
    }

    /**
     *
     * @param imie
     */
    protected void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return this.nazwisko;
    }

    /**
     *
     * @param nazwisko
     */
    protected void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    protected int getRokUrodzenia() {
        return this.rokUrodzenia;
    }

    /**
     *
     * @param rokUrodzenia
     */
    protected void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }

    public Wydzial getWydzial() {
        return this.wydzial;
    }

    /**
     *
     * @param wydzial
     */
    protected void setWydzial(Wydzial wydzial) {
        this.wydzial = wydzial;
    }

    /**
     *
     * @param kodGrupy
     */
    protected void pokazInfoOGrupie(Grupa grupa) {
        System.out.println("Grupa " + grupa.getKodGrupy() + ":");
        System.out.println("Liczba miejsc: " + grupa.getLiczbaMiejsc() + ",");
        System.out.println("Liczba zapisanych słuchaczy: " + grupa.getLiczbaZapisanych() + ",");
        System.out.println("Prowadzący: " + grupa.getProwadzacy().getTytulNaukowy()
                + " " + grupa.getProwadzacy().getImie()
                + " " + grupa.getProwadzacy().getNazwisko() + ",");
        System.out.println("Termin: " + grupa.getTermin().terminToString() + ",");
        System.out.println("Sala: " + grupa.getSala() + ",");
        System.out.println("Kurs: " + grupa.getKurs().getKodKursu() + ".");
    }

    /**
     *
     * @param kodKursu
     */
    protected void pokazInfoOKursie(Kurs kurs) {
        System.out.println("Kurs " + kurs.getNazwaKursu() + ":");
        System.out.println("Kod kursu: " + kurs.getKodKursu() + ",");
        System.out.println("Liczba godzin w semestrze: " + kurs.getLiczbaGodzin() + ",");
        System.out.println("Liczba ECTS: " + kurs.getECTS() + ",");
        System.out.println("Wydzial: " + kurs.getWydzial() + ".");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param filtr

    protected List<Grupa> wyszukajGrupe(String filtr) {
        // TODO - implement Użytkownik.wyszukajGrupe
        throw new UnsupportedOperationException();
    }*/

}