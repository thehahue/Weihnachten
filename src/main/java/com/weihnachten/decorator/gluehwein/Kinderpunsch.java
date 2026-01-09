package com.weihnachten.decorator.gluehwein;

public class Kinderpunsch implements Heissgetraenk {
    @Override
    public String getBeschreibung() {
        return "Alkoholfreier Kinderpunsch";
    }

    @Override
    public double getPreis() {
        return 2.50;
    }
}
