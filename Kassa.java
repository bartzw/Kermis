package nl.qien.WeekopdrachtKermis;

import java.util.ArrayList;

class Kassa extends Kermis {
    double KassaOmzet(ArrayList<Attractie> lijst) {
        double totaalOmzet = 0;
        for (Attractie a : lijst) {
            totaalOmzet += a.getOmzet();
        }
        System.out.println("totaalOmzet = " + totaalOmzet);
        totaalOmzet = (double)Math.round(totaalOmzet * 100d) / 100d;
        return totaalOmzet;
    }

    int KassaKaartjes(ArrayList<Attractie> lijst) {
        int totaalKaartjes = 0;
        for (Attractie a : lijst) {
            totaalKaartjes += a.getKaarten();
        }
        System.out.println("Totaal kaartjes verkocht = " + totaalKaartjes);
        return totaalKaartjes;
    }

    double KassaBelasting(ArrayList<Attractie> lijst) {
        double totaalBelasting = 0;
        for (Attractie a : lijst) {
            if (a instanceof GokAttractie) {
                totaalBelasting += ((GokAttractie) a).getBelasting();
            }
        }
        System.out.println("Totaal belasting gereserveerd = " + totaalBelasting);
        totaalBelasting = (double)Math.round(totaalBelasting * 100d) / 100d;
        return totaalBelasting;
    }
}