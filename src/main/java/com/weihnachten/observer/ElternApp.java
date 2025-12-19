package com.weihnachten.observer;

public class ElternApp implements Observer {
    private String name;

    public ElternApp(String name) {
        this.name = name;
    }

    @Override
    public void update(GeschenkStatus status) {
        System.out.println("ElternApp (" + name + "): Nachricht erhalten - Geschenkstatus ist jetzt: " + status);
    }
}
