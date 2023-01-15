package org.Katalog_zapisowy;

public class Wydzial {

    private String nazwa;
    private String skrot;
    private String dziekan;

    /**
     *
     * @param nazwa
     * @param skrot
     */
    public Wydzial(String nazwa, String skrot) {
        new Wydzial(nazwa, skrot, "");
    }

    /**
     *
     * @param nazwa
     * @param skrot
     * @param dziekan
     */
    public Wydzial(String nazwa, String skrot, String dziekan) {
        this.nazwa = nazwa;
        this.skrot = skrot;
        this.dziekan = dziekan;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    /**
     *
     * @param nazwa
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getSkrot() {
        return this.skrot;
    }

    /**
     *
     * @param skrot
     */
    public void setSkrot(String skrot) {
        this.skrot = skrot;
    }

    public String getDziekan() {
        return this.dziekan;
    }

    /**
     *
     * @param dziekan
     */
    public void setDziekan(String dziekan) {
        this.dziekan = dziekan;
    }

}