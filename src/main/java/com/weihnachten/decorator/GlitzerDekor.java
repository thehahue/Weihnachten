package com.weihnachten.decorator;

public class GlitzerDekor extends GeschenkDecorator {
    public GlitzerDekor(Geschenk geschenk) {
        super(geschenk);
    }

    @Override
    public String getBeschreibung() {
        return geschenk.getBeschreibung() + ", mit Glitzer";
    }

    @Override
    public double getPreis() {
        return geschenk.getPreis() + 2.50;
    }
}
