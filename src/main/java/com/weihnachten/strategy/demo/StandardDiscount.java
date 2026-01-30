package com.weihnachten.strategy.demo;

public class StandardDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price; // No discount
    }

    @Override
    public String getName() {
        return "Standard Preis";
    }

    @Override
    public String getDescription() {
        return "Der reguläre Preis ohne Weihnachtsrabatte.";
    }
}
