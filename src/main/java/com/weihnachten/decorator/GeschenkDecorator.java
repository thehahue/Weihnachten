package com.weihnachten.decorator;

public abstract class GeschenkDecorator implements Geschenk {
    protected Geschenk geschenk;

    public GeschenkDecorator(Geschenk geschenk) {
        this.geschenk = geschenk;
    }

    @Override
    public String getBeschreibung() {
        return geschenk.getBeschreibung();
    }

    @Override
    public double getPreis() {
        return geschenk.getPreis();
    }
}
