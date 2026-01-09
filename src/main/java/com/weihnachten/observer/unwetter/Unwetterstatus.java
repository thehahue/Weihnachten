package com.weihnachten.observer.unwetter;

import java.util.ArrayList;
import java.util.List;

public class Unwetterstatus implements WetterSubject {
    private double temperatur;
    private double windgeschwindigkeit;
    private double luftdruck;
    private double niederschlag;
    private boolean isUnwetter;
    
    private List<WetterObserver> observers;

    // Schwellenwerte
    private static final double MAX_WIND = 60.0;
    private static final double MAX_NIEDERSCHLAG = 30.0;
    private static final double MIN_TEMPERATUR = -15.0;
    private static final double MAX_TEMPERATUR = 35.0;

    public Unwetterstatus() {
        this.observers = new ArrayList<>();
        this.isUnwetter = false;
    }

    public void setWetterDaten(double temperatur, double windgeschwindigkeit, double luftdruck, double niederschlag) {
        this.temperatur = temperatur;
        this.windgeschwindigkeit = windgeschwindigkeit;
        this.luftdruck = luftdruck;
        this.niederschlag = niederschlag;
        checkStatus();
    }

    private void checkStatus() {
        boolean aktuellUnwetter = (windgeschwindigkeit > MAX_WIND) || 
                                  (niederschlag > MAX_NIEDERSCHLAG) || 
                                  (temperatur < MIN_TEMPERATUR) ||
                                  (temperatur > MAX_TEMPERATUR);
        
        // Benachrichtigen wenn sich der Status ändert
        if (aktuellUnwetter != this.isUnwetter) {
            this.isUnwetter = aktuellUnwetter;
            notifyObservers();
        } else if (aktuellUnwetter) {
             notifyObservers();
        }
    }

    public boolean isUnwetter() {
        return isUnwetter;
    }

    public double getTemperatur() {
        return temperatur;
    }

    public double getWindgeschwindigkeit() {
        return windgeschwindigkeit;
    }

    public double getLuftdruck() {
        return luftdruck;
    }

    public double getNiederschlag() {
        return niederschlag;
    }

    public String getWetterBericht() {
        return String.format("Temperatur: %.1f°C, Wind: %.1f km/h, Luftdruck: %.1f hPa, Niederschlag: %.1f mm",
                temperatur, windgeschwindigkeit, luftdruck, niederschlag);
    }

    @Override
    public void registerObserver(WetterObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(WetterObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (WetterObserver o : observers) {
            o.update(this);
        }
    }
}
