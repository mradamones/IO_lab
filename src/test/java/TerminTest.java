
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.IllegalFormatCodePointException;
import org.junit.Test;

import static org.Katalog_zapisowy.Termin.stringToTermin;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.Katalog_zapisowy.Termin;

//@Category({TestControl.class, TestEntity.class}) //określenie kategorii testu, zastosowanie - p.2.7.1, 2.7.3

public class TerminTest {
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


    @Test(expected = DateTimeException.class)
    public void testPodanieZlejGodziny() {
        System.out.println("Cast terminu do stringa");
        terminCheckDateTimeException = new Termin(LocalTime.of(25, 0), "Pn", 'P');
        assertEquals(terminCheckDateTimeException.terminToString(), zlyTermin);
    }

    @Test(expected = DateTimeException.class)
    public void testPodanieZlegoTerminu() {
        System.out.println("Cast stringa do terminu");
        terminCheckDateTimeException = new Termin(LocalTime.of(25, 0), "Pn", 'P');
        Termin test = stringToTermin(zlyTermin);
        assertEquals(test.getDzienTygodnia(), terminCheckDateTimeException.getDzienTygodnia());
        assertEquals(test.getGodzina(), terminCheckDateTimeException.getGodzina());
        assertEquals(test.getParzystosc(), terminCheckDateTimeException.getParzystosc());
    }
    @Test
    public void testPodaniePoprawnejGodziny(){
        System.out.println("Cast terminu do stringa");
        terminCheckDateTimeException = new Termin(LocalTime.of(12, 0), "Pn", 'P');
        assertEquals(terminCheckDateTimeException.terminToString(), poprawnyTermin);
    }

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

