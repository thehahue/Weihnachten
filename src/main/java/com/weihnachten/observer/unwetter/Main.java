package com.weihnachten.observer.unwetter;

public class Main {
    public static void main(String[] args) {
        Unwetterstatus wetterSystem = new Unwetterstatus();

        WetterObserver meinHandy = new Handy("+4366012345678");
        WetterObserver orf = new Fernsehsender("ORF");
        WetterObserver feuerwehr = new BlaulichtOrganisation("Freiwillige Feuerwehr");

        wetterSystem.registerObserver(meinHandy);
        wetterSystem.registerObserver(orf);
        wetterSystem.registerObserver(feuerwehr);

        System.out.println("--- Tag 1: Schönes Wetter ---");
        wetterSystem.setWetterDaten(10.0, 10.0, 1013.0, 0.0);

        System.out.println("\n--- Tag 2: Der Sturm zieht auf (noch unter Schwelle) ---");
        wetterSystem.setWetterDaten(8.0, 50.0, 1000.0, 10.0);

        System.out.println("\n--- Tag 2 Abend: UNWETTER! ---");
        wetterSystem.setWetterDaten(5.0, 120.0, 980.0, 60.0);

        System.out.println("\n--- Tag 3: Es beruhigt sich wieder ---");
        wetterSystem.setWetterDaten(12.0, 15.0, 1010.0, 2.0);

        wetterSystem.removeObserver(meinHandy);

        System.out.println("\n--- Tag 4: HITZEWELLE! ---");
        // Temp > 35 (Schwelle)
        wetterSystem.setWetterDaten(38.0, 5.0, 1015.0, 0.0);

        // Simulator starten (Beispielhaft für 3 Durchläufe, damit das Programm terminiert)
        // In einer echten Anwendung würde man hier -1 übergeben oder in einem separaten Thread starten.
        WetterSimulator sim = new WetterSimulator(wetterSystem);
        sim.startSimulation(3);
    }
}
