package com.weihnachten.decorator;

public class BasisGeschenk implements Geschenk {
    private String name;

    public BasisGeschenk(String name) {
        this.name = name;
    }

    @Override
    public String getBeschreibung() {
        return "Geschenk: " + name;
    }

    @Override
    public double getPreis() {
        return 10.0; // Basispreis
    }
}
