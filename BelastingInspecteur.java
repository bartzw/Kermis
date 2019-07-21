package nl.qien.WeekopdrachtKermis;

import java.util.ArrayList;

class BelastingInspecteur extends Kermis {
    double belastingHeffen(ArrayList<Attractie> lijst) {
        double totaalBelasting = 0;
        for (Attractie a : lijst) {
            if (a instanceof GokAttractie) {
                totaalBelasting += ((GokAttractie) a).getBelasting();
                ((GokAttractie) a).setBelasting();
            }
        }
        System.out.println("Ik heb :" +totaalBelasting+ " geind. JoeJoe, de belastingInspecteur");
        return totaalBelasting;
    }
}
