package com.weihnachten.observer.auktion;

public class Zuschauer implements Observer {

    @Override
    public void update(AuktionStatus status, Auktion auktion) {
        System.out.println("Zuschauer " + status);

        if (status == AuktionStatus.BEENDET) {
            System.out.println("ENDE das ist der letzte Stand der Auktion:\n" + auktion);
        }
    }
}
