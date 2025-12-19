package com.weihnachten;

import com.weihnachten.decorator.*;
import com.weihnachten.observer.*;
import com.weihnachten.strategy.*;

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

        System.out.println("\n\n=== 6) Strategy – Routenplanung für die Schlittenfahrt ===");
        
        Schlitten schlitten = new Schlitten();
        String ziel = "Nordpol City";

        System.out.println("--- Strategie: Schnellste Route ---");
        schlitten.setStrategie(new SchnellsteRoute());
        schlitten.fahreLos(ziel);

        System.out.println("\n--- Strategie: Sturm-sichere Route ---");
        schlitten.setStrategie(new SturmSicherRoute());
        schlitten.fahreLos(ziel);
        
        System.out.println("\n--- Strategie: Leiseste Route ---");
        schlitten.setStrategie(new LeisesteRoute());
        schlitten.fahreLos(ziel);


        System.out.println("\n\n=== 7) Decorator – Extra-Features am Geschenk ===");

        Geschenk meinGeschenk = new BasisGeschenk("Lego Set");
        System.out.println(meinGeschenk.getBeschreibung() + " Kosten: " + meinGeschenk.getPreis() + "€");

        System.out.println("\n--- Mit Glitzer ---");
        meinGeschenk = new GlitzerDekor(meinGeschenk);
        System.out.println(meinGeschenk.getBeschreibung() + " Kosten: " + meinGeschenk.getPreis() + "€");

        System.out.println("\n--- Mit Schleife dazu ---");
        meinGeschenk = new SchleifenDekor(meinGeschenk);
        System.out.println(meinGeschenk.getBeschreibung() + " Kosten: " + meinGeschenk.getPreis() + "€");

        System.out.println("\n--- Und mit Sound!---");
        meinGeschenk = new SoundDekor(meinGeschenk);
        System.out.println(meinGeschenk.getBeschreibung() + " Kosten: " + meinGeschenk.getPreis() + "€");
    }
}
