package com.weihnachten.strategy.demo;

public class AdventDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.75; // 25% discount
    }

    @Override
    public String getName() {
        return "Advents-Special";
    }

    @Override
    public String getDescription() {
        return "25% Rabatt an den Adventssonntagen!";
    }
}
