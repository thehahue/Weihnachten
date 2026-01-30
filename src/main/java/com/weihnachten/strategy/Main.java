package com.weihnachten.strategy;

public class Main {
    public static void main(String[] args) {
        Schlitten schlitten = new Schlitten();
        String ziel = "Nordpol City";

        System.out.println("--- Strategie: Schnellste Route ---");
        schlitten.setStrategie(new SchnellsteRoute());
        schlitten.fahreLos(ziel);

        System.out.println("\n--- Strategie: Sturm-sichere Route ---");
        schlitten.setStrategie(new SturmSicherRoute());
        schlitten.fahreLos(ziel);

        System.out.println("\n--- Strategie: Leiseste Route ---");
        schlitten.setStrategie(new LeisesteRoute());
        schlitten.fahreLos(ziel);
    }
}
