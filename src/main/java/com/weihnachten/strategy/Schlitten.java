package com.weihnachten.strategy;

public class Schlitten {
    private RoutenStrategie strategie;

    public void setStrategie(RoutenStrategie strategie) {
        this.strategie = strategie;
    }

    public void fahreLos(String ziel) {
        if (strategie == null) {
            System.out.println("Keine Route gewählt! Der Schlitten bleibt stehen.");
            return;
        }
        strategie.berechneRoute(ziel);
        System.out.println("Der Schlitten fährt nach " + ziel + ".");
    }
}
