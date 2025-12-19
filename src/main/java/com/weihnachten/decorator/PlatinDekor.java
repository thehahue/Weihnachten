package com.weihnachten.decorator;

public class PlatinDekor extends GeschenkDecorator{
    public PlatinDekor(Geschenk geschenk) {
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
