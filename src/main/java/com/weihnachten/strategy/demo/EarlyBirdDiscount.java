package com.weihnachten.strategy.demo;

public class EarlyBirdDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.90; // 10% discount
    }

    @Override
    public String getName() {
        return "Frühbucher-Rabatt";
    }

    @Override
    public String getDescription() {
        return "10% Rabatt für alle, die schon im November an Weihnachten denken.";
    }
}
