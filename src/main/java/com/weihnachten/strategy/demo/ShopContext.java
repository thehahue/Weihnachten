package com.weihnachten.strategy.demo;

public class ShopContext {
    private DiscountStrategy strategy;

    public ShopContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFinalPrice(double basePrice) {
        if (strategy == null) {
            return basePrice;
        }
        return strategy.applyDiscount(basePrice);
    }

    public String getStrategyName() {
        return strategy != null ? strategy.getName() : "Keine Strategie";
    }

    public String getStrategyDescription() {
        return strategy != null ? strategy.getDescription() : "";
    }
}
