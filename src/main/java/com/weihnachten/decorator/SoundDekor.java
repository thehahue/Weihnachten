package com.weihnachten.decorator;

public class SoundDekor extends GeschenkDecorator {
    public SoundDekor(Geschenk geschenk) {
        super(geschenk);
    }

    @Override
    public String getBeschreibung() {
        return geschenk.getBeschreibung() + ", spielt Weihnachtsmusik";
    }

    @Override
    public double getPreis() {
        return geschenk.getPreis() + 5.00;
    }
}
