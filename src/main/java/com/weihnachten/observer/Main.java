package com.weihnachten.observer;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 5) Observer – Rentier-Tracker / Geschenkstatus-Updates ===");

        Lieferung lieferung = new Lieferung();
        ElternApp papa = new ElternApp("Papa");
        KindApp timmy = new KindApp("Timmy");

        lieferung.registerObserver(papa);
        lieferung.registerObserver(timmy);

        System.out.println("--- Statusänderung 1 ---");
        lieferung.setStatus(GeschenkStatus.VERPACKT);

        System.out.println("\n--- Statusänderung 2 ---");
        lieferung.setStatus(GeschenkStatus.UNTERWEGS);

        System.out.println("\n--- Statusänderung 3 ---");
        lieferung.setStatus(GeschenkStatus.AUSGELIEFERT);
    }
}
