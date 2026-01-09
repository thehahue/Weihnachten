package com.weihnachten.decorator.gluehwein;

public class SahneHaube extends GetraenkeDecorator {
    public SahneHaube(Heissgetraenk getraenk) {
        super(getraenk);
    }

    @Override
    public String getBeschreibung() {
        return super.getBeschreibung() + " + Sahnehaube";
    }

    @Override
    public double getPreis() {
        return super.getPreis() + 0.50;
    }
}
