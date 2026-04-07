import java.util.Objects;

public class Polisa {

    private String numerPolisy;
    private String klient;
    private double skladkaBazowa;
    private int poziomRyzyka;
    private double wartoscPojazdu;
    private boolean czyMaAlarm;
    private boolean czyBezszkodowyKlient;
    private static int liczbaUtworzonychPolis = 0;
    private static final double OPLATA_ADMINISTRACYJNA = 200;

    public Polisa(String numerPolisy, String klient, double skladkaBazowa, int poziomRyzyka, double wartoscPojazdu, boolean czyMaAlarm, boolean czyBezszkodowyKlient) {

        this.numerPolisy = numerPolisy;
        this.klient = klient;
        this.skladkaBazowa = skladkaBazowa;
        this.poziomRyzyka = poziomRyzyka;
        this.wartoscPojazdu = wartoscPojazdu;
        this.czyMaAlarm = czyMaAlarm;
        this.czyBezszkodowyKlient = czyBezszkodowyKlient;
        liczbaUtworzonychPolis++;

    }

    public double getSkladkaBazowa() {
        return skladkaBazowa;
    }

    public int getPoziomRyzyka() {
        return poziomRyzyka;
    }

    public double getWartoscPojazdu() {
        return wartoscPojazdu;
    }

    public boolean isCzyMaAlarm() {
        return czyMaAlarm;
    }

    public boolean isCzyBezszkodowyKlient() {
        return czyBezszkodowyKlient;
    }

    public double obliczSkladkeKoncowa() {
        double skladkaKoncowa = this.skladkaBazowa + OPLATA_ADMINISTRACYJNA + this.poziomRyzyka * 120;
        if (this.wartoscPojazdu > 50000) {
            skladkaKoncowa = skladkaKoncowa + 200;
        }
        if (this.czyMaAlarm = true) {
            skladkaKoncowa = skladkaKoncowa - 100;
        }
        if (this.czyBezszkodowyKlient = true) {
            skladkaKoncowa = skladkaKoncowa - (skladkaKoncowa * (5/100));
        }
        if (skladkaKoncowa < this.skladkaBazowa) {
            skladkaKoncowa = this.skladkaBazowa;
        }
        return skladkaKoncowa;
    }

    public double obliczSkladkeOdnowieniowa() {
        double skladkaOdnowieniowa = this.obliczSkladkeKoncowa();
        if (this.poziomRyzyka >= 5) {
            skladkaOdnowieniowa = skladkaOdnowieniowa + (skladkaOdnowieniowa * (20/100));
        }
        if (this.poziomRyzyka == 4) {
            skladkaOdnowieniowa = skladkaOdnowieniowa + (skladkaOdnowieniowa * (10/100));
        }
        if (wartoscPojazdu > 60000) {
            skladkaOdnowieniowa = skladkaOdnowieniowa + 150;
        }
        if (this.czyBezszkodowyKlient = true) {
            skladkaOdnowieniowa = skladkaOdnowieniowa - (skladkaOdnowieniowa * (8/100));
        }
        if (this.czyBezszkodowyKlient = true) {
            skladkaOdnowieniowa = skladkaOdnowieniowa - (skladkaOdnowieniowa * (5/100));
        }
        if (skladkaOdnowieniowa < (this.obliczSkladkeKoncowa() * 0.9)) {
            skladkaOdnowieniowa = (this.obliczSkladkeKoncowa() * 0.9);
        }
        if (skladkaOdnowieniowa > (this.obliczSkladkeKoncowa() * 1.25)) {
            skladkaOdnowieniowa = (this.obliczSkladkeKoncowa() * 1.25);
        }
        return Math.round(skladkaOdnowieniowa * 100.0) / 100;
    }

    public String pobierzPodsumowanieRyzyka() {
        return "Podsumowanie ryzyka = {poziom ryzyka: " + poziomRyzyka + ", bezszkodowy?: " + czyBezszkodowyKlient + ", alarm?: " + czyMaAlarm + "}";
    }

    public static int pobierzLiczbeUtworzonychPolis() {
        return liczbaUtworzonychPolis;
    }

    @Override
    public String toString() {
        return "Polisa{" +
                "numerPolisy='" + numerPolisy + '\'' +
                ", klient='" + klient + '\'' +
                ", skladkaBazowa=" + skladkaBazowa +
                ", poziomRyzyka=" + poziomRyzyka +
                ", wartoscPojazdu=" + wartoscPojazdu +
                ", czyMaAlarm=" + czyMaAlarm +
                ", czyBezszkodowyKlient=" + czyBezszkodowyKlient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Polisa polisa = (Polisa) o;
        return Objects.equals(numerPolisy, polisa.numerPolisy);
    }

}
