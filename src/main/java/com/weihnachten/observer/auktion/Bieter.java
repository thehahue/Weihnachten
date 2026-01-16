package com.weihnachten.observer.auktion;

public class Bieter implements Observer {
    private String name;
    private double budget;

    public Bieter(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    @Override
    public void update(AuktionStatus status, Auktion auktion) {
        if (status == AuktionStatus.EROEFFNET) {
            System.out.println("+++ Bieter " + name + " sieht, dass die Auktion von "
                    + auktion.getArtikel().getName() + " gestartet wurde.");

        }

        if (status == AuktionStatus.LAUFEND) {
            System.out.println("+++ Bieter " + name + " sieht, dass ein Gebot über "
                    + auktion.getAktuellerPreis() + " abgegeben wurde.");
        }
    }

    public double getBudget() {
        return budget;
    }
}
