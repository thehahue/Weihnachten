package com.weihnachten.observer.unwetter;

public class BlaulichtOrganisation implements WetterObserver {
    private String name;

    public BlaulichtOrganisation(String name) {
        this.name = name;
    }

    @Override
    public void update(Unwetterstatus status) {
        if (status.isUnwetter()) {
            System.out.println(name + ": EINSATZALARM! Teams werden mobilisiert.");
            System.out.println("Lagebericht: " + status.getWetterBericht());
        } else {
            System.out.println(name + ": Wir sind in Bereitschaft.");
        }
    }
}
