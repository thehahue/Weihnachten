package com.weihnachten.decorator.gluehwein;

public class Gluehwein implements Heissgetraenk {
    @Override
    public String getBeschreibung() {
        return "Roter Glühwein";
    }

    @Override
    public double getPreis() {
        return 3.00;
    }
}
