package com.weihnachten.observer.swing;

import javax.swing.*;
import java.awt.*;

public class AuctionControlWindow extends JFrame implements Observer {
    private JLabel priceLabel;
    private JLabel statusLabel;
    private JButton startButton;
    private JButton closeButton;

    public AuctionControlWindow(Auction auction) {
        setTitle("Auktions-Haus Zentrale");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        statusLabel = new JLabel("Auktion für: " + auction.getItemName(), SwingConstants.CENTER);
        priceLabel = new JLabel("Aktueller Preis: " + auction.getCurrentPrice(), SwingConstants.CENTER);

        startButton = new JButton("Auktion STARTEN");
        closeButton = new JButton("Auktion BEENDEN");

        startButton.addActionListener(e -> auction.start());
        closeButton.addActionListener(e -> auction.close());

        add(statusLabel);
        add(priceLabel);
        add(startButton);
        add(closeButton);

        update(auction);
        setVisible(true);
    }

    @Override
    public void update(Auction auction) {
        priceLabel.setText(
                "Aktueller Preis: " + auction.getCurrentPrice() + " € (Bieter: " + auction.getHighestBidder() + ")");

        startButton.setEnabled(auction.getStatus() == AuctionStatus.WAITING);
        closeButton.setEnabled(auction.getStatus() == AuctionStatus.RUNNING);
    }
}
