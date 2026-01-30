package com.weihnachten.strategy.demo;

public class LastMinuteSurcharge implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 1.20; // 20% surcharge
    }

    @Override
    public String getName() {
        return "Last Minute Express";
    }

    @Override
    public String getDescription() {
        return "20% Aufschlag für die Lieferung am Heiligabend per Rentier-Express!";
    }
}
