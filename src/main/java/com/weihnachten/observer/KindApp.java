package com.weihnachten.observer;

public class KindApp implements Observer {
    private String name;

    public KindApp(String name) {
        this.name = name;
    }

    @Override
    public void update(GeschenkStatus status) {
        if (status == GeschenkStatus.UNTERWEGS) {
            System.out.println("KindApp (" + name + "): Juhu! Das Geschenk ist unterwegs!");
        } else {
            System.out.println("KindApp (" + name + "): Status-Update: " + status);
        }
    }

    public void sendeGeld() {
        System.out.println("Danke Oma fürs Geld!");
    }
}
