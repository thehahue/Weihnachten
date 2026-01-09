package com.weihnachten.observer.unwetter;

public class Fernsehsender implements WetterObserver {
    private String name;

    public Fernsehsender(String name) {
        this.name = name;
    }

    @Override
    public void update(Unwetterstatus status) {
        if (status.isUnwetter()) {
            System.out.println(name + " Breaking News: Wir unterbrechen das Programm für eine Unwetterwarnung!");
            System.out.println("Aktuelle Messwerte: " + status.getWetterBericht());
            System.out.println("Bitte bleiben Sie zu Hause.");
        } else {
            System.out.println(name + ": Wir kehren zum regulären Programm zurück.");
        }
    }
}
