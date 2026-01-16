package com.weihnachten.observer.auktion;

import java.util.ArrayList;
import java.util.List;

public class Auktion implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private Artikel artikel;
    private double aktuellerPreis;
    private double mindestPreis;
    private double schrittweite;
    private AuktionStatus status;

    public Auktion(Artikel artikel, double mindestPreis, double schrittweite) {
        this.artikel = artikel;
        this.mindestPreis = mindestPreis;
        this.schrittweite = schrittweite;
        this.status = AuktionStatus.ERZEUGT;
    }

    public void gebot(Bieter bieter, double gebotsPreis) {
        if (gebotsPreis < mindestPreis) {
            System.out.println("Gebot nicht gültig, da zu klein.");
            return;
        }
        if (gebotsPreis > bieter.getBudget()) {
            System.out.println("Gebot liegt über dem Budget.");
            return;
        }
        if (status == AuktionStatus.BEENDET) {
            System.out.println("Kein Gebot mehr möglich. Auktion ist beendet.");
            return;
        }
        this.status = AuktionStatus.LAUFEND;
        this.aktuellerPreis = gebotsPreis;
        this.mindestPreis = aktuellerPreis + schrittweite;

        System.out.println("Gebot angenommen. Aktueller Preis " + aktuellerPreis + ", neues Mindestgebot " + mindestPreis);

        notifyObservers();
    }

    public void start() {
        this.status = AuktionStatus.EROEFFNET;
        this.aktuellerPreis = mindestPreis;
        System.out.println("Auktion gestartet.");
        notifyObservers();
    }

    public void ende() {
        this.status = AuktionStatus.BEENDET;
        System.out.println("Auktion beendet.");
        notifyObservers();
    }

    public double getAktuellerPreis() {
        return aktuellerPreis;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status, this);
        }
    }

    @Override
    public String toString() {
        return "Auktion{" +
                "mindestPreis=" + mindestPreis +
                ", aktuellerPreis=" + aktuellerPreis +
                '}';
    }
}
