package com.weihnachten.decorator.gluehwein;

public class ZimtStange extends GetraenkeDecorator {
    public ZimtStange(Heissgetraenk getraenk) {
        super(getraenk);
    }

    @Override
    public String getBeschreibung() {
        return super.getBeschreibung() + " + frische Zimtstange";
    }

    @Override
    public double getPreis() {
        return super.getPreis() + 0.30;
    }
}
