package com.weihnachten.observer.swing;

public class Auction extends Subject {
    private String itemName;
    private double currentPrice;
    private String highestBidder;
    private AuctionStatus status;

    public Auction(String itemName, double startingPrice) {
        this.itemName = itemName;
        this.currentPrice = startingPrice;
        this.highestBidder = "Niemand";
        this.status = AuctionStatus.WAITING;
    }

    public void placeBid(String bidderName, double amount) {
        if (status != AuctionStatus.RUNNING) {
            throw new IllegalArgumentException("Die Auktion läuft aktuell nicht!");
        }
        if (amount <= currentPrice) {
            throw new IllegalArgumentException(
                    "Dein Gebot von " + amount + " € ist zu niedrig. Es muss höher als " + currentPrice + " € sein!");
        }

        this.currentPrice = amount;
        this.highestBidder = bidderName;
        notifyObservers(this);
    }

    public void start() {
        this.status = AuctionStatus.RUNNING;
        notifyObservers(this);
    }

    public void close() {
        this.status = AuctionStatus.CLOSED;
        notifyObservers(this);
    }

    public String getItemName() {
        return itemName;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public String getHighestBidder() {
        return highestBidder;
    }

    public AuctionStatus getStatus() {
        return status;
    }
}
