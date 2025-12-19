package com.weihnachten.decorator;

public class PlatinDecorator extends GeschenkDecorator{
    public PlatinDecorator(Geschenk geschenk) {
        super(geschenk);
    }

    @Override
    public String getBeschreibung() {
        return geschenk.getBeschreibung() + ", mit Platin";
    }

    @Override
    public double getPreis() {
        return geschenk.getPreis() * 2;
    }
}
