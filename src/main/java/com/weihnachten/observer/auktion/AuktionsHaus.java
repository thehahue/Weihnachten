package com.weihnachten.observer.auktion;

public class AuktionsHaus {
    public static void main(String[] args) {
        Artikel porsche = new Artikel("911 Carrera 4S BJ 1997", 50000.0);

        Auktion porscheAuktion = new Auktion(porsche, 45000.0, 5000.0);

        Verkaeufer karli = new Verkaeufer(80000.0);

        Bieter fritzi = new Bieter("Fritzi", 100000.0);
        Bieter susi = new Bieter("Susi", 200000.0);
        Bieter hansi = new Bieter("Hansi", 90000.0);

        porscheAuktion.registerObserver(karli);
        porscheAuktion.registerObserver(susi);
        porscheAuktion.registerObserver(hansi);
        porscheAuktion.registerObserver(fritzi);

        porscheAuktion.start();

        System.out.println("Fritzi macht sein erstes Gebot:\n---------------------");
        porscheAuktion.gebot(fritzi, 20000.0);
        System.out.println("Fritzi macht sein zweites Gebot:\n---------------------");
        porscheAuktion.gebot(fritzi, 45000.0);
        System.out.println("Susi macht ihr erstes Gebot:\n---------------------");
        porscheAuktion.gebot(susi, 50000.0);
        System.out.println("Susi macht ihr zweites Gebot:\n---------------------");
        porscheAuktion.gebot(susi, 53000.0);
        System.out.println("Susi macht ihr drittes Gebot:\n---------------------");
        porscheAuktion.gebot(susi, 60000.0);

        System.out.println("Hansi hat die Gruppe verlassen:\n---------------------");
        porscheAuktion.removeObserver(hansi);

        System.out.println("Fritzi macht sein drittes Gebot:\n---------------------");
        porscheAuktion.gebot(fritzi, 65000.0);

        System.out.println("Hansi macht sein erstes Gebot:\n---------------------");
        porscheAuktion.gebot(hansi,100000.0);
        System.out.println("Hansi macht sein zweites Gebot:\n---------------------");
        porscheAuktion.gebot(hansi,90000.0);

        System.out.println("Zum Ersten, zum Zweiten und zum Dritten.");
        porscheAuktion.ende();

        System.out.println("Fritzi macht sein viertes Gebot:\n---------------------");
        porscheAuktion.gebot(fritzi, 95000.0);

    }
}
