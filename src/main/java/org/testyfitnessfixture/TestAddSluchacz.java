package org.testyfitnessfixture;

import fit.ColumnFixture;

import java.util.IllegalFormatCodePointException;

public class TestAddSluchacz extends ColumnFixture {
    String imie;
    String nazwisko;
    int rok_urodzenia;
    int index;
    int rok_studiow;
    boolean stopien;
    public boolean addSluchacz() throws IllegalFormatCodePointException {
        int s1 = liczbaSluchaczy();
        try {
            SetUp.aplikacja.addSluchacz(imie, nazwisko, rok_urodzenia, index, rok_studiow, stopien);
            int s2 = liczbaSluchaczy();
            return s1!=s2;
        } catch(IllegalFormatCodePointException e){
            e.getMessage();
            return false;
        }
    }
    public int liczbaSluchaczy(){
        return SetUp.aplikacja.sluchaczVector.size();
    }

}
