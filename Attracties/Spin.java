package nl.qien.WeekopdrachtKermis.Attracties;
import nl.qien.WeekopdrachtKermis.*;

import java.util.Scanner;

public class Spin extends RisicoRijkeAttracties implements GokAttractie {
    private String naam = "Spin";
    private double omzet;
    private int kaart;
    private boolean gekeurd = false;
    private double belasting;
    private final static int MAXDRAAIEN = 5;
    private int gedraait = 0;
    private double prijs = 2.25;

    public void draaien() throws TeveelGedraaidException {
        Scanner reader1 = new Scanner(System.in);
        if (gekeurd) {
            if (gedraait < MAXDRAAIEN) {
                belasting = belasting + kansSpelBelastingBetalen();
                omzet = omzet + (prijs - kansSpelBelastingBetalen());
                kaart = kaart + 1;
                double omzeta = (double)Math.round(omzet * 100d) / 100d;
                System.out.println("De attractie: " + naam + " draait. Er is " + omzeta + " euro verdient met deze attractie en heeft " + kaart + " kaarten verkocht.");
                gedraait++;
            } else {
                setKeuring();
                throw new TeveelGedraaidException("De attractie " + naam + " heeft " + MAXDRAAIEN + " keer gedraait en moet gekeurd worden, druk op - m om hem te keuren.");
            }
        } else {
            System.out.println("");
            System.out.println("LET OP: de attractie: " + naam + " moet nog gekeurd worden.");
            System.out.println("Wil je een de attractie laten keuren? typ - j om de opstelling te keuren:");
            String ja = reader1.nextLine();
            if (ja.equals("j")) {
                opstellingsKeuring();
                System.out.println("De opstelling is gekeurd en kan gebruikt worden :)");
            } else {
                System.out.println("De opstelling word niet gekeurd :(");
            }
        }
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
    public boolean getKeuringNodig() {
        return gekeurd;
    }
    public void opstellingsKeuring() {
        gekeurd = true;
        gedraait = 0;
        System.out.println("De attractie " + naam + " is gekeurd.");
    }
    public void setKeuring() {
        gekeurd = false;
    }
    @Override
    public double kansSpelBelastingBetalen() {
        return prijs / 100 * 30;
    }
    @Override
    public void setBelasting() {
        belasting = 0;
    }
    @Override
    public double getBelasting() {
        return belasting;
    }
}