import org.Katalog_zapisowy.Grupa;
import org.Katalog_zapisowy.Kurs;
import org.Katalog_zapisowy.Termin;
import org.Katalog_zapisowy.Wydzial;
import org.Warstwa_prezentacji.Prowadzacy;
import org.Warstwa_prezentacji.Sluchacz;
import org.Warstwa_prezentacji.Uzytkownik;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import java.util.Vector;

import static org.junit.Assert.*;

public class Zadanie3 {
    Wydzial wydzial;
    Kurs kurs;
    Grupa testGrupy;
    Sluchacz sluchacz;
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Before
    public void setUp() {
        wydzial = new Wydzial("WIT", "W4");
        kurs = new Kurs("x", "x", 2, 2, wydzial);
        testGrupy = new Grupa("nazwa", "test", 1, kurs, Termin.stringToTermin("12:00-Pn-P"), new Prowadzacy(new Uzytkownik("Pawel", "Gluchowski", 0000, wydzial), "Katedra Informatyki Technicznej", "Dr inż."), "127L");
        sluchacz = new Sluchacz(new Uzytkownik("Adam", "Szatkowski", 2000, wydzial), 259056, 3, false);
    }

    @Category({SluchaczTest.class})
    @Test
    public void testZapiszDoGrupy(){
        System.out.println("Test zapisania studenta do grupy");
        assertTrue(sluchacz.zapisDoGrupy(testGrupy));
    }

    @Category({SluchaczTest.class})
    @Test
    public void testWrongZapiszDoGrupy(){
        System.out.println("Test zapisania studenta do grupy");
        sluchacz.zapisDoGrupy(testGrupy);
        assertFalse(sluchacz.zapisDoGrupy(testGrupy));
    }

    @Category({SluchaczTest.class})
    @Test
    public void testWpisanieDoPełnejGrupy(){
        System.out.println("Test wypisania studenta z grupy");
        sluchacz.zapisDoGrupy(testGrupy);
        assertTrue(sluchacz.wypisZGrupy(testGrupy));
    }

    @Category({SluchaczTest.class})
    @Test
    public void testWrongWpisanieDoPełnejGrupy(){
        System.out.println("Test wypisania studenta z grupy");
        assertFalse(sluchacz.wypisZGrupy(testGrupy));
    }

}
