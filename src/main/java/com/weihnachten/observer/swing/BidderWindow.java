package com.weihnachten.observer.swing;

import javax.swing.*;
import java.awt.*;

public class BidderWindow extends JFrame implements Observer {
    private String bidderName;
    private JLabel priceLabel;
    private JLabel bidderLabel;
    private JLabel statusLabel;
    private JTextField bidField;
    private JButton bidButton;

    public BidderWindow(String name, Auction auction) {
        this.bidderName = name;
        setTitle("Bieter: " + name);
        setSize(300, 200);
        setLayout(new GridLayout(5, 1));

        priceLabel = new JLabel("Preis: " + auction.getCurrentPrice(), SwingConstants.CENTER);
        bidderLabel = new JLabel("Höchstbietender: " + auction.getHighestBidder(), SwingConstants.CENTER);
        statusLabel = new JLabel("Status: " + auction.getStatus(), SwingConstants.CENTER);

        bidField = new JTextField();
        bidButton = new JButton("Gebot abgeben");

        bidButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(bidField.getText());
                auction.placeBid(bidderName, amount);
                bidField.setText(""); // Feld leeren bei Erfolg
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Bitte einen gültigen Zahlenwert eingeben!", "Fehler",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Ungültiges Gebot", JOptionPane.WARNING_MESSAGE);
            }
        });

        add(statusLabel);
        add(priceLabel);
        add(bidderLabel);
        add(bidField);
        add(bidButton);

        update(auction); // Initiale Anzeige
        setVisible(true);
    }

    @Override
    public void update(Auction auction) {
        priceLabel.setText("Preis: " + auction.getCurrentPrice() + " €");
        bidderLabel.setText("Höchstbietender: " + auction.getHighestBidder());
        statusLabel.setText("Status: " + auction.getStatus());

        boolean isRunning = auction.getStatus() == AuctionStatus.RUNNING;
        bidButton.setEnabled(isRunning);
        bidField.setEnabled(isRunning);

        if (auction.getStatus() == AuctionStatus.CLOSED) {
            if (auction.getHighestBidder().equals(bidderName)) {
                getContentPane().setBackground(Color.GREEN);
                statusLabel.setText("GEWONNEN!");
            } else {
                getContentPane().setBackground(Color.LIGHT_GRAY);
                statusLabel.setText("Auktion Beendet");
            }
        }
    }
}
