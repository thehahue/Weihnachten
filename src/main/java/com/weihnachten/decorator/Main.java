package com.weihnachten.decorator;

public class Main {
    public static void main(String[] args) {
        BasisGeschenk ram = new BasisGeschenk("Ram");

        GlitzerDekor glitzerRam = new GlitzerDekor(ram);

        System.out.println(glitzerRam.getBeschreibung()+ ", Preis: "+glitzerRam.getPreis());

        GlitzerDekor doppelGlitzerRam = new GlitzerDekor(glitzerRam);

        System.out.println(doppelGlitzerRam.getBeschreibung()+ ", Preis: "+doppelGlitzerRam.getPreis());

        SchleifenDekor doppelGlitzerRamSchleife = new SchleifenDekor(doppelGlitzerRam);

        System.out.println(doppelGlitzerRamSchleife.getBeschreibung()+ ", Preis: "+doppelGlitzerRamSchleife.getPreis());

        SoundDekor soundRamMitDoppelGlitzerUndSchleife = new SoundDekor(doppelGlitzerRamSchleife);
        System.out.println(soundRamMitDoppelGlitzerUndSchleife.getBeschreibung()+ ", Preis: "+soundRamMitDoppelGlitzerUndSchleife.getPreis());

        PlatinDekor allesDoppelt = new PlatinDekor(soundRamMitDoppelGlitzerUndSchleife);
        System.out.println(allesDoppelt.getBeschreibung()+ ", Preis: "+allesDoppelt.getPreis());

        RabattDekor rabatt = new RabattDekor(allesDoppelt);
        System.out.println(rabatt.getBeschreibung()+ ", Preis: "+rabatt.getPreis());
    }
}
