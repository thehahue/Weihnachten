package com.weihnachten.observer;

public class GrannyApp implements Observer {
    private KindApp enkel;

    public GrannyApp(KindApp enkel) {
        this.enkel = enkel;
    }

    @Override
    public void update(GeschenkStatus status) {
        if (status == GeschenkStatus.AUSGELIEFERT) {
            enkel.sendeGeld();
        }
    }
}
