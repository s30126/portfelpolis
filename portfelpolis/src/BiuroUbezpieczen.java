import java.util.ArrayList;
public class BiuroUbezpieczen {

    private String nazwa;
    private ArrayList<Polisa> polisy;

    public BiuroUbezpieczen(String nazwa) {
        this.nazwa = nazwa;
    }

    public void dodajPolise(Polisa polisa) {
        this.polisy.add(polisa);
    }

    /*

    public void wypiszRaport() {
        ;
    }

    public double policzLacznaSkladke() {
        ;
    }

    public double policzLacznaPrognozeOdnowien() {
        ;
    }

    public double policzPolisyWysokiegoRyzyka() {
        ;
    }

    public Polisa znajdzPoNumerze(String numerPolisy) {
        ;
    }

    public void wypiszTanszeNiz(double prog) {
        ;
    }

     */

}
