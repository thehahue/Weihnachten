package com.weihnachten.observer.auktion;

public class Artikel {
    private String name;
    private double schaetzpreis;

    public Artikel(String name, double schaetzpreis) {
        this.name = name;
        this.schaetzpreis = schaetzpreis;
    }

    public String getName() {
        return name;
    }

    public double getSchaetzpreis() {
        return schaetzpreis;
    }
}
