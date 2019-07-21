package nl.qien.WeekopdrachtKermis.Attracties;
import nl.qien.WeekopdrachtKermis.*;
public class Ladderklimmen extends Attractie implements GokAttractie {
    private String naam = "Ladderklimmen";
    private double omzet;
    private double belasting;
    private int kaart;
    private double prijs = 5.00;

    public void draaien() {
        belasting = belasting + kansSpelBelastingBetalen();
        omzet = omzet + (prijs - kansSpelBelastingBetalen());
        kaart = kaart + 1;
        System.out.println("De attractie: " + naam + " draait. Er is " + omzet + " euro verdient met deze attractie en heeft " + kaart + " kaarten verkocht.");

    }

    public String getNaam() {
        return naam;
    }

    public double getOmzet() {
        return omzet;
    }

    public int getKaarten() {
        return kaart;
    }

    public double getBelasting() {
        return belasting;
    }
    public void setBelasting() {
        belasting = 0;

    }
    public double kansSpelBelastingBetalen() {
        return prijs / 100 * 30;
    }
}