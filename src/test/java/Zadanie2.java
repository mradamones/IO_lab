
import java.time.DateTimeException;
import java.time.LocalTime;

import org.junit.ComparisonFailure;
import org.junit.Test;

import static org.Katalog_zapisowy.Termin.stringToTermin;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.Katalog_zapisowy.Termin;


public class Zadanie2 {
    String zlyTermin;
    String poprawnyTermin;
    Termin terminCheckDateTimeException;
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Before
    public void setUp() {
        poprawnyTermin = "12:00-Pn-P";
        zlyTermin = "25:00-Pn-P";
    }

    //Użycie zmiennej spoza zakresu
    @Category({GroupTest.class})
    @Test(expected = DateTimeException.class)
    public void testPodanieZlejGodziny() {
        System.out.println("Cast terminu do stringa");
        terminCheckDateTimeException = new Termin(LocalTime.of(25, 0), "Pn", 'P');
        assertEquals(terminCheckDateTimeException.terminToString(), zlyTermin);
    }

    //Podanie złego stringa
    @Category({GroupTest.class})
    @Test(expected = ComparisonFailure.class)
    public void testPodanieZlegoTerminu() {
        System.out.println("Cast stringa do terminu");
        terminCheckDateTimeException = new Termin(LocalTime.of(12, 0), "Pon", 'P');
        Termin test = stringToTermin(poprawnyTermin);
        assertEquals(test.getDzienTygodnia(), terminCheckDateTimeException.getDzienTygodnia());
        assertEquals(test.getGodzina(), terminCheckDateTimeException.getGodzina());
        assertEquals(test.getParzystosc(), terminCheckDateTimeException.getParzystosc());
    }

    //Sprawdzenie, czy metoda terminToString zwraca prawidłowego stringa
    @Category({GroupTest.class})
    @Test
    public void testPodaniePoprawnejGodziny(){
        System.out.println("Cast terminu do stringa");
        terminCheckDateTimeException = new Termin(LocalTime.of(12, 0), "Pn", 'P');
        assertEquals(terminCheckDateTimeException.terminToString(), poprawnyTermin);
    }

    //Sprawdzenie, termin zostanie poprawnie utworzony przy użyciu prawidłowego sformatowanego tekstu
    @Category({GroupTest.class})
    @Test
    public void testPodaniePoprawnegoTerminu() {
        System.out.println("Cast stringa do terminu");
        terminCheckDateTimeException = new Termin(LocalTime.of(12, 0), "Pn", 'P');
        Termin test = stringToTermin(poprawnyTermin);
        assertEquals(test.getDzienTygodnia(), terminCheckDateTimeException.getDzienTygodnia());
        assertEquals(test.getGodzina(), terminCheckDateTimeException.getGodzina());
        assertEquals(test.getParzystosc(), terminCheckDateTimeException.getParzystosc());
    }


}

