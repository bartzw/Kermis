package nl.qien.WeekopdrachtKermis.Attracties;
import nl.qien.WeekopdrachtKermis.*;

import java.util.Scanner;

public class Hawaii extends RisicoRijkeAttracties {
    private String naam = "Hawaii";
    private int kaart;
    private double omzet;
    private boolean gekeurd = false;
    private final static int MAXDRAAIEN = 10;
    private int gedraait = 0;
    private double prijs = 2.90;

    public void draaien() throws TeveelGedraaidException {
        Scanner reader1 = new Scanner(System.in);
        if (gekeurd) {
            if (gedraait < MAXDRAAIEN) {
                omzet = omzet + prijs;
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
}