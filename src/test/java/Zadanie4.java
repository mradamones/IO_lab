import org.Katalog_zapisowy.Grupa;
import org.Warstwa_prezentacji.Aplikacja;
import org.Warstwa_prezentacji.Prowadzacy;
import org.Warstwa_prezentacji.Sluchacz;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Zadanie4 {

    static Aplikacja instance;

    static int testIndex;
    static String testId;
    static String testImie;
    static String testNazwisko;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    static public void SetUp() {
        instance = new Aplikacja();
        testIndex = 259056;
        testId = "xxx";
    }

    @Category({AppTest.class})
    @Test
    public void testGetSluchaczByIndex(){
        System.out.println("Test znalezienia studenta wg indeksu");
        Sluchacz testSluchacz = instance.getSluchaczByIndex(testIndex);
        assertNotNull(testSluchacz);
    }

    @Category({AppTest.class})
    @Test
    public void testGetGrupaById(){
        System.out.println("Test znalezienia grupy wg kodu");
        Grupa grupa = instance.getGrupaById(testId);
        assertNull(grupa);
    }

    @Category({AppTest.class})
    @Test
    public void testGetProwadzacyByImieNazwisko(){
        System.out.println("Test znalezienia prowadzacego wg imienia i nazwiska");
        Prowadzacy prowadzacy = instance.getProwadzacyByImieNazwisko(testImie, testNazwisko);
        assertNull(prowadzacy);
    }

}
