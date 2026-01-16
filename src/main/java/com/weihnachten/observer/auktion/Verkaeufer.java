package com.weihnachten.observer.auktion;

public class Verkaeufer implements Observer {
    private double wunschPreis;

    public Verkaeufer(double wunschPreis) {
        this.wunschPreis = wunschPreis;
    }

    @Override
    public void update(AuktionStatus status, Auktion auktion) {
        if (status == AuktionStatus.EROEFFNET) {
            System.out.println("*** Verkäufer sieht, dass die Auktion gestartet wurde.");
        }

        if (status == AuktionStatus.LAUFEND) {
            System.out.println("*** Verkäufer sieht das Gebot und hat einen Wunschpreis von " + wunschPreis);
            System.out.println("*** Das aktuelle Gebot ist " + auktion.getAktuellerPreis());
        }

        if (status == AuktionStatus.BEENDET) {
            if (auktion.getAktuellerPreis() >= wunschPreis) {
                System.out.println("*** Juhuu ich habe meinen Wunschpreis erhalten");
            } else {
                System.out.println("*** Ich habe " + auktion.getAktuellerPreis() + " bekommen");
            }
        }
    }
}
