package com.weihnachten.decorator;

public class RabattDekor extends GeschenkDecorator{
    public RabattDekor(Geschenk geschenk) {
        super(geschenk);
    }

    @Override
    public String getBeschreibung() {
        return super.getBeschreibung()+", Rabatt von 10%";
    }

    @Override
    public double getPreis() {
        return super.getPreis()*0.9;
    }
}
