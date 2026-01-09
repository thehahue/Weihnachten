package com.weihnachten.decorator.gluehwein;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);

        System.out.println("=== Der Weihnachtsmarkt Heissgetränke-Stand ===");

        Heissgetraenk bestellung1 = new Gluehwein();
        druckeBestellung(bestellung1, currencyFormatter);

        Heissgetraenk bestellung2 = new Gluehwein();
        bestellung2 = new AmarettoSchuss(bestellung2);
        bestellung2 = new ZimtStange(bestellung2);
        druckeBestellung(bestellung2, currencyFormatter);

        Heissgetraenk bestellung3 = new Kinderpunsch();
        bestellung3 = new SahneHaube(bestellung3);
        druckeBestellung(bestellung3, currencyFormatter);

        Heissgetraenk bestellung4 = new Gluehwein();
        bestellung4 = new AmarettoSchuss(bestellung4);
        bestellung4 = new SahneHaube(bestellung4);
        bestellung4 = new ZimtStange(bestellung4);
        druckeBestellung(bestellung4, currencyFormatter);
    }

    private static void druckeBestellung(Heissgetraenk g, NumberFormat formatter) {
        System.out.println("Bestellung: " + g.getBeschreibung());
        System.out.println("Preis:      " + formatter.format(g.getPreis()));
        System.out.println("---------------------------------------------");
    }
}
