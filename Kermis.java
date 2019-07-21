package nl.qien.WeekopdrachtKermis;
import nl.qien.WeekopdrachtKermis.Attracties.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Kermis {
    private ArrayList<Attractie> attractielijst;

    void maakKermis() {
        attractielijst = new ArrayList<>();
        Botsauto botsauto = new Botsauto();
        attractielijst.add(botsauto);
        Spin spin = new Spin();
        attractielijst.add(spin);
        Spiegelpaleis spiegelpaleis = new Spiegelpaleis();
        attractielijst.add(spiegelpaleis);
        Spookhuis spookhuis = new Spookhuis();
        attractielijst.add(spookhuis);
        Hawaii hawaii = new Hawaii();
        attractielijst.add(hawaii);
        Ladderklimmen ladderklimmen = new Ladderklimmen();
        attractielijst.add(ladderklimmen);
    }

    private Kassa maakKassa() {
        Kassa kassa = new Kassa();
        return kassa;
    }
    private BelastingInspecteur maakBelastingInspecteur() {
        BelastingInspecteur belastingInspecteur = new BelastingInspecteur();
        return belastingInspecteur;
    }

    void bezoekKermis() {
        Scanner reader = new Scanner(System.in);
        maakKermis();
        Kassa kassa = maakKassa();
        BelastingInspecteur belastingInspecteur = maakBelastingInspecteur();
        welkomstscherm();
        int a = 1;
        while (a == 1) {
            if (reader.hasNextInt()) {
                int invoer = reader.nextInt();
                if (invoer > 0 && invoer < 7) {
                    invoer = invoer - 1;
                    if (attractielijst.get(invoer) instanceof RisicoRijkeAttracties) {
                        boolean b = ((RisicoRijkeAttracties) attractielijst.get(invoer)).getKeuringNodig();
                    }
                    try {
                        attractielijst.get(invoer).draaien();
                    } catch (TeveelGedraaidException e) {
                        e.printStackTrace();
                        Scanner reader3 = new Scanner(System.in);
                        String ja = reader3.nextLine();
                        if (ja.equals("m")) {
                            ((RisicoRijkeAttracties) attractielijst.get(invoer)).opstellingsKeuring();
                            System.out.println("De opstelling is gekeurd en kan gebruikt worden :)");
                        } else {
                            System.out.println("De opstelling word niet gekeurd :(");
                        }

                    }
                    invoer = 0;
                }
            } else {
                String invoer = reader.nextLine();
                if(invoer.equals("b")) {
                    belastingInspecteur.belastingHeffen(attractielijst);
                }
                if(invoer.equals("c")) {
                    welkomstscherm();
                }
                if(invoer.equals("o")) {
                    kassa.KassaOmzet(attractielijst);
                    kassa.KassaKaartjes(attractielijst);
                    kassa.KassaBelasting(attractielijst);
                }
                if(invoer.equals("x")) {
                a++;
                    System.out.println("Het is tijd om naar bed te gaan, de kermis is gesloten!");
                break;
                }
            }
        }
    }

    private void welkomstscherm() {
        System.out.println("===Welkom bij de Kermis===");
        System.out.println("Welke attractie wilt u laten draaien?");
        int i = 1;
        for (Attractie a : attractielijst) {

            System.out.println(i + ". " + a.getNaam());
            i++;
        }
        System.out.println("====================");
        System.out.println("b. belasting afdragen.");
        System.out.println("c. commando's bekijken.");
        System.out.println("o. Totalen kermis bekijken.");
        System.out.println("x. Kermis afsluiten.");
        System.out.println("Typ het nummer: ");
    }
}