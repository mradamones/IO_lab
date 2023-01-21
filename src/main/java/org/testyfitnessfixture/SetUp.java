package org.testyfitnessfixture;
import fit.Fixture;
import org.Warstwa_prezentacji.Aplikacja;
public class SetUp extends Fixture {
    static Aplikacja aplikacja;
    public SetUp(){
        aplikacja = new Aplikacja();
    }
}
