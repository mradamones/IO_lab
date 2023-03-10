package org.Warstwa_prezentacji;

import org.Katalog_zapisowy.*;

import java.time.LocalDateTime;
import java.util.*;

public class Sluchacz extends Uzytkownik {

    private int indeks;
    private int rokStudiow;
    private boolean stopien;
    private LocalDateTime terminZapisow;
    public Vector<Grupa> zapisaneGrupy;

    /**
     *
     * @param uzytkownik
     * @param indeks
     * @param rokStudiow
     * @param stopien
     */
    public Sluchacz(Uzytkownik uzytkownik, int indeks, int rokStudiow, boolean stopien) {
        this.setImie(uzytkownik.getImie());
        this.setNazwisko(uzytkownik.getNazwisko());
        this.setRokUrodzenia(uzytkownik.getRokUrodzenia());
        this.setWydzial(uzytkownik.getWydzial());
        this.indeks = indeks;
        this.rokStudiow = rokStudiow;
        this.stopien = stopien;
        this.zapisaneGrupy = new Vector<Grupa>();
    }

    public int getIndeks() {
        return this.indeks;
    }

    /**
     *
     * @param indeks
     */
    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public int getRokStudiow() {
        return this.rokStudiow;
    }

    /**
     *
     * @param rokStudiów
     */
    public void setRokStudiow(int rokStudiów) {
        this.rokStudiow = rokStudiow;
    }

    public boolean getStopien() {
        return this.stopien;
    }

    /**
     *
     * @param stopien
     */
    public void setStopien(boolean stopien) {
        this.stopien = stopien;
    }

    public LocalDateTime getTerminZapisow() {
        return this.terminZapisow;
    }

    /**
     *
     * @param terminZapisow
     */
    public void setTerminZapisow(LocalDateTime terminZapisow) {
        this.terminZapisow = terminZapisow;
    }

    /**
     *
     * @param grupa
     */
    public boolean zapisDoGrupy(Grupa grupa) {
        if(grupa.getLiczbaMiejsc() - grupa.getLiczbaZapisanych() > 0 && !zapisaneGrupy.contains(grupa))
        {
            this.zapisaneGrupy.add(grupa);
            grupa.zwiekszZapisanych();
            return true;
        } else
            return false;
    }

    /**
     *
     * @param grupa
     */
    public boolean wypisZGrupy(Grupa grupa) {
        if(this.zapisaneGrupy.contains(grupa)){
            zapisaneGrupy.remove(grupa);
            grupa.zmniejszZapisanych();
            return true;
        } else
            return false;
    }

    public void przegladajZapisane() {
        System.out.println("Student o indeksie " + this.indeks + " jest zapisany do grup:");
        for(int i = 0; i < this.zapisaneGrupy.size(); i++){
            System.out.println((i+1) + ". Grupa: " + this.zapisaneGrupy.get(i).getNazwaGrupy());
        }
    }

    public List<Grupa> getZapisaneGrupy() {
        return this.zapisaneGrupy;
    }

    /**
     *
     * @param zapisaneGrupy
     */
    public void setZapisaneGrupy(Vector<Grupa> zapisaneGrupy) {
        this.zapisaneGrupy = zapisaneGrupy;
    }

}