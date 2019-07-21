package nl.qien.WeekopdrachtKermis;

public abstract class Attractie {
    private String naam = "Attractie";
    private double omzet;
    private int kaart;

    public String getNaam() {
        return naam;
    }

    public double getOmzet() {
        return omzet;
    }

    public void draaien() throws TeveelGedraaidException {
        System.out.println("De attractie: " + naam + " draait.");
    }

    public int getKaarten() {
        return kaart;
    }
}

