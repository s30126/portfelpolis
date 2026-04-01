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
    private static final double OPLATA_ADMINISTRACYJNA = 100;

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

    public double obliczSkladkeKoncowa() {
        return 2;
    }

    public double obliczSkladkeOdnowieniowa() {
        return 2;
    }

    public String pobierzPodsumowanieRyzyka() {
        return "1";
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
