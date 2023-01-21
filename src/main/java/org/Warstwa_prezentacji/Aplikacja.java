package org.Warstwa_prezentacji;

import org.Katalog_zapisowy.Grupa;
import org.Katalog_zapisowy.Kurs;
import org.Katalog_zapisowy.Termin;
import org.Katalog_zapisowy.Wydzial;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;
public class Aplikacja {

    public static Vector <Uzytkownik> uzytkownikVector = new Vector<Uzytkownik>();
    public static Vector <Prowadzacy> prowadzacyVector = new Vector<Prowadzacy>();
    public static Vector <Sluchacz> sluchaczVector = new Vector<Sluchacz>();
    public static Vector <Wydzial> wydzialVector = new Vector <Wydzial>();
    public static Vector <Termin> terminVector = new Vector <Termin>();
    public static Vector <Kurs> kursVector = new Vector<Kurs>();
    public static Vector <Grupa> grupaVector = new Vector<Grupa>();
    public Aplikacja() {
        wydzialVector.add(new Wydzial("WIT", "W4", "DziekanPiwo"));
        uzytkownikVector.add(new Uzytkownik("Piotr", "Jasik", 2000, wydzialVector.get(0)));
        uzytkownikVector.add(new Uzytkownik("Adam", "Szatkowski", 2000, wydzialVector.get(0)));
        uzytkownikVector.add(new Uzytkownik("Tomasz", "Kaplon", 1978, wydzialVector.get(0)));
        uzytkownikVector.add(new Uzytkownik("Jan", "Nikodem", 1895, wydzialVector.get(0)));
        prowadzacyVector.add(new Prowadzacy(uzytkownikVector.get(2), "Katedra Informatyki Technicznej", "Doktor"));
        prowadzacyVector.add(new Prowadzacy(uzytkownikVector.get(3), "Katedra Informatyki Technicznej", "Doktor"));
        sluchaczVector.add(new Sluchacz(uzytkownikVector.get(0), 259087, 2020, false));
        sluchaczVector.add(new Sluchacz(uzytkownikVector.get(1), 259056, 2020, false));
        kursVector.add(new Kurs("Kursik", "testKurs", 30, 1, wydzialVector.get(0)));
        grupaVector.add(new Grupa("nazwa", "test", 1,kursVector.get(0), Termin.stringToTermin("12:00-Pn-P"), prowadzacyVector.get(0), "127L"));
    }

    public static void main(String args[]) {
        new Aplikacja();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Program obsługujący zapisy na zajęcia na wyższych uczelniach");
            System.out.println("Wybierz opcje:");
            System.out.println("1 -> Zaloguj sie jako student");
            System.out.println("2 -> Zaloguj sie jako prowadzacy");
            System.out.println("X -> Wyjscie z aplikacji");
            String option = scan.nextLine();
            switch(option){
                case "2":
                    System.out.println("Podaj imie: ");
                    String login = scan.nextLine();
                    for (int i = 0; i < prowadzacyVector.size(); i++) {
                        if (prowadzacyVector.elementAt(i).getImie().equals(login)) {
                            System.out.println("Podaj nazwisko: ");
                            String haslo = scan.nextLine();
                            if (prowadzacyVector.elementAt(i).getNazwisko().equals(haslo)) {
                                System.out.println("Logowanie jako prowadzacy...");
                                menu_prowadzacy(prowadzacyVector.elementAt(i));
                            } else
                                System.out.println("Niepoprawne haslo!");
                        }
                    }
                    break;
                case "1":
                    System.out.println("Podaj imie: ");
                    login = scan.nextLine();
                    for (int i = 0; i < sluchaczVector.size(); i++) {
                        if (sluchaczVector.elementAt(i).getImie().equals(login)) {
                            System.out.println("Podaj nazwisko: ");
                            String haslo = scan.nextLine();
                            if (sluchaczVector.elementAt(i).getNazwisko().equals(haslo)) {
                                System.out.println("Logowanie jako student...");
                                menu_student(sluchaczVector.elementAt(i));
                            } else
                                System.out.println("Niepoprawne haslo!");
                        }
                    }
                    break;
                default:
                    System.out.println("Zamykanie programu...");
                    return;
            }
        }
    }

    public static void menu_prowadzacy(Prowadzacy prowadzacy){
        System.out.println("Witaj w systemie EdukacjaCentyLitr!");
        while(true){
            System.out.println("Wybierz opcję: ");
            System.out.println("1 -> dodaj grupe");
            System.out.println("2 -> dodaj kurs");
            System.out.println("3 -> modyfikuj grupe");
            System.out.println("4 -> modyfikuj kurs");
            System.out.println("5 -> zapisz ponad stan");
            System.out.println("6 -> przydziel termin zapisow");
            System.out.println("7 -> wyswietl info o grupie");
            System.out.println("8 -> wyswietl info o kursie");
            System.out.println("0 -> powrot");
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            scan.nextLine();
            switch(option){
                case 1:
                    System.out.println("Wprowadz nazwe grupy: ");
                    String nazwaGrupy = scan.nextLine();
                    System.out.println("Wprowadz kod grupy: ");
                    String kodGrupy = scan.nextLine();
                    System.out.println("Wprowadz liczbe wolnych miejsc: ");
                    int liczbaMiejsc = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Wprowadz nazwe kursu: ");
                    String idKursu = scan.nextLine();
                    System.out.println("Wprowadz termin [HH:MM-Dd-P]: ");
                    String terminString = scan.nextLine();
                    Termin termin = Termin.stringToTermin(terminString);
                    System.out.println("Wprowadz sale grupy: ");
                    String sala = scan.nextLine();
                    grupaVector.add(prowadzacy.dodawanieGrupy(nazwaGrupy,kodGrupy,liczbaMiejsc,getKursById(idKursu),termin,sala, prowadzacy));
                    break;
                case 2:
                    System.out.println("Wprowadz nazwe kursu: ");
                    String nazwaKursu = scan.nextLine();
                    System.out.println("Wprowadz kod kursu: ");
                    String kodKursu = scan.nextLine();
                    System.out.println("Wprowadz liczbe godzin: ");
                    int liczbaGodzin = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Wprowadz liczbe punktow ects: ");
                    int ects = scan.nextInt();
                    scan.nextLine();
                    kursVector.add(prowadzacy.dodawanieKursu(nazwaKursu, kodKursu, ects, liczbaGodzin, prowadzacy.getWydzial()));
                    break;
                case 3:
                    System.out.println("Wybierz grupe:");
                    kodGrupy = scan.nextLine();
                    System.out.println("Co do zmiany? [nazwaGrupy, kodGrupy, liczbaMiejsc, termin, sala, prowadzaczy, kurs]:");
                    String doZmiany = scan.nextLine();
                    if(doZmiany.equals("prowadzacy")) {
                        System.out.println("Wprowadz imie nowego prowadzacego: ");
                        String imie = scan.nextLine();
                        System.out.println("Wprowadz nazwisko nowego prowadzacego: ");
                        String nazwisko = scan.nextLine();
                        prowadzacy.modyfikacjaGrupy(getGrupaById(kodGrupy), getProwadzacyByImieNazwisko(imie, nazwisko));
                    } else if(doZmiany.equals("kurs")){
                        System.out.println("Wprowadz kod kursu");
                        kodKursu = scan.nextLine();
                        prowadzacy.modyfikacjaGrupy(getGrupaById(kodGrupy), getKursById(kodKursu));

                    } else{
                        System.out.println("Podaj nowa wartosc:");
                        String nowaWartosc = scan.nextLine();
                        prowadzacy.modyfikacjaGrupy(getGrupaById(kodGrupy), doZmiany ,nowaWartosc);
                    }

                    break;
                case 4:
                    System.out.println("Wybierz kurs:");
                    kodKursu = scan.nextLine();
                    System.out.println("Co do zmiany? [nazwaKursu, kodKursu, ECTS, liczbaGodzin, wydzial]:");
                    doZmiany = scan.nextLine();
                    if(doZmiany.equals("wydzial")) {
                        System.out.println("Wprowadz nazwe wydzialu: ");
                        String nazwaWydzialu = scan.nextLine();
                        System.out.println("Wprowadz skrot wydzialu: ");
                        String skrot = scan.nextLine();
                        prowadzacy.modyfikacjaKursu(getKursById(kodKursu), new Wydzial(nazwaWydzialu, skrot));
                    }
                    else {
                        System.out.println("Wprowadz nowa wartosc:");
                        String nowaWartosc = scan.nextLine();
                        prowadzacy.modyfikacjaKursu(getKursById(kodKursu), doZmiany, nowaWartosc);
                    }
                    break;
                case 5:
                    System.out.println("Wprowadz indeks sluchacza: ");
                    int indeks = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Wprowadz kod grupy: ");
                    kodGrupy = scan.nextLine();
                    prowadzacy.zapisPonadStan(getSluchaczByIndex(indeks),getGrupaById(kodGrupy));
                    break;
                case 6:
                    System.out.println("Wprowadz indeks sluchacza: ");
                    indeks = scan.nextInt();
                    scan.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    System.out.println("Wprowadz termin [yyyy-MM-dd HH:mm]: ");
                    terminString = scan.nextLine();
                    prowadzacy.przydzielenieTerminuZapisow(getSluchaczByIndex(indeks), LocalDateTime.parse(terminString,formatter));
                    break;
                case 7:
                    System.out.println("Podaj ID grupy: ");
                    String id = scan.nextLine();
                    if(id.isEmpty())
                        System.out.println("Grupa o podanym ID nie istnieje!");
                    else
                        prowadzacy.pokazInfoOGrupie(getGrupaById(id));
                    break;
                case 8:
                    System.out.println("Podaj ID kursu: ");
                    id = scan.nextLine();
                    if(id.isEmpty())
                        System.out.println("Kurs o podanym ID nie istnieje!");
                    else
                        prowadzacy.pokazInfoOKursie(getKursById(id));
                case 0:
                    return;
                default:
                    System.out.println("Wybierz poprawna opcje!");
            }
        }
    }

    public static void menu_student(Sluchacz sluchacz){
        Scanner scan = new Scanner(System.in);
        System.out.println("Witaj w systemie EdukacjaCentyLitr!");
        while(true) {
            System.out.println("1 -> Przegladaj grupy, do ktorych jestes zapisany");
            System.out.println("2 -> Wypisz z grupy");
            System.out.println("3 -> Zapisz do grupy");
            System.out.println("4 -> Wyświetl informacje o grupie");
            System.out.println("5 -> Wyświetl informacje o kursie");
            System.out.println("0 -> Wyloguj");
            System.out.println("Wybierz opcje: ");
            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    sluchacz.przegladajZapisane();
                    break;
                case 2:
                    System.out.println("Podaj ID grupy: ");
                    String id = scan.nextLine();
                    if(id.isEmpty())
                        System.out.println("Grupa o podanym ID nie istnieje!");
                    else sluchacz.wypisZGrupy(getGrupaById(id));
                    break;
                case 3:
                    System.out.println("Podaj ID grupy: ");
                    id = scan.nextLine();
                    if(id.isEmpty())
                        System.out.println("Grupa o podanym ID nie istnieje!");
                    else
                        sluchacz.zapisDoGrupy(getGrupaById(id));
                    break;
                case 4:
                    System.out.println("Podaj ID grupy: ");
                    id = scan.nextLine();
                    if(id.isEmpty())
                        System.out.println("Grupa o podanym ID nie istnieje!");
                    else
                        sluchacz.pokazInfoOGrupie(getGrupaById(id));
                    break;
                case 5:
                    System.out.println("Podaj ID kursu: ");
                    id = scan.nextLine();
                    if(id.isEmpty())
                        System.out.println("Kurs o podanym ID nie istnieje!");
                    else
                        sluchacz.pokazInfoOKursie(getKursById(id));
                case 0:
                    return;
                default:
                    System.out.println("Wybierz poprawna opcje!");
            }
        }

    }

    public static Sluchacz getSluchaczByIndex(int indeks){
        for (int i = 0; i < sluchaczVector.size(); i++) {
            if (sluchaczVector.elementAt(i).getIndeks() == indeks) {
                return sluchaczVector.elementAt(i);
                }
            }
        return null;
    }

    public static Grupa getGrupaById(String id){
        for (int i = 0; i < grupaVector.size(); i++) {
            if (grupaVector.elementAt(i).getKodGrupy().equals(id)) {
                return grupaVector.elementAt(i);
            }
        }
        return null;
    }

    public static Kurs getKursById(String id){
        for (int i = 0; i < kursVector.size(); i++) {
            if (kursVector.elementAt(i).getKodKursu().equals(id)) {
                return kursVector.elementAt(i);
            }
        }
        return null;
    }
    public static Prowadzacy getProwadzacyByImieNazwisko(String imie, String nazwisko){
        for (int i = 0; i < prowadzacyVector.size(); i++) {
            if (prowadzacyVector.elementAt(i).getImie().equals(imie) &&
                prowadzacyVector.elementAt(i).getNazwisko().equals(nazwisko)) {

                return prowadzacyVector.elementAt(i);
            }
        }
        return null;
    }
}