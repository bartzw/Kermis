package nl.qien.WeekopdrachtKermis.Attracties;

import nl.qien.WeekopdrachtKermis.Attractie;

public class Spiegelpaleis extends Attractie {
    private String naam = "Spiegelpaleis";
    private double omzet;
    private int kaart;
    private double prijs = 2.75;

    public void draaien() {
        omzet = omzet + prijs;
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
}