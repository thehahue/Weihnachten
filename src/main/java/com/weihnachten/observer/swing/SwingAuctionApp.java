package com.weihnachten.observer.swing;

import javax.swing.*;

public class SwingAuctionApp {
    public static void main(String[] args) {
        // Look and Feel auf System-Standard setzen
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            /* ignored */ }

        // Das Subjekt (Die Auktion)
        Auction porscheAuktion = new Auction("Porsche 911 Carrera", 50000.0);

        // Die Zentrale (Ein Observer, der auch das Subject kennt)
        AuctionControlWindow control = new AuctionControlWindow(porscheAuktion);
        porscheAuktion.addObserver(control);

        // Die Bieter (Mehrere Observer)
        BidderWindow bidder1 = new BidderWindow("Fritzi", porscheAuktion);
        BidderWindow bidder2 = new BidderWindow("Susi", porscheAuktion);
        BidderWindow bidder3 = new BidderWindow("Hansi", porscheAuktion);

        porscheAuktion.addObserver(bidder1);
        porscheAuktion.addObserver(bidder2);
        porscheAuktion.addObserver(bidder3);

        // Positionieren der Fenster (optional für Übersichtlichkeit)
        control.setLocation(100, 100);
        bidder1.setLocation(550, 100);
        bidder2.setLocation(550, 350);
        bidder3.setLocation(550, 600);
    }
}
