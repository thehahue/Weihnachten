package com.weihnachten.decorator.gluehwein;

public class AmarettoSchuss extends GetraenkeDecorator {
    public AmarettoSchuss(Heissgetraenk getraenk) {
        super(getraenk);
    }

    @Override
    public String getBeschreibung() {
        return super.getBeschreibung() + " + Schuss Amaretto";
    }

    @Override
    public double getPreis() {
        return super.getPreis() + 1.50;
    }
}
