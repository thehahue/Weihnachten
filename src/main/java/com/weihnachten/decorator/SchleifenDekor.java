package com.weihnachten.decorator;

public class SchleifenDekor extends GeschenkDecorator {
    public SchleifenDekor(Geschenk geschenk) {
        super(geschenk);
    }

    @Override
    public String getBeschreibung() {
        return geschenk.getBeschreibung() + ", mit roter Schleife";
    }

    @Override
    public double getPreis() {
        return geschenk.getPreis() + 1.50;
    }
}
