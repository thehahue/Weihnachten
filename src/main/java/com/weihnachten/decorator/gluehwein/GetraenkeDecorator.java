package com.weihnachten.decorator.gluehwein;

public abstract class GetraenkeDecorator implements Heissgetraenk {
    protected Heissgetraenk getraenk;

    public GetraenkeDecorator(Heissgetraenk getraenk) {
        this.getraenk = getraenk;
    }

    @Override
    public String getBeschreibung() {
        return getraenk.getBeschreibung();
    }

    @Override
    public double getPreis() {
        return getraenk.getPreis();
    }
}
