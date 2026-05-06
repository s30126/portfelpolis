import java.util.ArrayList;
public class BiuroUbezpieczen {

    private String nazwa;
    private ArrayList<Polisa> polisy;

    public BiuroUbezpieczen(String nazwa) {
        this.nazwa = nazwa;
        this.polisy = new ArrayList<>();
    }

    public void dodajPolise(Polisa polisa) {
        this.polisy.add(polisa);
    }

    public void wypiszRaport() {
        ;
    }

    public double policzLacznaSkladke() {
        double lacznaSkladka = 0;
        for (Polisa p : polisy) {
            lacznaSkladka += p.obliczSkladkeKoncowa();
        }
        return lacznaSkladka;
    }

    public double policzLacznaPrognozeOdnowien() {
        double lacznaPrognozaOdnowien = 0;
        for (Polisa p : polisy) {
            lacznaPrognozaOdnowien += p.obliczSkladkeOdnowieniowa();
        }
        return lacznaPrognozaOdnowien;
    }

    public int policzPolisyWysokiegoRyzyka() {
        int liczbaPolisWysokiegoRyzyka = 0;
        for (Polisa p : polisy) {
            if (p.getPoziomRyzyka() >= 4) {
                liczbaPolisWysokiegoRyzyka += 1;
            }
        }
        return liczbaPolisWysokiegoRyzyka;
    }

    public Polisa znajdzPoNumerze(String numerPolisy) {
        for (Polisa p : polisy) {
            if (p.getNumerPolisy() == numerPolisy) {
                return p;
            }
        }
        return null;
    }

    public void wypiszTanszeNiz(double prog) {
        for (Polisa p : polisy) {
            if (p.obliczSkladkeKoncowa() <= prog ) {
                System.out.println(p);
            }
        }
    }

}
