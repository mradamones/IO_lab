
import org.Katalog_zapisowy.Kurs;
import org.Katalog_zapisowy.Wydzial;
import org.Warstwa_prezentacji.Aplikacja;
import org.Warstwa_prezentacji.Prowadzacy;
import org.Warstwa_prezentacji.Sluchacz;
import org.Warstwa_prezentacji.Uzytkownik;
import org.junit.BeforeClass;
import org.junit.Test;
import mockit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

//@RunWith(Zadanie6.class)
public class Zadanie6 {
    static Uzytkownik uzytkownik2;
    @Mocked
    Uzytkownik uzytkownik1 = new Uzytkownik();
    Wydzial wydzial1 = new Wydzial();
    @BeforeClass
    static public void SetUp() {
        uzytkownik2 = new Uzytkownik("Mati", "Piłkarz", 2000, new Wydzial("Wydział Informatyki","W4N"));

    }
    @Test
    public void testEqualsProwadzacy() {
        Prowadzacy prowadzacy[] ={new Prowadzacy(uzytkownik2, "ITE","Dr inż.") , new Prowadzacy(uzytkownik1,"ITE","Dr inż.")};
        assertTrue(prowadzacy[0].equals(prowadzacy[0]));
        assertFalse(prowadzacy[0].equals(prowadzacy[1]));
    }
    @Test
    public void testEqualsSluchacz() {
        Sluchacz sluchacz[] ={new Sluchacz(uzytkownik2, 259056,3,false) , new Sluchacz(uzytkownik1,259056,3,false)};
        assertTrue(sluchacz[0].equals(sluchacz[0]));
        assertFalse(sluchacz[0].equals(sluchacz[1]));
    }
    @Test
    public void testProwadzacy(){
        Prowadzacy prowadzacy[] ={new Prowadzacy(uzytkownik2, "ITE","Dr inż.") , new Prowadzacy(uzytkownik1,"ITE","Dr inż.")};
        prowadzacy[0].setImie("Mati");
        String imiona[] = {"Mati",null};
        new Expectations() {{
                 prowadzacy[0].getImie(); result = imiona[0];
                 prowadzacy[1].getImie();result = imiona[1];
            }
        };
        System.out.println("Test porownania imienia prowadzacego z imionami");
        //Actual, Expected
        assertEquals(prowadzacy[0].getImie(),imiona[0]);
        assertEquals(prowadzacy[1].getImie(),imiona[1]);
    }

    @Test
    public void testGetWydzial(){
        Wydzial wydzialTest = new Wydzial();
        Kurs kursy[] = {new Kurs("", "", 30, 30, wydzial1), new Kurs("","",30,30,wydzialTest)};
        assertTrue(kursy[0].getWydzial().equals(wydzial1));
        assertFalse(kursy[1].getWydzial().equals(wydzial1));
    }
}
