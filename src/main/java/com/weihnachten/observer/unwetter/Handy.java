package com.weihnachten.observer.unwetter;

public class Handy implements WetterObserver {
    private String nummer;

    public Handy(String nummer) {
        this.nummer = nummer;
    }

    @Override
    public void update(Unwetterstatus status) {
        if (status.isUnwetter()) {
            System.out.println("Handy " + nummer + ": ALARM! Unwetterwarnung! Daten: [" + status.getWetterBericht() + "]");
        } else {
            System.out.println("Handy " + nummer + ": Das Wetter ist wieder ruhig.");
        }
    }
}
